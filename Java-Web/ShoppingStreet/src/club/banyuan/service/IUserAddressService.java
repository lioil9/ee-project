package club.banyuan.service;

import club.banyuan.entity.User;
import club.banyuan.entity.UserAddress;
import java.sql.SQLException;
import java.util.List;

public interface IUserAddressService {
  List<UserAddress> getAddress(Integer userId) throws SQLException;
  Integer addAddress(UserAddress userAddress) throws SQLException;
}
