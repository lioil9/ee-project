package club.banyuan.dao;

import club.banyuan.entity.Order;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderDao {

  List<Order> getOrderByUserId(Integer userId);
  Integer addOrder(Order order);


}
