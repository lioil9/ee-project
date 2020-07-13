package club.banyuan.dao;

import static org.junit.Assert.*;

import club.banyuan.entity.UserAddress;
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

public class IUserAddressDaoTest {

  InputStream ins;
  SqlSession session;
  IUserAddressDao userAddressDao;

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
    userAddressDao = session.getMapper(IUserAddressDao.class);
  }

  @After
  public void destrory() throws IOException {
    session.commit();
    session.close();
    ins.close();
  }

  @Test
  public void getAddress() {
    List<UserAddress> userAddressList = userAddressDao.getAddress(22);
    for (UserAddress userAddress : userAddressList) {
      System.out.println(userAddress);
    }

  }

  @Test
  public void addAddress() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    UserAddress userAddress = new UserAddress(null, 22, "江苏省南京市溧水区", df.format(new Date()), 0,
        "公司");
    System.out.println(userAddressDao.addAddress(userAddress));
    System.out.println(userAddress);
  }

  @Test
  public void getDefaultAddress() {
    UserAddress userAddress = userAddressDao.getDefaultAddress(22);
    System.out.println(userAddress);
  }
}