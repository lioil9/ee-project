package club.banyuan.dao;

import club.banyuan.entity.AuctionItem;

public interface ItemDao {
    AuctionItem getAuctionItemAndBidOrders(int id);
}
