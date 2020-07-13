package club.banyuan.dao;

import club.banyuan.entity.User;
import club.banyuan.vo.LoginVo;

public interface IUserDao {
  int add(User user);  //新增用户
  User getLoginUser(LoginVo loginVo);  //查询用户
  User isExist(String loginName);

}
