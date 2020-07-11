package club.banyuan.controller;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.Impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserRegisterServlet",urlPatterns = "/userRegister.do")
public class UserRegisterServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    User user = new User();
    try {
      System.out.println("doPost");
      user.setUserName(request.getParameter("userName"));
      user.setPassword(request.getParameter("password"));
      user.setIdNum(request.getParameter("idNum"));
      user.setMobile(request.getParameter("mobile"));
      user.setAddress(request.getParameter("address"));
      if(request.getParameter("postalCode").isBlank()) {
        user.setPostalCode(null);
      }else{
        user.setPostalCode(Integer.valueOf(request.getParameter("postalCode")));
      }
      IUserService userService = new UserServiceImpl();
      userService.register(user);
      request.getRequestDispatcher("index.html").forward(request,response);
    }catch (Exception e){
      e.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
