package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import java.util.List;
import java.util.Map;

public interface IOrderService {

  List<Order> getOrderByUserId(Integer userId) throws Exception;
  Order addOrder(Order order, Map<Product, Integer> cart) throws Exception;
}
