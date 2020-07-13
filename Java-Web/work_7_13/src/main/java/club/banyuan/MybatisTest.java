package club.banyuan;

import club.banyuan.dao.ItemDao;
import club.banyuan.dao.UserDao;
import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {
  public static void main(String[] args) throws IOException {
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory sqlSessionFactory = builder.build(is);
    SqlSession session = sqlSessionFactory.openSession();

    UserDao userDao = session.getMapper(UserDao.class);
    List<User> users = userDao.getAll();
    users.forEach(System.out::println);

    ItemDao itemDao = session.getMapper(ItemDao.class);
    AuctionItem auctionItem = itemDao.getAuctionItemAndBidOrders(2);
    System.out.println(auctionItem);
    auctionItem.getBidRecords().forEach(System.out::println);

  }
}
