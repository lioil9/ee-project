package club.banyuan.dao;

import club.banyuan.entity.BidRecord;
import java.util.List;

public interface IBidRecordDao {
    List<BidRecord> getBidRecordByItemId(Integer itemId);
  Integer addBidRecord(BidRecord bidRecord);
  Double getMaxBidRecord(Integer itemId);

}
