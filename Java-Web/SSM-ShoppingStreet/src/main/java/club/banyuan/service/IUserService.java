package club.banyuan.service;

import club.banyuan.entity.User;

public interface IUserService {
  User login (String loginName, String password) throws Exception;
  boolean register(User user) throws Exception;
  boolean isExist(String loginName) throws Exception;
}
