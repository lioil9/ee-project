package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.entity.SoldItem;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ISoldItemDaoTest {
  InputStream ins;
  SqlSession session;
  ISoldItemDao soldItemDao;
  @Before
  public void init() throws IOException {
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    session = sqlSessionFactory.openSession();
    soldItemDao = session.getMapper(ISoldItemDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void add() {
    SoldItem soldItem = new SoldItem();
    soldItem.setItemId(2);
    soldItem.setPrice(7000.0);
    soldItem.setUserId(1);

    System.out.println(soldItemDao.add(soldItem));
    System.out.println(soldItem);
  }

  @Test
  public void getAllSoldItem() {
    List<SoldItem> soldItemList =  soldItemDao.getAllSoldItem();
    for (SoldItem soldItem : soldItemList) {
      System.out.println("---------------------");
      System.out.println(soldItem);
      System.out.println(soldItem.getAuctionItem());
      System.out.println(soldItem.getUser());
      System.out.println("---------------------");
    }
  }
}