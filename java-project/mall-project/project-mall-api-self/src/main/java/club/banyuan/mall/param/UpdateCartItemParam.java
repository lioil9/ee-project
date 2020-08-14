package club.banyuan.mall.param;

import java.io.Serializable;

public class UpdateCartItemParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cartItemId;
	private Integer goodsCount;

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

}
