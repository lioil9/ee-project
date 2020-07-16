package club.banyuan.service.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import java.sql.SQLException;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements IUserService {
  private IUserDao userDao;

  @Override
  public Integer addUser() throws Exception {
    User user1 = new User();

    user1.setUserName("abc");
    user1.setPassword("cba");

    if(user1.getIdNum()==null){
      throw new Exception();
    } else {
      return userDao.addUser(user1);
    }
  }
}
