package club.banyuan.mall.config;

import club.banyuan.mall.exception.VerifyCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

 @Component
public class VerifyCodeFilter extends OncePerRequestFilter {

  @Autowired private AuthFailureHandler failureHandler;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    System.out.println(request.getMethod()+request.getRequestURI());
    if ("/admin/login".equals(request.getRequestURI())
        && request.getMethod().equalsIgnoreCase("post")) {
      try {
        validate(request);
      } catch (VerifyCodeException e) {
        failureHandler.onAuthenticationFailure(request, response, e);
        return;
      }
    }
    filterChain.doFilter(request, response);
  }


  private void validate(HttpServletRequest request) throws ServletRequestBindingException {
    HttpSession session = request.getSession();
    session.removeAttribute("errorMsg");
    String verifyCode = request.getParameter("verifyCode");
    String kaptchaCode = session.getAttribute("verifyCode") + "";
    System.out.println("从request获取在verifyCode对象"+verifyCode);
    System.out.println("kaptchaCode:"+kaptchaCode);
    if (StringUtils.isEmpty(verifyCode)) {
      System.out.println("验证码为空");
      session.setAttribute("errorMsg", "验证码为空");
      throw new VerifyCodeException("验证码为空或者不存在");
    }

    if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
      System.out.println("验证码错误");
      session.setAttribute("errorMsg", "验证码错误");
      throw new VerifyCodeException("验证码不匹配");
    }

  }

}
