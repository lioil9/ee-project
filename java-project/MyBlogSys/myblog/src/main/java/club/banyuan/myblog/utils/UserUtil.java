package club.banyuan.myblog.utils;

import club.banyuan.myblog.dto.LoginUserDto;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {

  public static LoginUserDto getCurrentUser() {
    System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    return (LoginUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
