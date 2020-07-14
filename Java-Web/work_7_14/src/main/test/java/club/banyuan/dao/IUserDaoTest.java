package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IUserDaoTest {

  @Test
  public void add() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    IUserDao userDao = (IUserDao) ctx.getBean("userDao");
    userDao.add(new User());

  }
}