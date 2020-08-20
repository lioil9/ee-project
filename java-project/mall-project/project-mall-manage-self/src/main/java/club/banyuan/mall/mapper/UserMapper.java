package club.banyuan.mall.mapper;

import club.banyuan.mall.entity.UserEntity;
import club.banyuan.mall.util.PageQueryUtil;

import java.util.List;

public interface UserMapper {
    List<UserEntity> findMallUserList(PageQueryUtil pageUtil);
    int getTotalMallUsers(PageQueryUtil pageUtil);
    int lockUserBatch(Integer[] ids,  int lockStatus);
}
