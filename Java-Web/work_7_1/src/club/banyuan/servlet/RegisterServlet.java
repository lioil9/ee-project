package club.banyuan.servlet;

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

@WebServlet(name = "RegisterServlet", urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setHeader("content-type", "text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
    System.out.println("doPost...");
    User user = new User();
    user.setLoginName(request.getParameter("loginName"));
    user.setUserName(request.getParameter("userName"));
    user.setPassword(request.getParameter("password"));
    try{
      user.setSex(Integer.valueOf(request.getParameter("sex")));
    } catch (Exception e){
      writer.println("<script>alert('请输入信息注册！');location.href='/Register.html'</script>");
      return;
    }
    user.setEmail(request.getParameter("email"));
    user.setMobile(request.getParameter("mobile"));
    int flag = 0;
    String info = " ";
    try {
      Connection connection = DataSourceUtil.openConnection();
      UserImpl userImpl = new UserImpl(connection);
      if (userImpl.isExist(user.getLoginName())) {
        info = "已存在此用户，请重新注册!<br>";
      } else {
        flag = userImpl.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //    writer.println("<html>");
    //    writer.println("<body><div>");
    writer.write(info);
    if (flag > 0) {
      writer.println("<script>alert('注册成功');location.href='/Login.html'</script>");
    } else {
      writer.println("<script>alert('注册失败');location.href='/Register.html'</script>");
    }
    //    writer.println("</div></body>");
    //    writer.println("</html>");
    writer.flush();
    writer.close();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("doGet...");
    String loginName = request.getParameter("loginName");
    String pwd = request.getParameter("password");
    System.out.println("loginName:" + loginName + ",pwd:" + pwd);
  }
}
