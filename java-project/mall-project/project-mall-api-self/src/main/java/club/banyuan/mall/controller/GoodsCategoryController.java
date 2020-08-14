package club.banyuan.mall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.IndexCategoryDto;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
public class GoodsCategoryController {

	@GetMapping("/categories")
	public Result<List<IndexCategoryDto>> getCategories() {
		//
		return ResultGenerator.genSuccessResult();
	}
}
