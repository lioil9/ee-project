package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
  public static String register() throws SQLException {
    Scanner sc = new Scanner(System.in);
    String loginName ;
    String password;
    while (true){
      System.out.println("请输入登陆名：");
      loginName = sc.nextLine();
      System.out.println("请输入密码：");
      password = sc.nextLine();
      if (isExist(loginName)){
        System.out.println("登录名已存在,请重新输入！");
        continue;
      }
      if(createAccount(loginName,password)){
        Login.validate(loginName,password);
        break;
      }
    }
    return loginName;
  }

  public static boolean isExist(String loginName) throws SQLException {
    Connection connection = JdbcUtils.getConnection(null);
    String sql = "select * from user where loginName = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, loginName);
    ResultSet rs = preparedStatement.executeQuery();
    if (rs.next()) {
      JdbcUtils.close(connection, preparedStatement, rs);
      return true;
    } else {
      JdbcUtils.close(connection, preparedStatement, rs);
      return false;
    }
  }

  public static boolean createAccount(String loginName, String password) throws SQLException {
    Connection connection = JdbcUtils.getConnection(null);
    String sql =
        "insert into user (loginName,password) values ('" + loginName + "','" + password + "')";
    Statement statement = connection.createStatement();
    int a = statement.executeUpdate(sql);
    System.out.println(a > 0 ? "用户注册成功" : "注册失败，请重新注册");
    JdbcUtils.close(connection,statement);
    return a > 0;
  }
}
