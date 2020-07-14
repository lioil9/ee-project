package club.banyuan.dao;

import club.banyuan.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {
  int addUser(User user);
  User getLogin(@Param("userName") String userName, @Param("password") String password);
  boolean isExist(String userName);
  User getUserById(Integer id);
}
