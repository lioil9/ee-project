package club.banyuan.dao.Impl;

import club.banyuan.dao.IBidRecordDao;
import club.banyuan.entity.BidRecord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BidRecordDaoImpl extends BaseDaoImpl implements IBidRecordDao {

  public BidRecordDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<BidRecord> getBidRecord(Integer itemId) {
    String sql = "select a.*,b.userName from bidRecord a inner join user b on a.userId=b.id where itemId = ?";
    Object[] parms = new Object[]{itemId};
    List<BidRecord> bidRecords = new ArrayList<>();
    ResultSet rs = this.executeQuery(sql,parms);
    try{
      while (rs.next()){
        bidRecords.add(this.tableToClass(rs));
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
      this.closeResource(rs);
    }
    return bidRecords;
  }

  @Override
  public Integer addBidRecord(BidRecord bidRecord) {
    String sql = "insert into bidRecord values(null,?,?,?,?)";
    Object[] parms = new Object[]{
      bidRecord.getItemId(),
      bidRecord.getBidTime(),
      bidRecord.getBidPrice(),
      bidRecord.getUserId()
    };
    Integer id = 0;
    try{
      id = this.executeInsert(sql,parms);
      bidRecord.setItemId(id);
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
    }
    return id;
  }

  @Override
  public Double getMaxBidRecord(Integer itemId) {
    String sql = "select max(bidPrice) as bidPrice from bidRecord where itemId = ?";
    Object[] parms = new Object[]{itemId};
    ResultSet rs = this.executeQuery(sql,parms);
    Double maxPrice = null;
    try{
      while (rs.next()){
        maxPrice = (double) rs.getFloat("bidPrice");
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.closeResource();
      this.closeResource(rs);
    }
    return maxPrice;
  }

  @Override
  public BidRecord tableToClass(ResultSet rs) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    BidRecord bidRecord = new BidRecord();
    bidRecord.setId(rs.getInt("id"));
    bidRecord.setItemId(rs.getInt("itemId"));
    bidRecord.setBidTime(df.format(rs.getTimestamp("bidTime")));
    bidRecord.setBidPrice((double) rs.getFloat("bidPrice"));
    bidRecord.setUserId(rs.getInt("userId"));
    bidRecord.setUserName(rs.getString("userName"));
    return bidRecord;
  }
}
