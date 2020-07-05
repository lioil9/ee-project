package club.banyuan.service.impl;

import club.banyuan.dao.IOrderDao;
import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.entity.Order;
import club.banyuan.service.IOrderService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements IOrderService {

  @Override
  public List<Order> getOrderByUserId(Integer userId) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IOrderDao orderDao = new OrderDaoImpl(connection);
    return orderDao.getOrder(userId);
  }

  @Override
  public Integer addOrder(Order order) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IOrderDao orderDao = new OrderDaoImpl(connection);
    return orderDao.addOrder(order);
  }
}
