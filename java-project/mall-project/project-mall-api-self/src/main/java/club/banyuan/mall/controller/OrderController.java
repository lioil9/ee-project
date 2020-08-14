package club.banyuan.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.config.annotation.TokenToMallUser;
import club.banyuan.mall.dto.MallUser;
import club.banyuan.mall.dto.OrderDetailDto;
import club.banyuan.mall.dto.OrderListDto;
import club.banyuan.mall.param.SaveOrderParam;
import club.banyuan.mall.util.PageResult;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
public class OrderController {

	@PostMapping("/saveOrder")
	public Result<String> saveOrder(
			@RequestBody SaveOrderParam saveOrderParam,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/order/{orderNo}")
	public Result<OrderDetailDto> orderDetailPage(
			@PathVariable("orderNo") String orderNo,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/order")
	public Result<PageResult<List<OrderListDto>>> orderList(
			@RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer status,
            @TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PutMapping("/order/{orderNo}/cancel")
	public Result cancelOrder(
			@PathVariable("orderNo") String orderNo,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PutMapping("/order/{orderNo}/finish")
	public Result finishOrder(
			@PathVariable("orderNo") String orderNo,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/paySuccess")
	public Result paySuccess(
			@RequestParam("orderNo") String orderNo,
			@RequestParam("payType") int payType) {
		//
		return ResultGenerator.genSuccessResult();
	}
}
