package club.banyuan.mall.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	private String loginName;
	private String introduceSign;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIntroduceSign() {
		return introduceSign;
	}

	public void setIntroduceSign(String introduceSign) {
		this.introduceSign = introduceSign;
	}

}
