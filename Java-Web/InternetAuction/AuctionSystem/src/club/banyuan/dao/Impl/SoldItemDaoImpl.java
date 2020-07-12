package club.banyuan.dao.Impl;

import club.banyuan.dao.ISoldItemDao;
import club.banyuan.entity.SoldItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SoldItemDaoImpl extends BaseDaoImpl implements ISoldItemDao {

  public SoldItemDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Integer add(SoldItem soldItem) {
    Integer id = 0;
    String sql = "insert into soldItem values (null,?,?,?)";
    Object[] parms = new Object[]{
        soldItem.getItemId(),
        soldItem.getPrice(),
        soldItem.getUserId()
    };
    try {
      id = this.executeInsert(sql, parms);
      soldItem.setId(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }

    return id;
  }

  @Override
  public List<SoldItem> getAllSoldItem() {
    String sql = "select * from soldItem";
    Object[] parms = new Object[]{};
    List<SoldItem> soldItemList = new ArrayList<>();
    ResultSet rs = this.executeQuery(sql, parms);
    try {
      while (rs.next()) {
        soldItemList.add(this.tableToClass(rs));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
      this.closeResource(rs);
    }

    return soldItemList;
  }

  @Override
  public SoldItem tableToClass(ResultSet rs) throws Exception {
    SoldItem soldItem = new SoldItem();
    soldItem.setId(rs.getInt("id"));
    soldItem.setItemId(rs.getInt("itemId"));
    soldItem.setPrice((double) rs.getFloat("price"));
    soldItem.setUserId(rs.getInt("userId"));
    return soldItem;
  }


}
