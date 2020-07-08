package club.banyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    //    设置jdbc连接数据库的url，登录数据库的用户名和密码
    private static String url;
    private static String user;
    private static String pwd;

    static{
        Properties properties = new Properties();
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("username");
        pwd = properties.getProperty("password");
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pwd);
        return conn;
    }

    public static void close(Connection conn, Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if(rs !=null){
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
