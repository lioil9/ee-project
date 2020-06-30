package club.banyuan.dao.impl;

import club.banyuan.dao.IOrderDetailDao;
import club.banyuan.entity.OrderDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailImpl extends BaseDaoImpl implements IOrderDetailDao {

  public OrderDetailImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<OrderDetail> getOrderDetailByOrderId(Integer orderId) {
    List<OrderDetail> orderDetailList = new ArrayList<>();
    String sql = "select * from order_detail where orderId = ?";
    Object[] parms = new Object[] {orderId};
    ResultSet rs = this.executeQuery(sql, parms);
    try {
      while (rs.next()) {
        orderDetailList.add(this.tableToClass(rs));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }

    return orderDetailList;
  }

  @Override
  public void add(OrderDetail orderDetail) {

  }

  @Override
  public OrderDetail tableToClass(ResultSet rs) throws Exception {
    return null;
  }
}
