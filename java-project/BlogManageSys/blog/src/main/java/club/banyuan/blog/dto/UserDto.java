package club.banyuan.blog.dto;

import java.util.List;

public class UserDto extends UserBaseDto{

    private List<RoleDto> roles;

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
