package club.banyuan.mall.mapper;

import club.banyuan.mall.entity.OrderItemEntity;

import java.util.List;

public interface OrderItemMapper {
    List<OrderItemEntity> selectByOrderId(Long orderId);
}
