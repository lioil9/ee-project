package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入用户名：");
    String user = sc.nextLine();
    System.out.println("请输入密码：");
    String password = sc.nextLine();

    try {
      validate(user,password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  public static void validate(String name, String password) throws SQLException {
    Connection connection = JdbcUtils.getConnection(null);
    String sql = "select * from user where name = ? and password = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1,name);
    preparedStatement.setString(2,password);

    ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()){
      System.out.println("登陆成功");
    } else {
      System.out.println("登陆失败");
    }
    JdbcUtils.close(connection,preparedStatement,rs);

  }

}
