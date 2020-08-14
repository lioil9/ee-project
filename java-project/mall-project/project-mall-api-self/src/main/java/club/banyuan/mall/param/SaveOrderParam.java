package club.banyuan.mall.param;

import java.io.Serializable;

public class SaveOrderParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long[] cartItemIds;
	private Long addressId;

	public Long[] getCartItemIds() {
		return cartItemIds;
	}

	public void setCartItemIds(Long[] cartItemIds) {
		this.cartItemIds = cartItemIds;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}
