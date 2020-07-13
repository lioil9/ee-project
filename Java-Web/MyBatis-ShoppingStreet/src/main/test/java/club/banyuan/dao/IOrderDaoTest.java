package club.banyuan.dao;


import club.banyuan.entity.Order;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IOrderDaoTest {
  InputStream ins;
  SqlSession session;
  IOrderDao orderDao;
  @Before
  public void init() throws IOException {
    // 加载配置文件
    ins = Resources.getResourceAsStream("SqlMapConfig.xml");
    // 获取用于创建SqlSessionFactory对象的类的对象
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    // 创建SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = builder.build(ins);
    // 创建SqlSession对象
    session = sqlSessionFactory.openSession();
    // 获取接口的实现类对象
    // 动态代理设计模式，获取接口的实现类对象
    orderDao = session.getMapper(IOrderDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void getOrder() {
    List<Order> orders = orderDao.getOrderByUserId(21);
    System.out.println(orders.size());
    for (Order order : orders) {
      System.out.println(order);
    }
  }

  @Test
  public void addOrder() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Order order = new Order();
    order.setUserId(21);
    order.setLoginName("fsfsfsf");
    order.setUserAddress("用户地址");
    order.setCreateTime(df.format(new Date()));
    order.setCost(2800.0);
    order.setSerialNumber("08BEA7CA9C5041C899A5CC7332433");
    System.out.println(orderDao.addOrder(order));
    System.out.println(order);
  }
}