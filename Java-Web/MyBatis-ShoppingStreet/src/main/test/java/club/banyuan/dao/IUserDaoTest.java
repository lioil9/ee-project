package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.vo.LoginVo;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IUserDaoTest {
  InputStream ins;
  SqlSession session;
  IUserDao userDao;
  @Before
  public void init() throws IOException {
    // 加载配置文件
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    // 获取用于创建SqlSessionFactory对象的类的对象
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    // 创建SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    // 创建SqlSession对象
    session = sqlSessionFactory.openSession();
    // 获取接口的实现类对象
    // 动态代理设计模式，获取接口的实现类对象
    userDao = session.getMapper(IUserDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void add() {}

  @Test
  public void getLoginUser() {
    LoginVo loginVo = new LoginVo("aaa","123");
    System.out.println(userDao.getLoginUser(loginVo));
  }

  @Test
  public void isExist() {
    System.out.println(userDao.isExist("cgn"));
  }
}