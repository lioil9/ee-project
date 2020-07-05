package club.banyuan.service;

import club.banyuan.entity.Order;
import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
  List<Order> getOrderByUserId(Integer userId) throws SQLException;
  Integer addOrder(Order order) throws SQLException;
}
