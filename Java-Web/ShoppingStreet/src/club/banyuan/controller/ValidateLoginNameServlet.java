package club.banyuan.controller;

import club.banyuan.service.IUserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidateLoginNameServlet", urlPatterns = "/loginName.do")
public class ValidateLoginNameServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String result = "true";
    System.out.println("RdoGet");
    try {
      String loginName = request.getParameter("loginName");
      if (!loginName.isBlank()) {
        IUserService userService = new UserServiceImpl();
        if (userService.isExist(loginName)) {
          result = "false";
          System.out.println(result);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    response.setCharacterEncoding("UTF-8");
    PrintWriter writer = response.getWriter();
    writer.print(result);

    writer.flush();
    writer.close();

  }
}
