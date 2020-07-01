package club.banyuan;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.impl.UserImpl;
import club.banyuan.entity.User;
import club.banyuan.utils.DataSourceUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    User user = null;
    try {
      Connection connection = DataSourceUtil.openConnection();
      UserImpl userImpl = new UserImpl(connection);

      user = userImpl.getLoginUser(loginName,password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    response.setCharacterEncoding("UTF-8");
    response.setHeader("content-type", "text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
    if(user != null){
      writer.println("<script>alert('登陆成功');location.href='/index.html'</script>");
    } else {
      writer.println("<script>alert('登陆失败,请重新登陆');location.href='/Login.html'</script>");
    }
    writer.flush();
    writer.close();
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
