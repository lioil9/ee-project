package club.banyuan.mall.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.NewBeeMallGoods;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
@RequestMapping("/admin")
public class GoodsController {

	@GetMapping("/goods/list")
	public Result<?> list(@RequestParam Map<String, Object> params) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/goods/save")
	public Result<?> save(@RequestBody NewBeeMallGoods newBeeMallGoods) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/goods/update")
	public Result<?> update(@RequestBody NewBeeMallGoods newBeeMallGoods) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/goods/info/{id}")
	public Result<?> info(@PathVariable("id") Long id) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PutMapping("/goods/status/{sellStatus}")
	public Result<?> delete(@RequestBody Long[] ids, @PathVariable("sellStatus") int sellStatus) {
		//
		return ResultGenerator.genSuccessResult();
	}
}
