package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
      while (rs.next()){
        Product product = new Product();
        product.setId(rs.getInt(1));
        product.setName(rs.getString(2));
        product.setDescription(rs.getString(3));
        product.setPrice(rs.getFloat(4));
        product.setStock(rs.getInt(5));
        product.setCategoryLevel1Id(rs.getInt(6));
        product.setCategoryLevel2Id(rs.getInt(7));
        product.setCategoryLevel3Id(rs.getInt(8));
        product.setFileName(rs.getString(9));
        product.setIsDelete(rs.getInt(10));
        products.add(product);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    System.out.println("用户"+name+"购物车中商品有：");
    products.forEach(System.out::println);
  }
}
