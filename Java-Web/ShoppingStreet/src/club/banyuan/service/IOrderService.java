package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IOrderService {
  List<Order> getOrderByUserId(Integer userId) throws SQLException;
  Order addOrder(Map<Product, Integer> cart, double totalPrice, User user, String address);
}
