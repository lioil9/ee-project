package club.banyuan.service;

import club.banyuan.entity.BidRecord;
import java.sql.SQLException;
import java.util.List;

public interface IBidRecordService {
   List<BidRecord> getBidRecord(Integer itemId) throws SQLException;
   Boolean addBidRecord(BidRecord bidRecord) throws SQLException;
   Double getMaxPrice(Integer itemId) throws SQLException;
}
