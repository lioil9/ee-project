package club.banyuan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().invalidate();
    Cookie newCookie = new Cookie("loginName", null);
    for (Cookie cookie : request.getCookies()) {
      if(cookie.getName().equals("loginName")){
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(newCookie);
        break;
      }
    }
    response.sendRedirect("Login.jsp");
  }
}
