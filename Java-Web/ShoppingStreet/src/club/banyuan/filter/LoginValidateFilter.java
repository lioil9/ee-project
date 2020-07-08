package club.banyuan.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidateFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpSession session = httpReq.getSession();
    if (session.getAttribute("user") != null) {
      System.out.println("通过过滤器请求");
      chain.doFilter(request, response);
    } else {
      System.out.println("未通过请求");
      //request.getRequestDispatcher("login.jsp").forward(request, response);
      String path = httpReq.getContextPath();
      String basePath =
          request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
              + path + "/";
      HttpServletResponse httpResp = (HttpServletResponse) response;
      httpResp.sendRedirect(basePath + "Login.jsp");
    }
  }
}
