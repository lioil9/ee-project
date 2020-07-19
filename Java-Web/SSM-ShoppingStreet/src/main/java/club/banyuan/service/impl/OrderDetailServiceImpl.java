package club.banyuan.service.impl;

import club.banyuan.dao.IOrderDetailDao;
import club.banyuan.entity.OrderDetail;
import club.banyuan.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
  @Autowired
  private IOrderDetailDao orderDetailDao;


  @Override
  public void addOrderDetail(OrderDetail orderDetail) throws Exception {
    orderDetailDao.addOrderDetail(orderDetail);
  }
}
