package club.banyuan.entity;

import javax.persistence.*;

public class User {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 登录名
     */
    @Column(name = "loginName")
    private String loginname;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别(1:男 0：女)
     */
    private Integer sex;

    /**
     * 身份证号
     */
    @Column(name = "identityCode")
    private String identitycode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 类型（1：后台 0:前台）
     */
    private Integer type;

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
     * 获取登录名
     *
     * @return loginName - 登录名
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * 设置登录名
     *
     * @param loginname 登录名
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别(1:男 0：女)
     *
     * @return sex - 性别(1:男 0：女)
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别(1:男 0：女)
     *
     * @param sex 性别(1:男 0：女)
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取身份证号
     *
     * @return identityCode - 身份证号
     */
    public String getIdentitycode() {
        return identitycode;
    }

    /**
     * 设置身份证号
     *
     * @param identitycode 身份证号
     */
    public void setIdentitycode(String identitycode) {
        this.identitycode = identitycode;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取类型（1：后台 0:前台）
     *
     * @return type - 类型（1：后台 0:前台）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型（1：后台 0:前台）
     *
     * @param type 类型（1：后台 0:前台）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", loginname='" + loginname + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", sex=" + sex +
            ", identitycode='" + identitycode + '\'' +
            ", email='" + email + '\'' +
            ", mobile='" + mobile + '\'' +
            ", type=" + type +
            '}';
    }
}