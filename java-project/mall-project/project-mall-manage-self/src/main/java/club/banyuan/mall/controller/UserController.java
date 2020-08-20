package club.banyuan.mall.controller;

import java.util.Map;

import club.banyuan.mall.common.Constants;
import club.banyuan.mall.service.UserService;
import club.banyuan.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/list")
	public Result<?> list(@RequestParam Map<String, Object> params) {
		if(StringUtils.isEmpty(params.get("limit")) || StringUtils.isEmpty(params.get("page"))){
			return ResultGenerator.genFailResult("参数不合法");
		}
		PageQueryUtil pageUtil = new PageQueryUtil(params);
		return ResultGenerator.genSuccessResult(userService.getUserList(pageUtil));
	}

	@PostMapping("/users/lock/{lockStatus}")
	public Result<?> delete(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
		if (ids.length < 1){
			return ResultGenerator.genFailResult("参数不合法");
		}
		if (lockStatus != Constants.USER_STATUS_LOCK && lockStatus != Constants.USER_STATUS_UNLOCK){
			return ResultGenerator.genFailResult("用户状态错误");
		}
		if (userService.updateUsersStatus(ids, lockStatus)){
			return ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("更新失败");
	}
}
