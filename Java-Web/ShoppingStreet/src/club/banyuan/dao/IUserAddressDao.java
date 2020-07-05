package club.banyuan.dao;

import club.banyuan.entity.UserAddress;
import java.sql.SQLException;
import java.util.List;

public interface IUserAddressDao extends IBaseDao{
  List<UserAddress> getAddress(Integer userId) ;
  Integer addAddress(UserAddress userAddress) ;

}
