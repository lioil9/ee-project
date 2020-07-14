package club.banyuan.entity;

public class BidRecord {

  private Integer id;
  private Integer itemId;
  private String bidTime;
  private Double bidPrice;
  private Integer userId;
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

  public String getBidTime() {
    return bidTime;
  }

  public void setBidTime(String bidTime) {
    this.bidTime = bidTime;
  }

  public Double getBidPrice() {
    return bidPrice;
  }

  public void setBidPrice(Double bidPrice) {
    this.bidPrice = bidPrice;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "BidRecord{" +
        "id=" + id +
        ", itemId=" + itemId +
        ", bidTime='" + bidTime + '\'' +
        ", bidPrice=" + bidPrice +
        ", userId=" + userId +
        '}';
  }
}
