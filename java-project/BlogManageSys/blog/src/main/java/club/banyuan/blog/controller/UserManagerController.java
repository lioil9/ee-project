package club.banyuan.blog.controller;

import club.banyuan.blog.dto.Result;
import club.banyuan.blog.dto.RoleDto;
import club.banyuan.blog.dto.UserDto;
import club.banyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserManagerController {

  @Autowired private UserService userService;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public List<UserDto> getUserByNickname(String nickname) {
    return userService.getUserByNickname(nickname);
  }

  @RequestMapping(value = "/roles", method = RequestMethod.GET)
  public List<RoleDto> getAllRole() {
    return userService.getAllRole();
  }

  @RequestMapping(value = "/user/enabled", method = RequestMethod.PUT)
  public Result updateUserEnable(Long uid, Boolean enabled) {
    boolean result = userService.updateUserEnabled(uid, enabled);
    if (result) {
      return new Result("success", "更新成功");
    } else {
      return new Result("error", "更新失败");
    }
  }

  @RequestMapping(value = "/user/role", method = RequestMethod.PUT)
  public Result updateUserRoles(Long id, Long[] rids){
    boolean result = userService.updateUserRoles(id, rids);
    if(result){
      return new Result("success", "更新成功");
    }else {
      return new Result("error", "更新失败");
    }
  }

  //TODO 待改造
  @RequestMapping(value = "/user/{uid}", method = RequestMethod.DELETE)
  public Result deleteUserById(@PathVariable Long uid){
    boolean result = userService.updateUserEnabled(uid, false);
    if(result){
      return new Result("success","删除成功");
    }else {
      return new Result("error", "删除失败");
    }
  }

}
