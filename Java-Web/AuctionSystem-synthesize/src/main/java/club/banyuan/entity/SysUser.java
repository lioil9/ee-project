package club.banyuan.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    private Integer id;

    private String username;

    private String realname;

    private String password;

    @Column(name = "createDate")
    private Date createdate;

    @Column(name = "lastLoginTime")
    private Date lastlogintime;

    private Integer enabled;

    @Column(name = "accountNonExpired")
    private Integer accountnonexpired;

    @Column(name = "accountNonLocked")
    private Integer accountnonlocked;

    @Column(name = "credentialsNonExpired")
    private Integer credentialsnonexpired;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return createDate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return lastLoginTime
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * @param lastlogintime
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * @return enabled
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * @return accountNonExpired
     */
    public Integer getAccountnonexpired() {
        return accountnonexpired;
    }

    /**
     * @param accountnonexpired
     */
    public void setAccountnonexpired(Integer accountnonexpired) {
        this.accountnonexpired = accountnonexpired;
    }

    /**
     * @return accountNonLocked
     */
    public Integer getAccountnonlocked() {
        return accountnonlocked;
    }

    /**
     * @param accountnonlocked
     */
    public void setAccountnonlocked(Integer accountnonlocked) {
        this.accountnonlocked = accountnonlocked;
    }

    /**
     * @return credentialsNonExpired
     */
    public Integer getCredentialsnonexpired() {
        return credentialsnonexpired;
    }

    /**
     * @param credentialsnonexpired
     */
    public void setCredentialsnonexpired(Integer credentialsnonexpired) {
        this.credentialsnonexpired = credentialsnonexpired;
    }
}