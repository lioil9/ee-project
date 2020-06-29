package club.banyuan;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      String name = Register.register();
//      String name = Login.login();
      ShoppingCart.searchProduct(name);
      ShoppingCart.addOrder(name);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
