package club.banyuan.mall.param;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class MallUserRegisterParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "登录名不能为空")
	private String loginName;

	@NotEmpty(message = "密码不能为空")
	private String password;

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
