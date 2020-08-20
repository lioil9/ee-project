package club.banyuan.blog.config;

import club.banyuan.blog.dto.Result;
import club.banyuan.blog.service.impl.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/blogimg/**","/index.html","/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/category/all").authenticated()
                .antMatchers("/admin/**","/reg").hasRole("超级管理员")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/")
                .successHandler(getAuthenticationSuccessHandler())
                .failureHandler(getAuthenticationFailureHandler())
                .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and().logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        response.setStatus(401);
                        String result = "";
                        if (e instanceof InsufficientAuthenticationException) {
//                            result =  new Result("error","请求失败，请联系管理员!");
                            result = "{\"status\":\"error\",\"msg\":\"登录失败222\"}";
                        }
                        out.write(result);
                        out.flush();
                        out.close();
                    }
                })
                .accessDeniedHandler(getAccessDeniedHandler());
    }

    @Bean
    AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
        return new AuthSuccessHandler();
    }

    @Bean
    AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return new AuthFailureHandler();
    }

    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthAccessDeniedHandler();
    }
}
