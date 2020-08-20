package club.banyuan.mall.controller;

import java.util.Map;
import java.util.Objects;

import club.banyuan.mall.common.Constants;
import club.banyuan.mall.service.GoodsService;
import club.banyuan.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

	@Autowired
	private GoodsService goodsService;

	@GetMapping("/goods/list")
	public Result<?> list(@RequestParam Map<String, Object> params) {
		if(StringUtils.isEmpty(params.get("limit")) || StringUtils.isEmpty(params.get("page"))){
			return ResultGenerator.genFailResult("参数不合法");
		}
		PageQueryUtil pageUtil = new PageQueryUtil(params);
		return ResultGenerator.genSuccessResult(goodsService.getGoodsList(pageUtil));
	}
	
	@PostMapping("/goods/save")
	public Result<?> save(@RequestBody NewBeeMallGoods newBeeMallGoods) {
		if (StringUtils.isEmpty(newBeeMallGoods.getGoodsName())
				|| StringUtils.isEmpty(newBeeMallGoods.getGoodsIntro())
				|| StringUtils.isEmpty(newBeeMallGoods.getTag())
				|| Objects.isNull(newBeeMallGoods.getOriginalPrice())
				|| Objects.isNull(newBeeMallGoods.getGoodsCategoryId())
				|| Objects.isNull(newBeeMallGoods.getSellingPrice())
				|| Objects.isNull(newBeeMallGoods.getStockNum())
				|| Objects.isNull(newBeeMallGoods.getGoodsSellStatus())
				|| StringUtils.isEmpty(newBeeMallGoods.getGoodsCoverImg())
				|| StringUtils.isEmpty(newBeeMallGoods.getGoodsDetailContent())) {
			return ResultGenerator.genFailResult("参数异常！");
		}
		if(goodsService.saveGoods(newBeeMallGoods)){
			return ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("保存失败");
	}
	
	@PostMapping("/goods/update")
	public Result<?> update(@RequestBody NewBeeMallGoods newBeeMallGoods) {
		if (StringUtils.isEmpty(newBeeMallGoods.getGoodsName())
				|| StringUtils.isEmpty(newBeeMallGoods.getGoodsIntro())
				|| StringUtils.isEmpty(newBeeMallGoods.getTag())
				|| Objects.isNull(newBeeMallGoods.getOriginalPrice())
				|| Objects.isNull(newBeeMallGoods.getGoodsCategoryId())
				|| Objects.isNull(newBeeMallGoods.getSellingPrice())
				|| Objects.isNull(newBeeMallGoods.getStockNum())
				|| Objects.isNull(newBeeMallGoods.getGoodsSellStatus())
				|| StringUtils.isEmpty(newBeeMallGoods.getGoodsCoverImg())
				|| StringUtils.isEmpty(newBeeMallGoods.getGoodsDetailContent())) {
			return ResultGenerator.genFailResult("参数异常！");
		}
		if(goodsService.updateGoods(newBeeMallGoods)){
			return ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("更新失败");
	}
	
	@GetMapping("/goods/info/{id}")
	public Result<?> info(@PathVariable("id") Long id) {
		//
		return ResultGenerator.genSuccessResult();
	}
	
	@PutMapping("/goods/status/{sellStatus}")
	public Result<?> delete(@RequestBody Long[] ids, @PathVariable("sellStatus") int sellStatus) {
		if(ids.length < 1){
			return ResultGenerator.genFailResult("参数异常");
		}
		if(sellStatus != Constants.SELL_STATUS_DOWN && sellStatus!= Constants.SELL_STATUS_UP){
			return ResultGenerator.genFailResult("状态异常");
		}
		if (goodsService.updateGoodsSellStatusBatch(ids,sellStatus)){
			return ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("更新失败");
	}
}
