package club.banyuan.mall.mapper;

import club.banyuan.mall.entity.AdminEntity;

public interface AdminMapper {
    AdminEntity getAdminByUsername(String username);
}
