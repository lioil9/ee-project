package club.banyuan.springboot_demo.service;

import club.banyuan.springboot_demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserDao userDao;



}
