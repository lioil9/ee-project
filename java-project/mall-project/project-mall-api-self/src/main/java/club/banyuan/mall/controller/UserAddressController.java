package club.banyuan.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.config.annotation.TokenToMallUser;
import club.banyuan.mall.dto.MallUser;
import club.banyuan.mall.dto.UserAddressDto;
import club.banyuan.mall.param.SaveMallUserAddressParam;
import club.banyuan.mall.param.UpdateMallUserAddressParam;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
public class UserAddressController {

	@GetMapping("/address")
	public Result<List<UserAddressDto>> addressList(
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/address")
	public Result<Boolean> saveUserAddress(
			@RequestBody SaveMallUserAddressParam saveMallUserAddressParam,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PutMapping("/address")
	public Result<Boolean> updateMallUserAddress(
			@RequestBody UpdateMallUserAddressParam updateMallUserAddressParam,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/address/{addressId}")
	public Result<UserAddressDto> getMallUserAddress(
			@PathVariable("addressId") Long addressId,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/address/default")
	public Result getDefaultMallUserAddress(@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@DeleteMapping("/address/{addressId}")
	public Result deleteAddress(
			@PathVariable("addressId") Long addressId,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

}
