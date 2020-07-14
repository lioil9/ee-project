package club.banyuan.entity;

public class SoldItem {
  private Integer id;
  private Integer itemId;
  private Double price;
  private Integer userId;

  private AuctionItem auctionItem;
  private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public AuctionItem getAuctionItem() {
    return auctionItem;
  }

  public void setAuctionItem(AuctionItem auctionItem) {
    this.auctionItem = auctionItem;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "SoldItem{" +
        "id=" + id +
        ", itemId=" + itemId +
        ", price=" + price +
        ", userId=" + userId +
        '}';
  }
}
