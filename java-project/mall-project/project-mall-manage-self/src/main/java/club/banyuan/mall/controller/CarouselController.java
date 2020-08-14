package club.banyuan.mall.controller;

import java.util.Map;
import java.util.Objects;

import club.banyuan.mall.service.CarouselService;
import club.banyuan.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.Carousel;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
@RequestMapping("/admin")
public class CarouselController {

  @Autowired private CarouselService carouselService;

  @GetMapping("/carousels/list")
  public Result<?> list(@RequestParam Map<String, Object> params) {
    if (StringUtils.isEmpty(params.get("limit")) || StringUtils.isEmpty(params.get("page"))) {
      return ResultGenerator.genFailResult("参数不合法！");
    }
    PageQueryUtil pageUtil = new PageQueryUtil(params);
    return ResultGenerator.genSuccessResult(carouselService.getCarousels(pageUtil));
  }

  @PostMapping("/carousels/save")
  public Result<?> save(@RequestBody Carousel carousel) {
    if (StringUtils.isEmpty(carousel.getCarouselUrl())
        || Objects.isNull(carousel.getCarouselRank())) {
      return ResultGenerator.genFailResult("参数不合法");
    }
    if (carouselService.saveCarousel(carousel)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("保存失败");
  }

  @PostMapping("/carousels/update")
  public Result<?> update(@RequestBody Carousel carousel) {
    if (Objects.isNull(carousel.getCarouselId())
        || StringUtils.isEmpty(carousel.getCarouselUrl())
        || Objects.isNull(carousel.getCarouselRank())) {
      return ResultGenerator.genFailResult("参数异常！");
    }
    boolean result = carouselService.updateCarousel(carousel);
    if (result) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("更新失败");
  }

  @GetMapping("/carousels/info/{id}")
  public Result<?> info(@PathVariable("id") Integer id) {
    Carousel carousel = carouselService.getCarouselById(id);
    if (carousel == null) {
      return ResultGenerator.genFailResult("资源不存在");
    }
    return ResultGenerator.genSuccessResult(carousel);
  }

  @PostMapping("/carousels/delete")
  public Result<?> delete(@RequestBody Integer[] ids) {
    if(ids.length < 1){
      return ResultGenerator.genFailResult("参数异常");
    }
    if(carouselService.deleteBatch(ids)){
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("删除失败");
  }
}
