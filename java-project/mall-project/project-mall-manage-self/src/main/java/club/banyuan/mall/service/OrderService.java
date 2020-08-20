package club.banyuan.mall.service;

import club.banyuan.mall.dto.Order;
import club.banyuan.mall.dto.OrderItem;
import club.banyuan.mall.entity.OrderEntity;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;

import java.util.List;

public interface OrderService {
    PageResult getOrderList(PageQueryUtil pageUtil);
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    boolean updateOrder(Order order);
    boolean closeOrders(Long[] ids);
    boolean checkDoneOrders(Long[] ids);
    boolean checkOutOrders(Long[] ids);
}
