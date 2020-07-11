package club.banyuan.service.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.Impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService {

  @Override
  public User login(String userName, String password) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IUserDao userDao = new UserDaoImpl(connection);
    return userDao.getLogin(userName,password);
  }

  @Override
  public void register(User user) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IUserDao userDao = new UserDaoImpl(connection);
    userDao.addUser(user);
  }

  @Override
  public boolean isExist(String userName) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IUserDao userDao = new UserDaoImpl(connection);
    return userDao.isExist(userName);
  }

  @Override
  public User getUserById(Integer id) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IUserDao userDao = new UserDaoImpl(connection);
    return userDao.getUserById(id);
  }
}
