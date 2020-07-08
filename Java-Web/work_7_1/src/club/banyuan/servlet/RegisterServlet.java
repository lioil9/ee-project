package club.banyuan.servlet;

import club.banyuan.dao.impl.UserImpl;
import club.banyuan.entity.User;
import club.banyuan.exception.PasswordException;
import club.banyuan.util.DataSourceUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
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
    if (request.getParameter("isAgree") == null) {
      writer.println("<script>alert('请同意《用户协议》!');location.href='Rigster.html'</script>");
//      request.getRequestDispatcher("index.jsp").forward(request,response);
//      response.sendRedirect("index.jsp");
      return;
    }
    try {
      Enumeration e = request.getParameterNames();
      while (e.hasMoreElements()) {
        String name = (String) e.nextElement();
        if (request.getParameter(name).isBlank()) {
          System.out.println(name);
          throw new Exception();
        }
      }
      if (!request.getParameter("confirmPassword").equals(request.getParameter("password"))) {
        throw new PasswordException();
      }
      user.setLoginName(request.getParameter("loginName"));
      user.setUserName(request.getParameter("userName"));
      user.setPassword(request.getParameter("password"));
      user.setEmail(request.getParameter("email"));
      user.setMobile(request.getParameter("mobile"));
      user.setSex(Integer.valueOf(request.getParameter("sex")));

    } catch (PasswordException e) {
      writer.println("<script>alert('两次密码不一致，请重新输入');location.href='/Register.html'</script>");
      return;
    } catch (Exception e) {
      writer.println("<script>alert('请输入完整的信息注册！');location.href='/Register.html'</script>");
      return;
    }

    int flag = 0;
    String info = " ";
    try {
      Connection connection = DataSourceUtil.openConnection();
      UserImpl userImpl = new UserImpl(connection);
      if (userImpl.isExist(user.getLoginName())) {
        info = "已存在此用户，请重新注册!";
      } else {
        flag = userImpl.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    //    writer.println("<html>");
    //    writer.println("<body><div>");
    if (flag > 0) {
      //      writer.println("<script>alert('注册成功');location.href='/Login.html'</script>");
//      response.sendRedirect("Login.html");
      request.getRequestDispatcher("index.jsp").forward(request,response);
    } else {
      writer.println("<script>alert('" + info + "注册失败');location.href='/Register.html'</script>");
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
