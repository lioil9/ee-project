package club.banyuan.mall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@PostMapping("/profile/password")
	public String updatePassword(HttpServletRequest request, @RequestParam("originalPassword") String originalPassword,
            @RequestParam("newPassword") String newPassword) {
		return "修改失败"; // "success"
	}
	
	@PostMapping("/profile/name")
	public String updateName(HttpServletRequest request, @RequestParam("loginUserName") String loginUserName,
            @RequestParam("nickName") String nickName) {
		return "修改失败"; // "success"
	}
}
