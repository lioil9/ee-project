package club.banyuan.mall.param;

import java.io.Serializable;

public class UpdateMallUserAddressParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long addressId;
	private Long userId;
	private String userName;
	private String userPhone;
	private Byte defaultFlag;
	private String provinceName;
	private String cityName;
	private String regionName;
	private String detailAddress;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Byte getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Byte defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

}
