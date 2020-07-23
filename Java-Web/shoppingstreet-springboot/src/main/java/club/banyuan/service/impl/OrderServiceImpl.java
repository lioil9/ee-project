package club.banyuan.service.impl;

import club.banyuan.dao.IOrderDao;
import club.banyuan.dao.IOrderDetailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.entity.Product;
import club.banyuan.service.IOrderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
  @Autowired
  private IOrderDao orderDao;
  @Autowired
  private IOrderDetailDao orderDetailDao;


  @Override
  public List<Order> getOrderByUserId(Integer userId) throws Exception {
    return orderDao.getOrderByUserId(userId);
  }

  @Override
  public Order addOrder(Order order, Map<Product, Integer> cart) throws Exception {

    orderDao.addOrder(order);

    for (Product product : cart.keySet()) {
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setOrderId(order.getId());
      orderDetail.setCost(product.getPrice());
      orderDetail.setProductId(product.getId());
      orderDetail.setQuantity(cart.get(product));
//      orderDetailService.addOrderDetail(orderDetail);
      orderDetailDao.addOrderDetail(orderDetail);
    }
    return order;
  }

}
