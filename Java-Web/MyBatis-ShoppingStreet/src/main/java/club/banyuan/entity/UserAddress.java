package club.banyuan.entity;

public class UserAddress {
  private Integer id;
  private Integer userId;
  private String address;
  private String createTime;
  private Integer isDefault;
  private String remark;

  public UserAddress(){};

  public UserAddress(Integer id, Integer userId, String address, String createTime,
      Integer isDefault, String remark) {
    this.id = id;
    this.userId = userId;
    this.address = address;
    this.createTime = createTime;
    this.isDefault = isDefault;
    this.remark = remark;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Integer getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Integer isDefault) {
    this.isDefault = isDefault;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "UserAddress{" +
        "id=" + id +
        ", userId=" + userId +
        ", address='" + address + '\'' +
        ", createTime='" + createTime + '\'' +
        ", isDefault=" + isDefault +
        ", remark='" + remark + '\'' +
        '}';
  }
}
