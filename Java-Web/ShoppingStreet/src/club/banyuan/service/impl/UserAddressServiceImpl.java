package club.banyuan.service.impl;

import club.banyuan.dao.IUserAddressDao;
import club.banyuan.dao.impl.UserAddressDaoImpl;
import club.banyuan.entity.UserAddress;
import club.banyuan.service.IUserAddressService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserAddressServiceImpl implements IUserAddressService {

  @Override
  public List<UserAddress> getAddress(Integer userId) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IUserAddressDao userAddressDao = new UserAddressDaoImpl(connection);
    return userAddressDao.getAddress(userId);
  }

  @Override
  public Integer addAddress(UserAddress userAddress) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IUserAddressDao userAddressDao = new UserAddressDaoImpl(connection);
    return userAddressDao.addAddress(userAddress);
  }
}
