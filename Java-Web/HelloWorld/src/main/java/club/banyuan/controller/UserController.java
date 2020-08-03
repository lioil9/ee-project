package club.banyuan.controller;

import club.banyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/year")
    public String getCurrentYear(){
        return userService.getCurrentYear();
    }

    @PostMapping("/birthYear")
    public String getBirthYearByAge(@RequestParam("age") int age){
        return userService.getBirthYearByAge(age);
    }

}
