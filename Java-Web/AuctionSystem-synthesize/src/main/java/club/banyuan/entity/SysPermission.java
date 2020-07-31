package club.banyuan.entity;

import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {
    @Id
    private Integer id;

    @Column(name = "permName")
    private String permname;

    @Column(name = "permTag")
    private String permtag;

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
     * @return permName
     */
    public String getPermname() {
        return permname;
    }

    /**
     * @param permname
     */
    public void setPermname(String permname) {
        this.permname = permname;
    }

    /**
     * @return permTag
     */
    public String getPermtag() {
        return permtag;
    }

    /**
     * @param permtag
     */
    public void setPermtag(String permtag) {
        this.permtag = permtag;
    }
}