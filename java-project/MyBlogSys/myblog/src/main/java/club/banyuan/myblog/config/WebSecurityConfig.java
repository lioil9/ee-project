package club.banyuan.myblog.config;

import club.banyuan.myblog.filter.MyAuthenticationFilter;
import club.banyuan.myblog.service.impl.LoginService;
import club.banyuan.myblog.utils.ResultUtil;
import club.banyuan.myblog.utils.UserUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private LoginService loginService;

  //  @Override
  //  public void configure(WebSecurity web) throws Exception {
  //    web.ignoring().antMatchers("/");
  //  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(loginService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors();
    http.authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .and()
        .formLogin()
        .successHandler(getAuthenticationSuccessHandler())
        .failureHandler(getAuthenticationFailureHandler())
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessHandler(
                (request, response, authentication) -> {
                  response.setContentType("application/json;charset=utf-8");
                  PrintWriter out = response.getWriter();
                  out.write(JSON.toJSONString(ResultUtil.success()));
                  out.flush();
                  out.close();
                })
        .permitAll()
        .and()
        .csrf()
        .disable()
        .exceptionHandling();
  }

  @Bean
  AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
    return new AuthSuccessHandler();
  }

  @Bean
  AuthenticationFailureHandler getAuthenticationFailureHandler() {
    return new AuthFailureHandler();
  }
}
