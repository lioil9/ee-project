package club.banyuan.dao;

import club.banyuan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserDao {
  int add(User user);  //新增用户
  User getLoginUser(@Param("loginName") String loginName, @Param("password") String password);  //查询用户
  Boolean isExist(String loginName); //查询用户是否存在
}
