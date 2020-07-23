package club.banyuan.springboot_demo.controller;

import club.banyuan.springboot_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
  @Autowired
  private User user;

  @GetMapping()
  public String getUser(Model model){
    user.setId(1);
    user.setLoginName("lioil");


    return "user";
  }
}
