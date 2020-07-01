//package club.banyuan;
//
//import club.banyuan.dao.impl.OrderDetailImpl;
//import club.banyuan.dao.impl.OrderImpl;
//import club.banyuan.dao.impl.ProductImpl;
//import club.banyuan.dao.impl.UserImpl;
//import club.banyuan.entity.Order;
//import club.banyuan.entity.OrderDetail;
//import club.banyuan.entity.Product;
//import club.banyuan.entity.User;
//import club.banyuan.utils.JdbcUtils;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Scanner;
//
//
//public class MainTest {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    try {
//      Connection connection = JdbcUtils.getConnection();
//      User user = new User(null,"abT","张三","123456",1,"191919@163.com","1399999999");
//      UserImpl userImpl = new UserImpl(connection);
//      User newUser = userImpl.isExist(user.getLoginName());
//      if(newUser == null){
//        if(userImpl.add(user) > 0){
//          System.out.println("用户注册成功");
//        }else {
//          System.out.println("用户注册失败");
//        }
//      } else {
//        System.out.println("已存在此用户");
//      }
//      User loginUser = userImpl.getLoginUser(user.getLoginName(),user.getPassword());
//      if(loginUser != null){
//        System.out.println("登陆成功");
//      } else {
//        System.out.println("登陆失败");
//        return;
//      }
//      System.out.println("请输入要查询的商品：");
//      String searchName = sc.nextLine();
//      ProductImpl productImpl = new ProductImpl(connection);
//      List<Product> products = productImpl.getProductByName(searchName);
//      System.out.println("查询到商品有：");
//      for (int i = 0; i < products.size(); i++) {
//        System.out.println(i+1+","+products.get(i).toString());
//      }
//      Map<Product,Integer> buyProductDetail = new HashMap<>();
//
//      while (true) {
//        System.out.println("(输入0退出购买)请选择购买的商品：");
//        int buyProductNum = sc.nextInt() -1;
//        if(buyProductNum == -1){
//          break;
//        }
//        System.out.println("(输入0退出购买)请选择购买数量：");
//        int buyProductQuantity = sc.nextInt();
//        if(buyProductQuantity == 0){
//          break;
//        }
//        buyProductDetail.put(products.get(buyProductNum),buyProductQuantity);
//      }
//      double cost = 0.0;
//      if(!buyProductDetail.isEmpty()) {
//        for (Entry<Product, Integer> productIntegerEntry : buyProductDetail.entrySet()) {
//          cost += productIntegerEntry.getKey().getPrice() * productIntegerEntry.getValue();
//        }
//        OrderImpl orderImpl = new OrderImpl(connection);
//        Date date = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Order order = new Order(loginUser.getId(),loginUser.getLoginName(),df.format(date),cost,null);
//
//        Integer orderId = orderImpl.add(order);
//        OrderDetailImpl orderDetailImpl = new OrderDetailImpl(connection);
//        for (Entry<Product, Integer> pe : buyProductDetail.entrySet()) {
//          Double detailCost = pe.getKey().getPrice() * pe.getValue();
//          orderDetailImpl.add(new OrderDetail(orderId,pe.getKey().getId(),pe.getValue(),detailCost));
//        }
//      }else {
//        System.out.println("未购买商品！");
//      }
//
//
////      String date = orderImpl.getOrderByLoginName("admin").getCreateTime();
////      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//
//
//  }
//}
