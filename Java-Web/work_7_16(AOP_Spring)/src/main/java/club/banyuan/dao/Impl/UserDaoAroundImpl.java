package club.banyuan.dao.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;

public class UserDaoAroundImpl implements IUserDao {

  @Override
  public void printAll() {
    System.out.println("add---around");
  }

  @Override
  public Integer add(User user) {
    System.out.println("add---around");
    return 2;
  }
}
