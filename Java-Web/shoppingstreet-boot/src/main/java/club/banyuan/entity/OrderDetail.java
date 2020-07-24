package club.banyuan.entity;

import javax.persistence.*;

@Table(name = "order_detail")
public class OrderDetail {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 订单主键
     */
    @Column(name = "orderId")
    private Integer orderid;

    /**
     * 商品主键
     */
    @Column(name = "productId")
    private Integer productid;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 消费
     */
    private Float cost;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单主键
     *
     * @return orderId - 订单主键
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 设置订单主键
     *
     * @param orderid 订单主键
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 获取商品主键
     *
     * @return productId - 商品主键
     */
    public Integer getProductid() {
        return productid;
    }

    /**
     * 设置商品主键
     *
     * @param productid 商品主键
     */
    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    /**
     * 获取数量
     *
     * @return quantity - 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置数量
     *
     * @param quantity 数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取消费
     *
     * @return cost - 消费
     */
    public Float getCost() {
        return cost;
    }

    /**
     * 设置消费
     *
     * @param cost 消费
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }
}