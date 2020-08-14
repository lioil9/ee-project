package club.banyuan.mall.param;

import java.io.Serializable;

public class MallUserUpdateParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	private String passwordMd5;
	private String introduceSign;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPasswordMd5() {
		return passwordMd5;
	}

	public void setPasswordMd5(String passwordMd5) {
		this.passwordMd5 = passwordMd5;
	}

	public String getIntroduceSign() {
		return introduceSign;
	}

	public void setIntroduceSign(String introduceSign) {
		this.introduceSign = introduceSign;
	}

}
