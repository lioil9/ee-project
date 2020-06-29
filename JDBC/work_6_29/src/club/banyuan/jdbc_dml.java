package club.banyuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_dml {

  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;

    try {
      connection =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Lihai@1013");
      statement = connection.createStatement();
      String changeTable = "alter table tb_dept modify id int auto_increment;";
      String[] insertDate = {
        "insert into tb_dept values(null,'销售一部','南京');",
        "insert into tb_dept values(null,'销售二部','南京');",
        "insert into tb_dept values(null,'人事部','南京');"
      };
      String updateDate = "update tb_dept set location = '上海' where name = '销售二部';";
      //      int a = statement.executeUpdate(changeTable);
      //      System.out.println(a>0 ? "表结构更改成功" : "失败");
      int b = 0;
      for (String s : insertDate) {
         b += statement.executeUpdate(s);
      }
      System.out.println(b > 0 ? "数据插入成功" : "失败");
      int c = statement.executeUpdate(updateDate);
      System.out.println(c > 0 ? "数据更新成功" : "失败");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
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
