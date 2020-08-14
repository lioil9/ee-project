package club.banyuan.mall.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.Order;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
@RequestMapping("/admin")
public class OrderController {

	@GetMapping("/orders/list")
	public Result<?> list(@RequestParam Map<String, Object> params) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/orders/update")
	public Result<?> update(@RequestBody Order newBeeMallOrder) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@GetMapping("/order-items/{id}")
	public Result<?> info(@PathVariable("id") Long id) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/orders/checkDone")
	public Result<?> checkDone(@RequestBody Long[] ids) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/orders/checkOut")
	public Result<?> checkOut(@RequestBody Long[] ids) {
		//
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/orders/close")
	public Result<?> closeOrder(@RequestBody Long[] ids) {
		//
		return ResultGenerator.genSuccessResult();
	}
}
