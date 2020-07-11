package club.banyuan.controller;

import club.banyuan.service.IUserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserNameVolatileServlet", urlPatterns = "/userName.do")
public class UserNameVolatileServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    IUserService userService = new UserServiceImpl();
    String flag = "true";
    PrintWriter writer = response.getWriter();
    try {
      if(userService.isExist(userName)){
        flag = "false";
      }
      writer.write(flag);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    writer.flush();
    writer.close();
  }
}
