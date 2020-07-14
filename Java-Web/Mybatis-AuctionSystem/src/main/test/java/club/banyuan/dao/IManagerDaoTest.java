package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.entity.Manager;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IManagerDaoTest {
  InputStream ins;
  SqlSession session;
  IManagerDao managerDao;
  @Before
  public void init() throws IOException {
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    session = sqlSessionFactory.openSession();
    managerDao = session.getMapper(IManagerDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void getLogin() {
    Manager manager = managerDao.getLogin("root","12345678");
    System.out.println(manager);
  }
}