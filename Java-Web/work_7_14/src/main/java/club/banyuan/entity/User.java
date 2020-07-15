package club.banyuan.entity;


public class User {
  private Integer id;
  private String loginName;
  private String userName;
  private String password;

  public User() {
  }

  public User(Integer id, String loginName, String userName, String password) {
    this.id = id;
    this.loginName = loginName;
    this.userName = userName;
    this.password = password;
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

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", loginName='" + loginName + '\'' +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
