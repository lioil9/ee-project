package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.IOrderService;
import club.banyuan.utils.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
  @Autowired
  private IOrderService orderService;
  @Autowired
  private HttpSession session;


  @RequestMapping("/confirmOrder")
  public String confirm(HttpSession session){
    if(session.getAttribute("cart") != null) {
      Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
      if(!cart.isEmpty()){
        return "user/BuyCar_Two";
      }
    }
    return "index";
  }

  @RequestMapping("/addOrder")
  public String addOrder(HttpSession session, Model model){
    Order order = new Order();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
        User user = (User) session.getAttribute("user");
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        double totalPrice = 0;
        for (Product product : cart.keySet()) {
          totalPrice += product.getPrice() * cart.get(product);
        }
        System.out.println(totalPrice);
        order.setCost(totalPrice);
        order.setUserAddress(user.getUserDefaultAddress().getAddress());
        order.setCreateTime(df.format(new Date()));
        order.setLoginName(user.getLoginName());
        order.setUserId(user.getId());
        order.setSerialNumber(StringUtils.randomUUID());
        orderService.addOrder(order,cart);
        session.removeAttribute("cart");
        model.addAttribute("order",order);
      }catch (Exception e){
        e.printStackTrace();
      }
      return "user/BuyCar_Three";
  }

  @RequestMapping("/getOrderList")
  public String getOrderList(Model model){
    try{
      User user = (User) session.getAttribute("user");
      model.addAttribute("userOrders",orderService.getOrderByUserId(user.getId()));
    } catch (Exception e){
      e.printStackTrace();
    }
    return "user/Member_Order";
  }


}
