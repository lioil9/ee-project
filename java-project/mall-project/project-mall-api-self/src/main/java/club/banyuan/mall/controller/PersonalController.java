package club.banyuan.mall.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.config.annotation.TokenToMallUser;
import club.banyuan.mall.dto.MallUser;
import club.banyuan.mall.dto.UserDto;
import club.banyuan.mall.param.MallUserLoginParam;
import club.banyuan.mall.param.MallUserRegisterParam;
import club.banyuan.mall.param.MallUserUpdateParam;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
public class PersonalController {

	@PostMapping("/user/login")
	public Result<String> login(@RequestBody @Valid MallUserLoginParam mallUserLoginParam) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/user/logout")
	public Result<String> logout(@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/user/register")
	public Result register(@RequestBody @Valid MallUserRegisterParam mallUserRegisterParam) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PutMapping("/user/info")
	public Result updateInfo(
			@RequestBody MallUserUpdateParam mallUserUpdateParam,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/user/info")
	public Result<UserDto> getUserDetail(@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
}
