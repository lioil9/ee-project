package club.banyuan.entity;

import javax.persistence.*;

@Table(name = "sys_role_permission")
public class SysRolePermission {
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "perm_id")
    private Integer permId;

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return perm_id
     */
    public Integer getPermId() {
        return permId;
    }

    /**
     * @param permId
     */
    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}