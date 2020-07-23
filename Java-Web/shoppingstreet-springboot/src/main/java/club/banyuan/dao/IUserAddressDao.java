package club.banyuan.dao;

import club.banyuan.entity.UserAddress;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserAddressDao {
  List<UserAddress> getAddress(Integer userId) ;
  Integer addAddress(UserAddress userAddress) ;
  UserAddress getDefaultAddress(Integer userId);

}
