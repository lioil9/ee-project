package club.banyuan.service.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private IUserDao userDao;


  public User login(String loginName, String password) throws Exception {
    return userDao.getLoginUser(loginName,password);
  }

  public boolean register(User user) throws Exception {
    return userDao.add(user) > 0;
  }

  public boolean isExist(String loginName) throws Exception {
    return userDao.isExist(loginName);
  }
}
