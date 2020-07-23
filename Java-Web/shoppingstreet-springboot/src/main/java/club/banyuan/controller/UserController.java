package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.IUserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class UserController {
  @Autowired
  private IUserService userService;



  @RequestMapping("/user/login")
  public String login(Model model, String loginName, String password) {
    try {
      System.out.println(loginName);
      System.out.println(password);
      User loginUser = userService.login(loginName, password);
      if (loginUser != null) {
        System.out.println(loginUser);
        model.addAttribute("user", loginUser);
        return "Index";
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("登陆失败");
    }
    return "Login";
  }

  @RequestMapping("/user/logout")
  public String logout(HttpSession session, SessionStatus status) {
    System.out.println("logout");
    status.setComplete();
    session.invalidate();
    return "Index";
  }

  @RequestMapping("/user/register")
  public String register(User user) {
    try {
      userService.register(user);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("注册失败");
    }
    return "Login";
  }

  @RequestMapping("/user/loginNameValidate")
  @ResponseBody
  public String registerValidate(String loginName) {
    System.out.println(loginName);
    String result = "true";
    try {
      if (userService.isExist(loginName)) {
        result = "false";
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @RequestMapping("/user/member")
  public String getUserMember(HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "Login";
    }
    return "user/Member";
  }

  @RequestMapping("/user/getAddress")
  public String getUserAddress(HttpSession session,Model model) {
    try {
      User user = (User) session.getAttribute("user");
      model.addAttribute("userAddressList",userService.getAddress(user.getId()));
      System.out.println(userService.getAddress(user.getId()));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "user/Member_Address";
  }
}
