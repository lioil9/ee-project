package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.entity.User;
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
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    session = sqlSessionFactory.openSession();
    userDao = session.getMapper(IUserDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }


  @Test
  public void addUser() {}

  @Test
  public void getLogin() {
    User user = userDao.getLogin("aaa","123");
    System.out.println(user);
  }

  @Test
  public void isExist() {
    System.out.println(userDao.isExist("aaa"));
  }

  @Test
  public void getUserById() {

  }
}