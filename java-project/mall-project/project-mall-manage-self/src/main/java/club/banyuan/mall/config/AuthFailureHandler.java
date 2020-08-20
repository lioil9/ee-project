package club.banyuan.mall.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {
    response.setContentType("application/json;charset=utf-8");
    if (request.getSession().getAttribute("errorMsg") == null) {
      request.getSession().setAttribute("errorMsg", "登陆失败，请联系作者获得测试账号");
    }
    response.sendRedirect("/admin/login");
  }
}
