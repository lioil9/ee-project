package club.banyuan.dao;

import club.banyuan.entity.User;

public interface IUserDao extends IBaseDao{
  int addUser(User user);
  User getLogin(String userName, String password);
  boolean isExist(String userName);
  User getUserById(Integer id);
}
