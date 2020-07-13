package club.banyuan.dao;

import club.banyuan.entity.OrderDetail;
import java.util.List;

public interface IOrderDetailDao {
  List<OrderDetail> getOrderDetailByOrderId(Integer orderId);
  void addOrderDetail(OrderDetail orderDetail);

}
