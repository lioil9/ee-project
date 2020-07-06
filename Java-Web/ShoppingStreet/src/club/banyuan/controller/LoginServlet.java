package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 获取登陆并跳转页面请求
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //获取并格式验证
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    UserServiceImpl userService = new UserServiceImpl();
    Cookie cookie = new Cookie("loginName", loginName);
    try {
      User user = userService.login(loginName, password);
      if (user != null) {
        HttpSession session = request.getSession();
        System.out.println(user.getLoginName());
        session.setAttribute("user", user);
        if(request.getParameter("keepStatus") != null) {
          cookie.setMaxAge(24 * 3600);
          response.addCookie(cookie);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("Login.jsp").forward(request, response);


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
