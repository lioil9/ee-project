package club.banyuan.vo;

import club.banyuan.entity.User;

public class LoginVo {
  private String loginName;
  private String password;

  public LoginVo(){

  }

  public LoginVo(String loginName, String password) {
    this.loginName = loginName;
    this.password = password;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
