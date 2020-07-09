package club.banyuan.dao;

import club.banyuan.entity.AuctionItem;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IItemDao extends IBaseDao{
  List<AuctionItem> getAuctionItems(String name, String remark, String startTime, String endTime, Double startPrice, Integer page);

  Integer addAuctionItem(AuctionItem auctionItem);

  AuctionItem getAuctionItemById(Integer id);

  Integer changeAuctionItem(AuctionItem auctionItem);

  Integer deleteAuctionItem(Integer id);
}
