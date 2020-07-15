package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.BidRecord;
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

public class IItemDaoTest {
  InputStream ins;
  SqlSession session;
  IItemDao itemDao;
  @Before
  public void init() throws IOException {
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    session = sqlSessionFactory.openSession();
    itemDao = session.getMapper(IItemDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void getAuctionItems() {
    AuctionItem auctionItem = new AuctionItem();
    auctionItem.setName("清明上河图");
    List<AuctionItem> auctionItemList = itemDao.getAuctionItems(auctionItem);
    for (AuctionItem item : auctionItemList) {
      System.out.println(item);
    }
  }

  @Test
  public void addAuctionItem() {
    AuctionItem auctionItem = new AuctionItem();
    auctionItem.setName("宝剑");
    auctionItem.setStartPrice(5000.0);
    auctionItem.setBasePrice(70000.0);
    System.out.println(itemDao.addAuctionItem(auctionItem));
    System.out.println("id:"+auctionItem.getId());
  }

  @Test
  public void getAuctionItemById() {
    AuctionItem auctionItem = itemDao.getAuctionItemById(2);
    for (BidRecord bidRecord : auctionItem.getBidRecords()) {
      System.out.println(bidRecord);
    }
  }

  @Test
  public void changeAuctionItem() {}

  @Test
  public void deleteAuctionItem() {}
}