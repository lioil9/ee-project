package club.banyuan.service.impl;

import club.banyuan.dao.IBidRecordDao;
import club.banyuan.dao.Impl.BidRecordDaoImpl;
import club.banyuan.entity.BidRecord;
import club.banyuan.service.IBidRecordService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BidRecordServiceImpl implements IBidRecordService {

  @Override
  public List<BidRecord> getBidRecord(Integer itemId) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IBidRecordDao bidRecordDao = new BidRecordDaoImpl(connection);
    return bidRecordDao.getBidRecord(itemId);
  }

  @Override
  public Boolean addBidRecord(BidRecord bidRecord) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IBidRecordDao bidRecordDao = new BidRecordDaoImpl(connection);
    return bidRecordDao.addBidRecord(bidRecord) > 0;
  }
}
