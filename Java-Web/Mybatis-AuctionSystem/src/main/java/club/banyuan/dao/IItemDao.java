package club.banyuan.dao;

import club.banyuan.entity.AuctionItem;
import java.util.List;

public interface IItemDao {
  List<AuctionItem> getAuctionItems(AuctionItem auctionItem);

  Integer addAuctionItem(AuctionItem auctionItem);

  AuctionItem getAuctionItemById(Integer id);

  Integer changeAuctionItem(AuctionItem auctionItem);

  Integer deleteAuctionItem(Integer id);
}
