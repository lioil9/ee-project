package club.banyuan.myblog.config;

import club.banyuan.myblog.dto.Result;
import club.banyuan.myblog.utils.ResultUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {
    response.setContentType("application/json;charset=utf-8");
    PrintWriter out = response.getWriter();
//    response.setStatus(400);
    out.write(JSON.toJSONString(ResultUtil.error("登录失败")));
    out.flush();
    out.close();
  }
}
