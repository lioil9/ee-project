package club.banyuan.service;

import club.banyuan.entity.User;
import club.banyuan.entity.UserAddress;
import java.util.List;

public interface IUserService {
  User login (String loginName, String password) throws Exception;
  boolean register(User user) throws Exception;
  boolean isExist(String loginName) throws Exception;
  List<UserAddress> getAddress(Integer userId) throws Exception;
  Boolean addAddress(UserAddress userAddress) throws Exception;
}
