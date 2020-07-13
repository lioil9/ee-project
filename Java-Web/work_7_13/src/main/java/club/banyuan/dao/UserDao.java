package club.banyuan.dao;

import club.banyuan.entity.User;
import java.util.List;

public interface UserDao {
  int addUser(User user);
  User getLogin(String userName, String password);
  boolean isExist(String userName);
  User getUserById(Integer id);
  List<User> getAll();
}
