package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //获取并格式验证
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    UserServiceImpl userService = new UserServiceImpl();
    try {
      User user = userService.login(loginName,password);
      if(user != null){
        System.out.println(user.getLoginName());
        request.setAttribute("user", user);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        return;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("Login.html").forward(request,response);


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
