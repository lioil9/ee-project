package club.banyuan.mall.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderListDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNo;
	private Integer totalPrice;
	private Byte payType;
	private Byte orderStatus;
	private String orderStatusString;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	private List<OrderItemDto> newBeeMallOrderItemVOS;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusString() {
		return orderStatusString;
	}

	public void setOrderStatusString(String orderStatusString) {
		this.orderStatusString = orderStatusString;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderItemDto> getNewBeeMallOrderItemVOS() {
		return newBeeMallOrderItemVOS;
	}

	public void setNewBeeMallOrderItemVOS(List<OrderItemDto> newBeeMallOrderItemVOS) {
		this.newBeeMallOrderItemVOS = newBeeMallOrderItemVOS;
	}

}
