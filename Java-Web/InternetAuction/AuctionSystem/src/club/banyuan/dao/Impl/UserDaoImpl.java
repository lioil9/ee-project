package club.banyuan.dao.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao {


  public UserDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int addUser(User user) {
    Integer id = 0;
    String sql = "insert into user (id, userName, password,idNum,mobile,address,postalCode) values (null,?,?,?,?,?,?)";
    Object[] parms = new Object[]{
        user.getUserName(),
        user.getPassword(),
        user.getIdNum(),
        user.getMobile(),
        user.getAddress(),
        user.getPostalCode()
    };
    try {
      id = this.executeInsert(sql, parms);
      user.setId(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }
    return id;
  }

  @Override
  public User getLogin(String userName, String password) {
    String sql = "select * from user where userName = ? and password = ?";
    Object[] parms = new Object[]{userName, password};
    ResultSet rs = this.executeQuery(sql, parms);
    User user = null;
    try {
      while (rs.next()) {
        user = this.tableToClass(rs);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
      this.closeResource(rs);
    }

    return user;
  }

  @Override
  public boolean isExist(String userName) {
    String sql = "select * from user where userName = ?";
    Object[] parms = new Object[]{userName};
    ResultSet rs = this.executeQuery(sql, parms);
    boolean flag = false;
    try {
      flag = rs.next();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
      this.closeResource(rs);
    }

    return flag;
  }

  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User();

    user.setId(rs.getInt("id"));
    user.setUserName(rs.getString("userName"));
    user.setPassword(rs.getString("password"));
    user.setIdNum(rs.getString("idNum"));
    user.setMobile(rs.getString("mobile"));
    user.setAddress(rs.getString("address"));
    user.setPostalCode(rs.getInt("postalCode"));

    return user;
  }
}
