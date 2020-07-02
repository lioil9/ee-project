package club.banyuan.service.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import club.banyuan.util.DataSourceUtil;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService {

  @Override
  public User login(String loginName, String password) throws SQLException {
    IUserDao userDao = new UserDaoImpl(DataSourceUtil.openConnection());
    return userDao.getLoginUser(loginName,password);
  }

  @Override
  public boolean register(User user) throws SQLException{
    IUserDao userDao = new UserDaoImpl(DataSourceUtil.openConnection());
    if(userDao.isExist(user.getLoginName())){
      return false;
    }else {
      userDao.add(user);
      return true;
    }
  }
}
