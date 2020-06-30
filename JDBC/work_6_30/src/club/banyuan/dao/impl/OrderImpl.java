package club.banyuan.dao.impl;

import club.banyuan.dao.IOrderDao;
import club.banyuan.entity.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class OrderImpl extends BaseDaoImpl implements IOrderDao {

  public OrderImpl(Connection connection) {
    super(connection);
  }

  @Override
  public int add(Order order) {
    Integer id = 0;
    String sql =
        "insert into `order` ( id, userId, loginName, userAddress, createTime, cost, serialNumber)values (null,?,?,null,?,?,?)";
    Object[] parms =
        new Object[] {
          order.getUserId(),
          order.getLoginName(),
          order.getCreateTime(),
          order.getCost(),
          order.getSerialNumber()
        };
    try {
      id = this.executeInsert(sql, parms);
      order.setId(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }
    return id;
  }

  @Override
  public Order getOrderByLoginName(String loginName) {
    String sql = "select * from `order` where loginName = ?";
    Object[] parms = new Object[] {loginName};
    Order order = new Order();
    ResultSet rs = this.executeQuery(sql, parms);
    try {
      while (rs.next()) {
        order = this.tableToClass(rs);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }
    return order;
  }

  @Override
  public Order tableToClass(ResultSet rs) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Order order = new Order();
    order.setId(rs.getInt("id"));
    order.setUserId(rs.getInt("userId"));
    order.setLoginName(rs.getString("loginName"));
    order.setUserAddress(rs.getString("userAddress"));
    order.setCreateTime(df.format(rs.getTimestamp("createTime")));
    order.setCost(rs.getDouble("cost"));
    order.setSerialNumber(rs.getString("serialNumber"));
    return order;
  }
}
