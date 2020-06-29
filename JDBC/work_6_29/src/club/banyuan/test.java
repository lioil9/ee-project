package club.banyuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class test {

  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    try {
      connection =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Lihai@1013");
      statement = connection.createStatement();
      statement.executeUpdate(
          "CREATE TABLE tb_dept\n"
              + "(id       INT(11) PRIMARY KEY,\n"
              + " name     VARCHAR(22) NOT NULL,\n"
              + " location VARCHAR(50)\n"
              + ");");
      System.out.println("创建表成功");


    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }
  }
}
