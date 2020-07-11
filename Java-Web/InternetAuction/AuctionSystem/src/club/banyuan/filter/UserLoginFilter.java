package club.banyuan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "UserLoginFilter")
public class UserLoginFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpSession session = request.getSession();
    if (session.getAttribute("user") != null || session.getAttribute("manager") != null) {
      System.out.println("通过普通用户请求");
      chain.doFilter(req, resp);
    }else {
      System.out.println("未通过普通用户请求");
      HttpServletResponse response = (HttpServletResponse) resp;
      String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
      response.sendRedirect(basePath+"index.html");
    }
  }



}
