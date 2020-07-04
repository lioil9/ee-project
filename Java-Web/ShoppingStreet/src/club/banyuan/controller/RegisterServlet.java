package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取注册并跳转请求
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("content-type", "text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
    System.out.println("doPost...");
    User user = new User();
    if (request.getParameter("isAgree") == null) {
      writer.println("<script>alert('请同意《用户协议》!');location.href='Regist.jsp'</script>");
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
        writer.println("<script>alert('两次密码不一致，请重新输入');location.href='Regist.jsp'</script>");
        return;
      }
      user.setLoginName(request.getParameter("loginName"));
      user.setUserName(request.getParameter("userName"));
      user.setPassword(request.getParameter("password"));
      user.setEmail(request.getParameter("email"));
      user.setMobile(request.getParameter("mobile"));
      user.setSex(Integer.valueOf(request.getParameter("sex")));

    } catch (Exception e) {
      writer.println("<script>alert('请输入完整的信息注册！');location.href='Regist.jsp'</script>");
      return;
    }

    try {
      IUserService userService = new UserServiceImpl();
      if (userService.register(user)) {
        request.getRequestDispatcher("Login.jsp").forward(request,response);
      } else {
        writer.println("<script>alert('已存在此用户，请重新注册!');location.href='Regist.jsp'</script>");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    writer.flush();
    writer.close();

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
