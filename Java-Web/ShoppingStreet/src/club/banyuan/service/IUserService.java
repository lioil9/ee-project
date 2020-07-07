package club.banyuan.service;

import club.banyuan.entity.User;
import java.sql.SQLException;

public interface IUserService {
  User login (String loginName, String password) throws SQLException;
  boolean register(User user) throws SQLException;
  boolean isExist(String loginName) throws SQLException;
}
