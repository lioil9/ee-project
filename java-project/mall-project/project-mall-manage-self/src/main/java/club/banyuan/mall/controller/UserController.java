package club.banyuan.mall.controller;

import java.util.Map;

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

	@GetMapping("/users/list")
	public Result<?> list(@RequestParam Map<String, Object> params) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/users/lock/{lockStatus}")
	public Result<?> delete(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
		//
		return ResultGenerator.genSuccessResult();
	}
}
