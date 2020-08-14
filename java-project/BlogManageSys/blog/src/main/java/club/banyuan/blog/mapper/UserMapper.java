package club.banyuan.blog.mapper;

import club.banyuan.blog.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

  UserEntity getUserByUsername(@Param("username") String username);

  UserEntity getUserById(@Param("id") Long id);

  int updateUserEmail(@Param("id") Long id, @Param("email") String email);

  List<UserEntity> getUserByNickname(@Param("nickname") String nickname);

  int updateUserEnabled(@Param("uid") Long uid, @Param("enabled") Boolean enable);

  int deleteUserRolesByUid(Long id);

  int setUserRoles(@Param("id") Long id, @Param("rids") Long[] rids);
}
