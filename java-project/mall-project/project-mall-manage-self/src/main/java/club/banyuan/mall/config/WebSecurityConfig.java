package club.banyuan.mall.config;

import club.banyuan.mall.service.impl.AdminLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private AdminLoginServiceImpl adminLoginService;
  @Autowired private VerifyCodeFilter verifyCodeFilter;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(adminLoginService);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .antMatchers("/static/**", "/admin/dist/**", "/admin/plugins/**", "/common/kaptcha");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class)
        .formLogin()
        .loginPage("/admin/login")
        .successHandler(getAuthenticationSuccessHandler())
        .failureHandler(getAuthenticationFailureHandler())
        .loginProcessingUrl("/admin/login")
        .usernameParameter("userName")
        .passwordParameter("password")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .permitAll()
        .and()
        .csrf()
        .disable()
        .exceptionHandling();
  }

  @Bean
  AuthenticationFailureHandler getAuthenticationFailureHandler() {
    return new AuthFailureHandler();
  }

  @Bean
  AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
    return new AuthSuccessHandler();
  }
}
