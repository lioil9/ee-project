package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.Admin;
import club.banyuan.mall.entity.AdminEntity;
import club.banyuan.mall.mapper.AdminMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements UserDetailsService {

  @Autowired private AdminMapper adminMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AdminEntity adminEntity = adminMapper.getAdminByUsername(username);
    Admin admin = new Admin();
    if (adminEntity != null) {
      BeanUtils.copyProperties(adminEntity, admin);
      System.out.println(admin.getUsername());
      return admin;
    }
    return admin;
  }
}
