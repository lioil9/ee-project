package club.banyuan.controller;

import club.banyuan.entity.Manager;
import club.banyuan.entity.User;
import club.banyuan.service.IManagerService;
import club.banyuan.service.IUserService;
import club.banyuan.service.impl.ManagerServiceImpl;
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

@WebServlet(name = "ManagerLoginServlet", urlPatterns = "/managerLogin.do")
public class ManagerLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    IManagerService managerService = new ManagerServiceImpl();
    try {
      Manager manager = managerService.login(userName,password);
      System.out.println("mlogin");
      if(manager!=null) {
        System.out.println("mloginNotNull");
        HttpSession session = request.getSession();
        session.setAttribute("manager",manager);
        if(request.getParameter("keepStatus") != null){
          Cookie cookie = new Cookie("managerUserName",userName);
          response.addCookie(cookie);
        }
        Integer page = 1;
        request.setAttribute("page", page);
        request.setAttribute("identity","manager");
        request.getRequestDispatcher("getAuctionItems.do").forward(request,response);
        return;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    request.getRequestDispatcher("ManagerLogin.html").forward(request,response);

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
