package club.banyuan.entity;

import java.util.Date;
import javax.persistence.*;

public class Order {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 用户主键
     */
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "loginName")
    private String loginname;

    /**
     * 用户地址
     */
    @Column(name = "userAddress")
    private String useraddress;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 总消费
     */
    private Float cost;

    /**
     * 订单号
     */
    @Column(name = "serialNumber")
    private String serialnumber;

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
     * 获取用户主键
     *
     * @return userId - 用户主键
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置用户主键
     *
     * @param userid 用户主键
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return loginName
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * @param loginname
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * 获取用户地址
     *
     * @return userAddress - 用户地址
     */
    public String getUseraddress() {
        return useraddress;
    }

    /**
     * 设置用户地址
     *
     * @param useraddress 用户地址
     */
    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取总消费
     *
     * @return cost - 总消费
     */
    public Float getCost() {
        return cost;
    }

    /**
     * 设置总消费
     *
     * @param cost 总消费
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * 获取订单号
     *
     * @return serialNumber - 订单号
     */
    public String getSerialnumber() {
        return serialnumber;
    }

    /**
     * 设置订单号
     *
     * @param serialnumber 订单号
     */
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }
}