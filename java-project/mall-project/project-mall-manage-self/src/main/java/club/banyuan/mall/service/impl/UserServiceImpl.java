package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.User;
import club.banyuan.mall.entity.UserEntity;
import club.banyuan.mall.mapper.UserMapper;
import club.banyuan.mall.service.UserService;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;

  @Override
  public PageResult getUserList(PageQueryUtil pageUtil) {
    List<UserEntity> userEntities = userMapper.findMallUserList(pageUtil);
    int total = userMapper.getTotalMallUsers(pageUtil);
    List<User> userList = new ArrayList<>();
    for (UserEntity userEntity : userEntities) {
      User user = new User();
      BeanUtils.copyProperties(userEntity, user);
      userList.add(user);
    }
    return new PageResult(userList, total, pageUtil.getLimit(), pageUtil.getPage());
  }

  @Override
  public boolean updateUsersStatus(Integer[] ids, int lockStatus) {
    return userMapper.lockUserBatch(ids, lockStatus) > 0;
  }
}
