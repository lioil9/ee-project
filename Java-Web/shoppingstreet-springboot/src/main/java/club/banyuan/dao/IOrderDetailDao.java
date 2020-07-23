package club.banyuan.dao;

import club.banyuan.entity.OrderDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderDetailDao {
  List<OrderDetail> getOrderDetailByOrderId(Integer orderId);
  void addOrderDetail(OrderDetail orderDetail);

}
