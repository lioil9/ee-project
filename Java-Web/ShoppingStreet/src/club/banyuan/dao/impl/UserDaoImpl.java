package club.banyuan.dao.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

  public UserDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int add(User user) {
    Integer id = 0;
    String sql =
        "insert into user(id,loginName,userName,password,sex,identityCode,email,mobile) values(null,?,?,?,?,?,?)";
    try{
      Object[] parms =
          new Object[] {
              user.getLoginName(),
              user.getUserName(),
              user.getPassword(),
              user.getSex(),
              user.getIdentityCode(),
              user.getEmail(),
              user.getMobile()
          };
      id = this.executeInsert(sql,parms);
      user.setId(id);
    } catch (Exception e){
      e.printStackTrace();
    } finally{
      this.closeResource();
    }

    return id;
  }

  @Override
  public User getLoginUser(String loginName, String password) {
    String sql = "select * from user where loginName = ? and password = ?";
    Object[] parms = new Object[]{loginName,password};
    ResultSet rs = this.executeQuery(sql,parms);
    User user = null;
    try{
      while (rs.next()){
        user = this.tableToClass(rs);
      }
    } catch (Exception e){
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }

    return user;
  }

  @Override
  public boolean isExist(String loginName) {
    String sql = "select * from user where loginName = ?";
    Object[] parms = new Object[]{loginName};
    ResultSet rs = this.executeQuery(sql,parms);
//    User user = null;
    boolean flag = false;
    try{
//      while (rs.next()){
//        user = this.tableToClass(rs);
//      }
      flag = rs.next();
    } catch (Exception e){
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }
    return flag;
  }

  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User();
    user.setId(rs.getInt("id"));
    user.setLoginName(rs.getString("loginName"));
    user.setUserName(rs.getString("userName"));
    user.setPassword(rs.getString("password"));
    user.setSex(rs.getInt("sex"));
    user.setIdentityCode(rs.getString("identityCode"));
    user.setEmail(rs.getString("email"));
    user.setMobile(rs.getString("mobile"));
    return user;
  }
}
