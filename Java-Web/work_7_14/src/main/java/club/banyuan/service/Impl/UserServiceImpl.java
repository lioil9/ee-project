package club.banyuan.service.Impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

//  @Autowired 自动匹配类型
//  @Resource(name = "userDao") 指定匹配类型
  @Autowired
  private IUserDao userDao;

  public UserServiceImpl(IUserDao userDao) {
    this.userDao = userDao;
  }

  public IUserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(IUserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public int add(User user) {
    userDao.add(user);
    System.out.println("UserService -- add");
    return 0;
  }
}
