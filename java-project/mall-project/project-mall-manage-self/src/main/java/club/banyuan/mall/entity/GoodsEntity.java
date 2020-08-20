package club.banyuan.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class GoodsEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long goodsId;

  private String goodsName;

  private String goodsIntro;

  private Long goodsCategoryId;

  private String goodsCoverImg;

  private String goodsCarousel;

  private Integer originalPrice;

  private Integer sellingPrice;

  private Integer stockNum;

  private String tag;

  private Byte goodsSellStatus;

  private Integer createUser;

  private Date createTime;

  private Integer updateUser;

  private Date updateTime;

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

  public Long getGoodsCategoryId() {
    return goodsCategoryId;
  }

  public void setGoodsCategoryId(Long goodsCategoryId) {
    this.goodsCategoryId = goodsCategoryId;
  }

  public String getGoodsCoverImg() {
    return goodsCoverImg;
  }

  public void setGoodsCoverImg(String goodsCoverImg) {
    this.goodsCoverImg = goodsCoverImg;
  }

  public String getGoodsCarousel() {
    return goodsCarousel;
  }

  public void setGoodsCarousel(String goodsCarousel) {
    this.goodsCarousel = goodsCarousel;
  }

  public Integer getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(Integer originalPrice) {
    this.originalPrice = originalPrice;
  }

  public Integer getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Integer sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Integer getStockNum() {
    return stockNum;
  }

  public void setStockNum(Integer stockNum) {
    this.stockNum = stockNum;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public Byte getGoodsSellStatus() {
    return goodsSellStatus;
  }

  public void setGoodsSellStatus(Byte goodsSellStatus) {
    this.goodsSellStatus = goodsSellStatus;
  }

  public Integer getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Integer createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Integer updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getGoodsDetailContent() {
    return goodsDetailContent;
  }

  public void setGoodsDetailContent(String goodsDetailContent) {
    this.goodsDetailContent = goodsDetailContent;
  }
}
