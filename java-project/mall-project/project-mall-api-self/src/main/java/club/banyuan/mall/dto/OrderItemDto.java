package club.banyuan.mall.dto;

import java.io.Serializable;

public class OrderItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long goodsId;
	private Integer goodsCount;
	private String goodsName;
	private String goodsCoverImg;
	private Integer sellingPrice;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCoverImg() {
		return goodsCoverImg;
	}

	public void setGoodsCoverImg(String goodsCoverImg) {
		this.goodsCoverImg = goodsCoverImg;
	}

	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}