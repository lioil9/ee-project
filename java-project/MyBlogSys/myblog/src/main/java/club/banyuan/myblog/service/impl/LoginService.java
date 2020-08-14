package club.banyuan.myblog.service.impl;

import club.banyuan.myblog.dto.LoginUserDto;
import club.banyuan.myblog.entity.User;
import club.banyuan.myblog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

  @Autowired private UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(@Param("username") String username)
      throws UsernameNotFoundException {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("username", username);
    User user = userMapper.selectOne(queryWrapper);
    if (user == null) {
      return new LoginUserDto();
    }
    LoginUserDto loginUserDto = new LoginUserDto();
    BeanUtils.copyProperties(user, loginUserDto);
    return loginUserDto;
  }
}
