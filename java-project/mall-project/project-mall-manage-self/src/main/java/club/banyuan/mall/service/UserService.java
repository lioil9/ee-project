package club.banyuan.mall.service;

import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;

public interface UserService {
    PageResult getUserList(PageQueryUtil pageUtil);

    boolean updateUsersStatus(Integer[] ids, int lockStatus);
}
