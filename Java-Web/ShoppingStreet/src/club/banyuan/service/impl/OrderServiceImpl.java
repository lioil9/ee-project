package club.banyuan.service.impl;

import club.banyuan.dao.IOrderDao;
import club.banyuan.dao.IOrderDetailDao;
import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.dao.impl.OrderDetailImpl;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.IOrderService;
import club.banyuan.util.DataSourceUtil;
import club.banyuan.util.StringUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements IOrderService {

  @Override
  public List<Order> getOrderByUserId(Integer userId) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IOrderDao orderDao = new OrderDaoImpl(connection);
    return orderDao.getOrder(userId);
  }

  @Override
  public Order addOrder(Map<Product, Integer> cart, double totalPrice, User user, String address) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Connection connection = null;
    Order order = new Order();
    try {
      connection = DataSourceUtil.openConnection();
      connection.setAutoCommit(false);
      IOrderDao orderDao = new OrderDaoImpl(connection);
      IOrderDetailDao orderDetailDao = new OrderDetailImpl(connection);

      order.setUserId(user.getId());
      order.setLoginName(user.getLoginName());
      order.setUserAddress(address);
      order.setCreateTime(df.format(new Date()));
      order.setCost(totalPrice);
      order.setSerialNumber(StringUtils.randomUUID());

      orderDao.addOrder(order);

      for (Product product : cart.keySet()) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order.getId());
        orderDetail.setCost(product.getPrice());
        orderDetail.setProductId(product.getId());
        orderDetail.setQuantity(cart.get(product));
        orderDetailDao.add(orderDetail);
        connection.commit();
      }

    } catch (Exception e) {
      e.printStackTrace();
      try {
        connection.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      order = null;
    } finally {
      try {
        connection.setAutoCommit(true);
        DataSourceUtil.closeConnection(connection);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return order;
  }
}
