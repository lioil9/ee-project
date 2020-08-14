package club.banyuan.blog.service.impl;

import club.banyuan.blog.dto.LoginUserDto;
import club.banyuan.blog.dto.RoleDto;
import club.banyuan.blog.entity.RoleEntity;
import club.banyuan.blog.entity.UserEntity;
import club.banyuan.blog.mapper.RoleMapper;
import club.banyuan.blog.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userMapper.getUserByUsername(username);
        if(userEntity == null){
            return new LoginUserDto();
        }
        LoginUserDto loginUserDto = new LoginUserDto();
        BeanUtils.copyProperties(userEntity,loginUserDto);
        List<RoleEntity> roleEntityList = roleMapper.getRoleByUid(loginUserDto.getId());
        if(roleEntityList != null){
            List<RoleDto> roleDtoList = new ArrayList<>();
            for (RoleEntity roleEntity : roleEntityList) {
                RoleDto roleDto = new RoleDto();
                BeanUtils.copyProperties(roleEntity,roleDto);
                roleDtoList.add(roleDto);
            }
            loginUserDto.setRoleDtoList(roleDtoList);
        }
        return loginUserDto;
    }
}
