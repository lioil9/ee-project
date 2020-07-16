package club.banyuan.dao.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;

public class UserDaoImpl implements IUserDao {


  @Override
  public void printAll() {
    System.out.println("print-All");
  }

  @Override
  public Integer add(User user) {
    System.out.println("add---User");
    return 1;
  }

  public Integer count(){
    return 2;
  }
}
