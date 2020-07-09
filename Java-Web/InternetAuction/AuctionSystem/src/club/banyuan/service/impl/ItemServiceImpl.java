package club.banyuan.service.impl;

import club.banyuan.dao.IItemDao;
import club.banyuan.dao.Impl.ItemDaoImpl;
import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemServiceImpl implements IItemService {

  @Override
  public List<AuctionItem> getAuctionItems(String name, String remark, String startTime,
      String endTime, Double startPrice, Integer page) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IItemDao itemDao = new ItemDaoImpl(connection);
    return itemDao.getAuctionItems(name, remark, startTime, endTime, startPrice, page);
  }

  @Override
  public Boolean changeAuctionItem(AuctionItem auctionItem) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IItemDao itemDao = new ItemDaoImpl(connection);
    return itemDao.changeAuctionItem(auctionItem) == 1;
  }

  @Override
  public AuctionItem getAuctionItemById(Integer itemId) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IItemDao itemDao = new ItemDaoImpl(connection);
    return itemDao.getAuctionItemById(itemId);
  }

  @Override
  public Boolean deleteAuctionItem(Integer itemId) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IItemDao itemDao = new ItemDaoImpl(connection);
    return itemDao.deleteAuctionItem(itemId) == 1;
  }

  @Override
  public Boolean addAuctionItem(AuctionItem auctionItem) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IItemDao itemDao = new ItemDaoImpl(connection);
    return itemDao.addAuctionItem(auctionItem) > 1;
  }


}
