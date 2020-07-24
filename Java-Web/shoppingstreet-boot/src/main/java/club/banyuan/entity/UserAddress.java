package club.banyuan.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_address")
public class UserAddress {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 用户主键
     */
    @Column(name = "userId")
    private Integer userid;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 是否是默认地址（1:是 0否）
     */
    @Column(name = "isDefault")
    private Integer isdefault;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
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
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取是否是默认地址（1:是 0否）
     *
     * @return isDefault - 是否是默认地址（1:是 0否）
     */
    public Integer getIsdefault() {
        return isdefault;
    }

    /**
     * 设置是否是默认地址（1:是 0否）
     *
     * @param isdefault 是否是默认地址（1:是 0否）
     */
    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}