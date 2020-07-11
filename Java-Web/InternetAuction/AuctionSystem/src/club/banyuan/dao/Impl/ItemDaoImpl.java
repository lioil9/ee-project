package club.banyuan.dao.Impl;

import club.banyuan.dao.IItemDao;
import club.banyuan.entity.AuctionItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl extends BaseDaoImpl implements IItemDao {

  public ItemDaoImpl(Connection connection) {
    super(connection);
  }


  @Override
  public List<AuctionItem> getAuctionItems(String name, String remark, String startTime,
      String endTime,
      Double startPrice, Integer page) {
    String sql = "select * from auctionItem where "
        + "name = if(? is null, name, ?) "
        + "and remark like if(? is null, remark, ?) "
        + "and startTime = if(? is null, startTime, ?) "
        + "and endTime = if(? is null, endTime, ?) "
        + "and startPrice = if(? is null, startPrice, ?) "
        + "and isSold = 0 limit ?,10";

    Object[] parms = new Object[]{name, name, remark, "%"+remark+"%", startTime, startTime, endTime,
        endTime, startPrice, startPrice, (page - 1) * 10};
    List<AuctionItem> auctionItems = new ArrayList<>();
    ResultSet rs = this.executeQuery(sql, parms);
    try {
      while (rs.next()) {
        auctionItems.add(this.tableToClass(rs));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
      this.closeResource(rs);
    }
    return auctionItems;
  }

  @Override
  public Integer addAuctionItem(AuctionItem auctionItem) {
    String sql = "insert into auctionItem values(null,?,?,?,?,?,?,0)";
    Object[] parms = new Object[]{
        auctionItem.getName(),
        auctionItem.getStartPrice(),
        auctionItem.getBasePrice(),
        auctionItem.getStartTime(),
        auctionItem.getEndTime(),
        auctionItem.getRemark(),
    };
    Integer id = 0;
    try {
      id = this.executeInsert(sql, parms);
      auctionItem.setId(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
    }
    return id;
  }

  @Override
  public AuctionItem getAuctionItemById(Integer id) {
    String sql = "select * from auctionItem where id = ?";
    Object[] parms = new Object[]{id};
    AuctionItem auctionItem = null;
    ResultSet rs = this.executeQuery(sql, parms);
    try {
      while (rs.next()){
        auctionItem = this.tableToClass(rs);
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
      this.closeResource(rs);
    }
    return auctionItem;
  }

  @Override
  public Integer changeAuctionItem(AuctionItem auctionItem) {
    String sql = "update auctionItem set name=?, startPrice=?, basePrice=?, "
        + "startTime=?, endTime=?, remark=? "
        + "where id = ?";
    Object[] parms = new Object[]{
        auctionItem.getName(),
        auctionItem.getStartPrice(),
        auctionItem.getBasePrice(),
        auctionItem.getStartTime(),
        auctionItem.getEndTime(),
        auctionItem.getRemark(),
        auctionItem.getId()
    };
    Integer updateRow = 0;
    try {
      updateRow = this.executeUpdate(sql,parms);
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
    }
    return updateRow;
  }

  @Override
  public Integer deleteAuctionItem(Integer id) {
    String sql = "delete from auctionItem where id = ?";
    Object[] parms = new Object[]{id};

    Integer updateRow = 0;
    try {
      updateRow = this.executeUpdate(sql,parms);
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
    }
    return updateRow;
  }

  @Override
  public AuctionItem tableToClass(ResultSet rs) throws Exception {
    AuctionItem auctionItem = new AuctionItem();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    auctionItem.setId(rs.getInt("id"));
    auctionItem.setName(rs.getString("name"));
    auctionItem.setStartPrice((double) rs.getFloat("startPrice"));
    auctionItem.setBasePrice((double) rs.getFloat("basePrice"));
    auctionItem.setStartTime(df.format(rs.getTimestamp("startTime").getTime()));
    auctionItem.setEndTime(df.format(rs.getTimestamp("endTime").getTime()));
    auctionItem.setRemark(rs.getString("remark"));
    return auctionItem;
  }


}
