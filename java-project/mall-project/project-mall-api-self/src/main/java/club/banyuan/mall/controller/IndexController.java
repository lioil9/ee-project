package club.banyuan.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.IndexInfoDto;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;


@RestController
public class IndexController {

	@GetMapping("/index-infos")
	public Result<IndexInfoDto> indexInfo() {
		//
		return ResultGenerator.genSuccessResult();
	}
}
