package club.banyuan.blog.service.impl;

import club.banyuan.blog.dto.RoleDto;
import club.banyuan.blog.dto.UserBaseDto;
import club.banyuan.blog.dto.UserDto;
import club.banyuan.blog.entity.RoleEntity;
import club.banyuan.blog.entity.UserEntity;
import club.banyuan.blog.mapper.RoleMapper;
import club.banyuan.blog.mapper.UserMapper;
import club.banyuan.blog.service.UserService;
import club.banyuan.blog.utils.UserUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;

  @Autowired private RoleMapper roleMapper;

  @Override
  public UserBaseDto getUserBaseInfoById() {
    UserEntity userEntity = userMapper.getUserById(UserUtil.getCurrentUser().getId());
    UserBaseDto userBaseDto = new UserBaseDto();
    if (userEntity != null) {
      BeanUtils.copyProperties(userEntity, userBaseDto);
    }
    return userBaseDto;
  }

  @Override
  public boolean updateUserEmail(String email) {
    return userMapper.updateUserEmail(UserUtil.getCurrentUser().getId(), email) > 0;
  }

  @Override
  public List<UserDto> getUserByNickname(String nickname) {
    List<UserEntity> userEntities = userMapper.getUserByNickname(nickname);
    List<UserDto> userDtos = new ArrayList<>();
    if (userEntities != null) {
      userEntities.forEach(
          s -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(s, userDto);
            userDtos.add(userDto);
          });
    }
    return userDtos;
  }

  @Override
  public List<RoleDto> getAllRole() {
    List<RoleEntity> roleEntities = roleMapper.getAllRole();
    List<RoleDto> roleDtos = new ArrayList<>();
    if (roleEntities != null) {
      roleEntities.forEach(
          s -> {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(s, roleDto);
            roleDtos.add(roleDto);
          });
    }
    return roleDtos;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean updateUserEnabled(Long uid, Boolean enabled) {
    return userMapper.updateUserEnabled(uid, enabled) > 0;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean updateUserRoles(Long id, Long[] rids) {
    userMapper.deleteUserRolesByUid(id);
    boolean result = userMapper.setUserRoles(id, rids) > 0;
    return result;
  }
}
