package club.banyuan;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.Impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class TestService {

  public static void main(String[] args) {
    try {
      Connection connection = DataSourceUtil.openConnection();
      IUserDao userDao = new UserDaoImpl(connection);
      User user = new User(null,"aaa","123","12312312","12345678910","江苏",233099);
      userDao.addUser(user);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
