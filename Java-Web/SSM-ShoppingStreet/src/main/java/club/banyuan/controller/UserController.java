package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class UserController {
  @Autowired
  private IUserService userService;

  @RequestMapping("/user/login")
  public String login(Model model,String loginName, String password){
    try{
      System.out.println(loginName);
      System.out.println(password);
      User loginUser = userService.login(loginName,password);
      if(loginUser != null){
        System.out.println(loginUser);
        model.addAttribute("user",loginUser);
        return "index";
      }
    }catch (Exception e){
      e.printStackTrace();
      System.out.println("登陆失败");
    }
    return "Login";
  }


  @RequestMapping("/user/logout")
  public String logout(SessionStatus status){
    status.setComplete();
    return "index";
  }

  @RequestMapping("/user/register")
  public String register(User user){
    try{
      userService.register(user);
    } catch (Exception e){
      e.printStackTrace();
      System.out.println("注册失败");
    }
    return "Login";
  }

  @RequestMapping("/user/loginNameValidate")
  public String registerValidate(String loginName){
    System.out.println(loginName);
    String result = "true";
    try{
      if(userService.isExist(loginName)){
        result = "false";
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    return result;
  }
}
