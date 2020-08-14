package club.banyuan.blog.utils;

import club.banyuan.blog.dto.LoginUserDto;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {

  public static LoginUserDto getCurrentUser() {
    return (LoginUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
