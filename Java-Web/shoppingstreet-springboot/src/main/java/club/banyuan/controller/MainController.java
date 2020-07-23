package club.banyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/")
  public String index(){
    return "Index";
  }

  @RequestMapping("/getLogin")
  public String getLogin(){
    return "Login";
  }

  @RequestMapping("/getRegister")
  public String getRegister(){
    return "Regist";
  }


}
