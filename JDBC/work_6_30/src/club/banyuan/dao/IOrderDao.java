package club.banyuan.dao;

import club.banyuan.entity.Order;

public interface IOrderDao extends IBaseDao{
  int add(Order order); //添加订单
  Order getOrderByLoginName(String loginName); //查询订单
}
