package club.banyuan.entity;

public class Order {
  private Integer id;
  private Integer userId;
  private String loginName;
  private String userAddress;
  private String createTime;
  private Double cost;
  private String serialNumber;

  public Order(){}

  public Order(Integer userId, String loginName,String createTime,
      Double cost, String serialNumber) {
    this.userId = userId;
    this.loginName = loginName;
    this.createTime = createTime;
    this.cost = cost;
    this.serialNumber = serialNumber;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }
}
