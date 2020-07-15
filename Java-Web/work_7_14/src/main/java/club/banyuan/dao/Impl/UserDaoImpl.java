package club.banyuan.dao.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import org.springframework.stereotype.Repository;

//获取bean对象，功能等同于@Component，标识该类是dao类
@Repository //("userDao")
public class UserDaoImpl implements IUserDao {

  @Override
  public int add(User user) {
    System.out.println("addUser");
    return 0;
  }
}
