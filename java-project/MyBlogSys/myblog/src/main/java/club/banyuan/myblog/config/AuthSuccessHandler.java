package club.banyuan.myblog.config;

import club.banyuan.myblog.dto.LoginUserDto;
import club.banyuan.myblog.entity.User;
import club.banyuan.myblog.utils.ResultUtil;
import club.banyuan.myblog.utils.UserUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    response.setContentType("application/json;charset=utf-8");
    PrintWriter out = response.getWriter();
    LoginUserDto currentUserDto = UserUtil.getCurrentUser();
    currentUserDto.setPassword(null);
    out.write(JSON.toJSONString(ResultUtil.success(currentUserDto)));
    out.flush();
    out.close();
  }
}
