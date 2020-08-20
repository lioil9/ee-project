package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.Order;
import club.banyuan.mall.dto.OrderItem;
import club.banyuan.mall.entity.OrderEntity;
import club.banyuan.mall.entity.OrderItemEntity;
import club.banyuan.mall.mapper.OrderItemMapper;
import club.banyuan.mall.mapper.OrderMapper;
import club.banyuan.mall.service.OrderService;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired private OrderMapper orderMapper;
  @Autowired private OrderItemMapper orderItemMapper;

  @Override
  public PageResult getOrderList(PageQueryUtil pageUtil) {
    List<OrderEntity> orderEntities = orderMapper.findOrderList(pageUtil);
    int total = orderMapper.findTotalOrders(pageUtil);
    List<Order> orderList = new ArrayList<>();
    for (OrderEntity orderEntity : orderEntities) {
      Order order = new Order();
      BeanUtils.copyProperties(orderEntity, order);
      orderList.add(order);
    }
    return new PageResult(orderList, total, pageUtil.getLimit(), pageUtil.getPage());
  }

  @Override
  public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
    OrderEntity orderEntity = orderMapper.selectByPrimaryKey(orderId);
    if (orderEntity != null) {
      List<OrderItemEntity> orderItemEntities = orderItemMapper.selectByOrderId(orderId);
      if (!CollectionUtils.isEmpty(orderItemEntities)) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItemEntity orderItemEntity : orderItemEntities) {
          OrderItem orderItem = new OrderItem();
          BeanUtils.copyProperties(orderItemEntity, orderItem);
          orderItemList.add(orderItem);
        }
        return orderItemList;
      }
    }
    return null;
  }

  @Override
  public boolean updateOrder(Order order) {
    OrderEntity orderEntity = orderMapper.selectByPrimaryKey(order.getOrderId());
    if (orderEntity != null
        && orderEntity.getOrderStatus() >= 0
        && orderEntity.getOrderStatus() < 3) {
      orderEntity.setTotalPrice(order.getTotalPrice());
      orderEntity.setUpdateTime(new Date());
      return orderMapper.updateByPrimaryKeySelective(orderEntity) > 0;
    }
    return false;
  }

  @Override
  public boolean closeOrders(Long[] ids) {
    List<OrderEntity> orderEntities = orderMapper.selectByPrimaryKeys(ids);
    if (!CollectionUtils.isEmpty(orderEntities)) {
      for (OrderEntity orderEntity : orderEntities) {
        if (orderEntity.getIsDeleted() == 1 || orderEntity.getOrderStatus() != 1) {
          return false;
        }
      }
    }

    return orderMapper.closeOrder(ids) > 0;
  }

  @Override
  public boolean checkDoneOrders(Long[] ids) {
    List<OrderEntity> orderEntities = orderMapper.selectByPrimaryKeys(ids);
    if (!CollectionUtils.isEmpty(orderEntities)) {
      for (OrderEntity orderEntity : orderEntities) {
        if (orderEntity.getIsDeleted() == 1
            || orderEntity.getOrderStatus() == 4
            || orderEntity.getOrderStatus() < 0) {
          return false;
        }
      }
    }
    return orderMapper.checkDone(ids) > 0;
  }

  @Override
  public boolean checkOutOrders(Long[] ids) {
    List<OrderEntity> orderEntities = orderMapper.selectByPrimaryKeys(ids);
    if (!CollectionUtils.isEmpty(orderEntities)) {
      for (OrderEntity orderEntity : orderEntities) {
        if (orderEntity.getIsDeleted() == 1
            || (orderEntity.getOrderStatus() != 1 && orderEntity.getOrderStatus() != 2)) {
          return false;
        }
      }
    }
    return orderMapper.checkOut(ids) > 0;
  }
}
