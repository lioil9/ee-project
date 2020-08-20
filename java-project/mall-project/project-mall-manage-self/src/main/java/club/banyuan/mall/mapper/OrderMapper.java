package club.banyuan.mall.mapper;

import club.banyuan.mall.entity.OrderEntity;
import club.banyuan.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
  List<OrderEntity> findOrderList(PageQueryUtil pageUtil);

  int findTotalOrders(PageQueryUtil pageUtil);

  OrderEntity selectByPrimaryKey(Long id);

  int checkDone(@Param("orderIds") Long[] orderIds);

  int checkOut(@Param("orderIds") Long[] orderIds);

  int closeOrder(@Param("orderIds") Long[] orderIds);

  int updateByPrimaryKeySelective(OrderEntity order);

  List<OrderEntity> selectByPrimaryKeys(@Param("orderIds") Long[] orderIds);
}
