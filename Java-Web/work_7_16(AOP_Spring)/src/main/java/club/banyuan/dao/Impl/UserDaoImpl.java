package club.banyuan.dao.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

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

}
