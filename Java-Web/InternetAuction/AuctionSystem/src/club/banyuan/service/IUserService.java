package club.banyuan.service;

import club.banyuan.entity.User;
import java.sql.SQLException;

public interface IUserService {
  User login (String userName, String password) throws SQLException;
  void register(User user) throws SQLException;
  boolean isExist(String userName) throws SQLException;

}
