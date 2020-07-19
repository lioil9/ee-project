package club.banyuan.entity;


import java.util.List;

public class User {
  private Integer id;
  private String loginName;
  private String userName;
  private String password;
  private String identityCode;
  private Integer sex;
  private String email;
  private String mobile;
  private UserAddress userDefaultAddress;

  public User() {
  }

  public User(Integer id, String loginName, String userName, String password,
      String identityCode, Integer sex, String email, String mobile) {
    this.id = id;
    this.loginName = loginName;
    this.userName = userName;
    this.password = password;
    this.identityCode = identityCode;
    this.sex = sex;
    this.email = email;
    this.mobile = mobile;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getIdentityCode() {
    return identityCode;
  }

  public void setIdentityCode(String identityCode) {
    this.identityCode = identityCode;
  }

  public UserAddress getUserDefaultAddress() {
    return userDefaultAddress;
  }

  public void setUserDefaultAddress(UserAddress userDefaultAddress) {
    this.userDefaultAddress = userDefaultAddress;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", loginName='" + loginName + '\'' +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", identityCode='" + identityCode + '\'' +
        ", sex=" + sex +
        ", email='" + email + '\'' +
        ", mobile='" + mobile + '\'' +
        '}';
  }
}
