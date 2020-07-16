package club.banyuan.proxy;

import club.banyuan.dao.IUserDao;
import club.banyuan.service.IUserService;
import club.banyuan.utils.TransactionManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.ibatis.session.SqlSession;

/**
 * 动态代理基本实现
 */
public class UserServiceProxy {
  public static IUserService getProxyInstance(final IUserService userService){
    IUserService userServiceProxy =
        (IUserService)
            Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {

                  @Override
                  public Object invoke(Object proxy, Method method, Object[] args)
                      throws Throwable {
                    TransactionManager taManager = new TransactionManager();
                    SqlSession session = taManager.beginTransaction();
                    try {
                      System.out.println("开始");
                      IUserDao userDao = session.getMapper(IUserDao.class);
                      method.invoke(userService, userDao);
                      taManager.commit();
                      System.out.println("结束");
                    } catch (Exception e) {
                      System.out.println("回滚");
                      e.printStackTrace();
                      taManager.rollback();
                    } finally {
                      taManager.release();
                    }

                    return null;
                  }
                });
    return userServiceProxy;
  }

}
