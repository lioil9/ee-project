package club.banyuan.blog.mapper;

import club.banyuan.blog.entity.RoleEntity;

import java.util.List;

public interface RoleMapper {

    List<RoleEntity> getRoleByUid(Long uid);
    List<RoleEntity> getAllRole();
}
