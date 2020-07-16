package club.banyuan.service;

import static org.junit.Assert.*;

import club.banyuan.proxy.UserServiceProxy;
import club.banyuan.service.Impl.UserServiceImpl;
import org.junit.Test;

public class IUserServiceTest {

  @Test
  public void addUser() throws Exception {
    IUserService userService = new UserServiceImpl();
    IUserService userServiceProxy = UserServiceProxy.getProxyInstance(userService);
    userServiceProxy.addUser();

  }
}