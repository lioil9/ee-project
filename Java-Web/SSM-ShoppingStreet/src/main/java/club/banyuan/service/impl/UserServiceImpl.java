package club.banyuan.service.impl;

import club.banyuan.dao.IUserAddressDao;
import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import club.banyuan.entity.UserAddress;
import club.banyuan.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private IUserDao userDao;
  @Autowired
  private IUserAddressDao userAddressDao;


  public User login(String loginName, String password) throws Exception {
    return userDao.getLoginUser(loginName,password);
  }

  public boolean register(User user) throws Exception {
    return userDao.add(user) > 0;
  }

  public boolean isExist(String loginName) throws Exception {
    return userDao.isExist(loginName);
  }

  public List<UserAddress> getAddress(Integer userId) throws Exception {
    return userAddressDao.getAddress(userId);
  }

  public Boolean addAddress(UserAddress userAddress) throws Exception {
    return userAddressDao.addAddress(userAddress)>0;
  }


}
