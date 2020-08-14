package club.banyuan.mall.param;

import java.io.Serializable;

public class SaveCartItemParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer goodsCount;
	private Long goodsId;

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

}
