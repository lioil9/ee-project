package club.banyuan.myblog.controller;


import club.banyuan.myblog.service.IUserService;
import club.banyuan.myblog.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lioil
 * @since 2020-08-06
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

//    @GetMapping("/login")
//    public String currentUsername(){
//        return UserUtil.getCurrentUser().getUsername();
//    }

}
