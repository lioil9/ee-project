package club.banyuan.blog.controller;

import club.banyuan.blog.dto.Result;
import club.banyuan.blog.dto.UserBaseDto;
import club.banyuan.blog.service.UserService;
import club.banyuan.blog.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/currentUserName")
    public String currentUsername(){
        return UserUtil.getCurrentUser().getNickname();
    }

    @RequestMapping("/currentUserEmail")
    public String currentUserEmail(){
        UserBaseDto userBaseDto = userService.getUserBaseInfoById();
        if(userBaseDto != null){
            return userBaseDto.getEmail();
        }
        return "";
    }

    @RequestMapping(value = "/updateUserEmail", method = RequestMethod.PUT)
    public Result updateUserEmail(String email){
        if(userService.updateUserEmail(email)){
            return new Result("success", "开启成功");
        }
        return new Result("error", "开启失败");
    }

    @RequestMapping("/isAdmin")
    public Boolean isAdmin(){
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) UserUtil.getCurrentUser().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().contains("超级管理员")){
                return true;
            }
        }
        return false;
    }

}
