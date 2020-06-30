package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

  private static Map<String, List<Product>> userShopping = new HashMap<>();


  public static void searchProduct(String name) {
    List<Product> products = new ArrayList<>();
    if (userShopping.containsKey(name)) {
      products = userShopping.get(name);
    } else {
      userShopping.put(name, products);
    }
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入搜索商品的关键词");
    String keyWord = sc.nextLine();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = JdbcUtils.getConnection(null);
      pstmt =
          conn.prepareStatement(
              "select * from product where name like '%"
                  + keyWord
                  + "%' or description like'%"
                  + keyWord
                  + "%'");
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Product product = new Product();
        product.setId(rs.getInt(1));
        product.setName(rs.getString(2));
        product.setDescription(rs.getString(3));
        product.setPrice(rs.getDouble(4));
        product.setStock(rs.getInt(5));
        product.setCategoryLevel1Id(rs.getInt(6));
        product.setCategoryLevel2Id(rs.getInt(7));
        product.setCategoryLevel3Id(rs.getInt(8));
        product.setFileName(rs.getString(9));
        product.setIsDelete(rs.getInt(10));
        products.add(product);
      }
      JdbcUtils.close(conn,pstmt,rs);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    System.out.println("用户" + name + "购物车中商品有：");
    products.forEach(System.out::println);

  }

  public static void addOrder(String name) throws SQLException {
    Date date = new Date();
    java.sql.Date transDate = new java.sql.Date(date.getTime());
    List<Product> products = userShopping.get(name);
    double cost = 0;
    for (Product s : products) {
      cost += s.getPrice();
    }
    Connection connection = JdbcUtils.getConnection(null);
    PreparedStatement pstmt = connection.prepareStatement(
        "select a.id,a.loginName,b.address from user a left join user_address b on a.id = b.userId where a.loginName = '"+name+"';");
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      String sql = "insert into `order` values (null,?,?,?,?,?,null)";
      pstmt = connection.prepareStatement(sql);
      pstmt.setInt(1,rs.getInt(1));
      pstmt.setString(2,rs.getString(2));
      pstmt.setString(3,rs.getString(3));
      pstmt.setDate(4, transDate);
      pstmt.setDouble(5,cost);
      pstmt.executeUpdate();
    }

    String sql1 = "select id from `order` where loginName = ? and createTime = ?;";
    pstmt = connection.prepareStatement(sql1);
    pstmt.setString(1,name);
    pstmt.setDate(2,transDate);
    rs = pstmt.executeQuery();
    int orderId = 0;
    while (rs.next()){
      orderId = rs.getInt(1);
      System.out.println(rs.getInt(1));
    }

    String insertSql = "insert into order_detail values(null,"+orderId+",?,1,?)";
    for (Product product : products) {
      pstmt = connection.prepareStatement(insertSql);
      pstmt.setInt(1,product.getId());
      pstmt.setDouble(2,product.getPrice());
      pstmt.executeUpdate();
    }
    JdbcUtils.close(connection,pstmt,rs);

  }
}
