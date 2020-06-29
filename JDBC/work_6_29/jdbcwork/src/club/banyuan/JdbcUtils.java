package club.banyuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
  private static String user = "root";
  private static String pwd = "lioilroot";
  private static String db = "shoppingStreet";
  private static String portUrl = "jdbc:mysql://localhost:3306/";

  public static Connection getConnection(String dbname) throws SQLException {
    String url = portUrl + db;
    if (dbname != null && !dbname.equals("")) {
      url = portUrl + dbname;
    }
    Connection connection = DriverManager.getConnection(url, user, pwd);
    return connection;
  }

  public static void close(Connection connection, Statement statement) throws SQLException {
    if (statement != null) {
      statement.close();
    }
    if (connection != null) {
      connection.close();
    }
  }

  public static void close(Connection connection, Statement statement, ResultSet rs)
      throws SQLException {
    if (rs != null) {
      rs.close();
    }
    if (statement != null) {
      statement.close();
    }
    if (connection != null) {
      connection.close();
    }
  }
}
