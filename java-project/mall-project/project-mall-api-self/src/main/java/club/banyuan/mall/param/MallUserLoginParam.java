package club.banyuan.mall.param;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class MallUserLoginParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "登录名不能为空")
	private String loginName;

	@NotEmpty(message = "密码不能为空")
	private String passwordMd5;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPasswordMd5() {
		return passwordMd5;
	}

	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}

}
