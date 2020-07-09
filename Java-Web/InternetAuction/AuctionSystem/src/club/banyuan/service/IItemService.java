package club.banyuan.service;

import club.banyuan.entity.AuctionItem;
import java.sql.SQLException;
import java.util.List;

public interface IItemService {
    List<AuctionItem> getAuctionItems(String name, String remark, String startTime, String endTime,
        Double startPrice, Integer page) throws SQLException;
    Boolean changeAuctionItem(AuctionItem auctionItem) throws SQLException;
    AuctionItem getAuctionItemById(Integer itemId) throws SQLException;
    Boolean deleteAuctionItem(Integer itemId) throws SQLException;
    Boolean addAuctionItem(AuctionItem auctionItem) throws SQLException;
}
