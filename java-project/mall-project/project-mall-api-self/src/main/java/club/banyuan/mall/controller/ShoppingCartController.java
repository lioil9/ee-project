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
import club.banyuan.mall.dto.ShoppingCartItemDto;
import club.banyuan.mall.param.SaveCartItemParam;
import club.banyuan.mall.param.UpdateCartItemParam;
import club.banyuan.mall.util.PageResult;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
public class ShoppingCartController {

	@GetMapping("/shop-cart/page")
	public Result<PageResult<List<ShoppingCartItemDto>>> cartItemPageList(
			Integer pageNumber,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/shop-cart")
	public Result<List<ShoppingCartItemDto>> cartItemList(
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/shop-cart")
	public Result saveNewBeeMallShoppingCartItem(
			@RequestBody SaveCartItemParam saveCartItemParam,
            @TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PutMapping("/shop-cart")
	public Result updateNewBeeMallShoppingCartItem(
			@RequestBody UpdateCartItemParam updateCartItemParam,
            @TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@DeleteMapping("/shop-cart/{newBeeMallShoppingCartItemId}")
	public Result updateNewBeeMallShoppingCartItem(
			@PathVariable("newBeeMallShoppingCartItemId") Long newBeeMallShoppingCartItemId,
            @TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/shop-cart/settle")
	public Result<List<ShoppingCartItemDto>> toSettle(
			Long[] cartItemIds,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
}
