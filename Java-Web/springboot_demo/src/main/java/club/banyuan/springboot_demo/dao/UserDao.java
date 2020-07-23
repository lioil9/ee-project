package club.banyuan.springboot_demo.dao;

import club.banyuan.springboot_demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
  int add(User user);  //新增用户
  User getLoginUser(@Param("loginName") String loginName, @Param("password") String password);  //查询用户
  Boolean isExist(String loginName); //查询用户是否存在
}
