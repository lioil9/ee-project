package club.banyuan.mall.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import club.banyuan.mall.dto.OrderItem;
import club.banyuan.mall.service.OrderService;
import club.banyuan.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.Order;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
@RequestMapping("/admin")
public class OrderController {

  @Autowired private OrderService orderService;

  @GetMapping("/orders/list")
  public Result<?> list(@RequestParam Map<String, Object> params) {
    if (StringUtils.isEmpty(params.get("limit")) || StringUtils.isEmpty(params.get("page"))) {
      return ResultGenerator.genFailResult("参数不合法");
    }
    PageQueryUtil pageUtil = new PageQueryUtil(params);
    return ResultGenerator.genSuccessResult(orderService.getOrderList(pageUtil));
  }

  @PostMapping("/orders/update")
  public Result<?> update(@RequestBody Order newBeeMallOrder) {
    if (Objects.isNull(newBeeMallOrder.getOrderId())
        || StringUtils.isEmpty(newBeeMallOrder.getTotalPrice())
        || newBeeMallOrder.getTotalPrice() < 0) {
      return ResultGenerator.genFailResult("参数异常");
    }
    if (orderService.updateOrder(newBeeMallOrder)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("更新失败");
  }

  @GetMapping("/order-items/{id}")
  public Result<?> info(@PathVariable("id") Long id) {
    if (Objects.isNull(id)) {
      return ResultGenerator.genFailResult("参数异常");
    }
    List<OrderItem> orderItemList = orderService.getOrderItemsByOrderId(id);
    if (!CollectionUtils.isEmpty(orderItemList)) {
      return ResultGenerator.genSuccessResult(orderItemList);
    }
    return ResultGenerator.genFailResult("查询失败");
  }

  @PostMapping("/orders/checkDone")
  public Result<?> checkDone(@RequestBody Long[] ids) {
    if (ids.length < 1){
      return ResultGenerator.genFailResult("参数异常");
    }
    if (orderService.checkDoneOrders(ids)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("订单配货失败");
  }

  @PostMapping("/orders/checkOut")
  public Result<?> checkOut(@RequestBody Long[] ids) {
    if (ids.length < 1){
      return ResultGenerator.genFailResult("参数异常");
    }
    if (orderService.checkOutOrders(ids)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("订单出库失败");
  }

  @PostMapping("/orders/close")
  public Result<?> closeOrder(@RequestBody Long[] ids) {
    if (ids.length < 1){
      return ResultGenerator.genFailResult("参数异常");
    }
    if (orderService.closeOrders(ids)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("关闭订单失败");
  }
}
