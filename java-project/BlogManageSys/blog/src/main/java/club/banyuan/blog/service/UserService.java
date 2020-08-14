package club.banyuan.blog.service;

import club.banyuan.blog.dto.RoleDto;
import club.banyuan.blog.dto.UserBaseDto;
import club.banyuan.blog.dto.UserDto;

import java.util.List;

public interface UserService {

    UserBaseDto getUserBaseInfoById();
    boolean updateUserEmail(String email);
    List<UserDto> getUserByNickname(String nickname);
    List<RoleDto> getAllRole();
    boolean updateUserEnabled(Long uid, Boolean enabled);
    boolean updateUserRoles(Long id, Long[] rids);

}
