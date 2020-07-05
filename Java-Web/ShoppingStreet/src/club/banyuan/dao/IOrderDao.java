package club.banyuan.dao;

import club.banyuan.entity.Order;
import java.util.List;

public interface IOrderDao extends IBaseDao{

  List<Order> getOrder(Integer userId);
  Integer addOrder(Order order);

}
