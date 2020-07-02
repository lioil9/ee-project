package club.banyuan.dao;

import club.banyuan.entity.User;

public interface IUserDao extends IBaseDao{
  int add(User user);  //新增用户
  User getLoginUser(String loginName,String password);  //查询用户
  boolean isExist(String loginName);

}
