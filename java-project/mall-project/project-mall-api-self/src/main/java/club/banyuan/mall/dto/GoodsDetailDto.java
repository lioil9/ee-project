package club.banyuan.mall.dto;

import java.io.Serializable;

public class GoodsDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long goodsId;
	private String goodsName;
	private String goodsIntro;
	private String goodsCoverImg;
	private Integer sellingPrice;
	private String tag;
	private String[] goodsCarouselList;
	private Integer originalPrice;
	private String goodsDetailContent;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsIntro() {
		return goodsIntro;
	}

	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String[] getGoodsCarouselList() {
		return goodsCarouselList;
	}

	public void setGoodsCarouselList(String[] goodsCarouselList) {
		this.goodsCarouselList = goodsCarouselList;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getGoodsDetailContent() {
		return goodsDetailContent;
	}

	public void setGoodsDetailContent(String goodsDetailContent) {
		this.goodsDetailContent = goodsDetailContent;
	}

}
