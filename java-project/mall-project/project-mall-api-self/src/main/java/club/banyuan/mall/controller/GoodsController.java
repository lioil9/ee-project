package club.banyuan.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.config.annotation.TokenToMallUser;
import club.banyuan.mall.dto.GoodsDetailDto;
import club.banyuan.mall.dto.MallUser;
import club.banyuan.mall.dto.SearchGoodsDto;
import club.banyuan.mall.util.PageResult;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
public class GoodsController {

	@GetMapping("/search")
	public Result<PageResult<List<SearchGoodsDto>>> search(
			@RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long goodsCategoryId,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) Integer pageNumber,
            @TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@GetMapping("/goods/detail/{goodsId}")
	public Result<GoodsDetailDto> goodsDetail(
			@PathVariable("goodsId") Long goodsId,
			@TokenToMallUser MallUser loginMallUser) {
		//
		return ResultGenerator.genSuccessResult();
	}

}
