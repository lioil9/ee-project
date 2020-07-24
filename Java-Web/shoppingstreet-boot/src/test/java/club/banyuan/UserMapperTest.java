package club.banyuan;


import club.banyuan.entity.User;
import club.banyuan.mapper.UserMapper;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@MybatisTest
//这个是启用自己配置的数据元，不加则采用虚拟数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//这个是默认是回滚，不会commit入数据库，改成false 则commit
@Rollback(false)
public class UserMapperTest {

  @Autowired
  private UserMapper userMapper;


  @Test
  public void test() {
    List<User> userList = userMapper.selectAll();
    System.out.println(userList.size());
    for (User user : userList) {
      System.out.println(user);
    }
    User user = new User();
    user.setLoginname("aaa");

    userList = userMapper.select(user);
    userList.forEach(s -> System.out.println("查到的用户为："+s));
  }

}
