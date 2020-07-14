package club.banyuan.dao.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;

public class UserDaoImpl implements IUserDao {

  @Override
  public int add(User user) {
    System.out.println("addUser");
    return 0;
  }
}
