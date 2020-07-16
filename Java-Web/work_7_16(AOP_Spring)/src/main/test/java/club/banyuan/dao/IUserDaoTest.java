package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.dao.Impl.UserDaoImpl;
import club.banyuan.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IUserDaoTest {

  @Test
  public void printAll() {}

  @Test
  public void add() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    IUserDao userDao = (IUserDao) ctx.getBean("userDaoImpl");
    userDao.printAll();
    System.out.println("-------------------");
    System.out.println(userDao.add(new User()));
    ((UserDaoImpl)userDao).count();
  }
}
