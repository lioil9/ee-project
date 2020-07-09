package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
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

@WebServlet(name = "UserLoginServlet",urlPatterns = "/userLogin.do")
public class UserLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    IUserService userService = new UserServiceImpl();
    try {
      User user = userService.login(userName,password);
      if(user!=null) {
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        if(request.getParameter("keepStatus") != null){
          Cookie cookie = new Cookie("userName",userName);
          response.addCookie(cookie);
        }
        Integer page = 1;
        request.setAttribute("identity","user");
        request.setAttribute("page", page);
        request.getRequestDispatcher("getAuctionItems.do").forward(request,response);
        return;
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    request.getRequestDispatcher("index.html").forward(request,response);

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
