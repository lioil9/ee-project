package club.banyuan.dao.impl;

import club.banyuan.dao.IUserAddressDao;
import club.banyuan.entity.UserAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserAddressDaoImpl extends BaseDaoImpl implements IUserAddressDao {

  public UserAddressDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<UserAddress> getAddress(Integer userId) {
    List<UserAddress> userAddresses = new ArrayList<>();
    String sql = "select * from `user_address` where userId = ?";
    Object[] parms = new Object[]{userId};
    ResultSet rs = this.executeQuery(sql,parms);
    try{
      while (rs.next()){
        userAddresses.add(this.tableToClass(rs));
      }
    } catch (Exception e){
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }

    return userAddresses;
  }

  @Override
  public Integer addAddress(UserAddress userAddress) {
    Integer id = 0;
    String sql =
        "insert into user_address ( id, userId, address, createTime, isDefault, remark)values (null,?,?,?,?,?)";
    Object[] parms =
        new Object[] {
            userAddress.getUserId(),
            userAddress.getAddress(),
            userAddress.getCreateTime(),
            userAddress.getIsDefault(),
            userAddress.getRemark()
        };
    try {
      id = this.executeInsert(sql, parms);
      userAddress.setId(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }
    return id;
  }

  @Override
  public UserAddress tableToClass(ResultSet rs) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    UserAddress userAddress = new UserAddress();
    userAddress.setId(rs.getInt("id"));
    userAddress.setUserId(rs.getInt("userId"));
    userAddress.setAddress(rs.getString("address"));
    if (rs.getTimestamp("createTime") != null) {
      userAddress.setCreateTime(df.format(rs.getTimestamp("createTime")));
    } else {
      userAddress.setCreateTime("");
    }
    userAddress.setIsDefault(rs.getInt("isDefault"));
    userAddress.setRemark(rs.getString("remark"));

    return userAddress;
  }
}
