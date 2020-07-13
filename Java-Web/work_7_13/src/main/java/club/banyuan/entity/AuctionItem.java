package club.banyuan.entity;

import java.util.List;

public class AuctionItem {
  private Integer id;
  private String name;
  private Double startPrice;
  private Double basePrice;
  private String startTime;
  private String endTime;
  private String remark;
  private Integer isSold;
  private List<BidRecord> bidRecords;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(Double startPrice) {
    this.startPrice = startPrice;
  }

  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getIsSold() {
    return isSold;
  }

  public void setIsSold(Integer isSold) {
    this.isSold = isSold;
  }

  public List<BidRecord> getBidRecords() {
    return bidRecords;
  }

  public void setBidRecords(List<BidRecord> bidRecords) {
    this.bidRecords = bidRecords;
  }

  @Override
  public String toString() {
    return "AuctionItem{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", startPrice=" + startPrice +
        ", basePrice=" + basePrice +
        ", startTime='" + startTime + '\'' +
        ", endTime='" + endTime + '\'' +
        ", remark='" + remark + '\'' +
        ", isSold=" + isSold +
        ", bidRecords=" + bidRecords +
        '}';
  }
}
