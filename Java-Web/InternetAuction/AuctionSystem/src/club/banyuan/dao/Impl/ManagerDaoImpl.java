package club.banyuan.dao.Impl;

import club.banyuan.dao.IManagerDao;
import club.banyuan.entity.Manager;
import java.sql.Connection;
import java.sql.ResultSet;

public class ManagerDaoImpl extends BaseDaoImpl implements IManagerDao {

  public ManagerDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Manager getLogin(String userName, String password) {
    String sql = "select * from manager where userName = ? and password = ?";
    Object[] parms = new Object[]{userName, password};
    ResultSet rs = this.executeQuery(sql, parms);
    Manager manager = null;
    try {
      while (rs.next()){
        manager = this.tableToClass(rs);
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
      this.closeResource(rs);
    }
    return manager;
  }

  @Override
  public Manager tableToClass(ResultSet rs) throws Exception {
    Manager manager = new Manager();
    manager.setId(rs.getInt("id"));
    manager.setUserName(rs.getString("userName"));
    manager.setPassword(rs.getString("password"));
    return manager;
  }
}
