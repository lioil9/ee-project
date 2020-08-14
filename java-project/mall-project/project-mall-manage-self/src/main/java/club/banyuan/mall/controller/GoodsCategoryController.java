package club.banyuan.mall.controller;

import java.util.*;

import club.banyuan.mall.common.CategoryLevelEnum;
import club.banyuan.mall.service.GoodsCategoryService;
import club.banyuan.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import club.banyuan.mall.dto.GoodsCategory;
import club.banyuan.mall.util.Result;
import club.banyuan.mall.util.ResultGenerator;

@RestController
@RequestMapping("/admin")
public class GoodsCategoryController {

  @Autowired private GoodsCategoryService goodsCategoryService;

  @GetMapping("/categories/list")
  public Result<?> list(@RequestParam Map<String, Object> params) {
    if (StringUtils.isEmpty(params.get("limit")) || StringUtils.isEmpty(params.get("page"))) {
      return ResultGenerator.genFailResult("参数不合法！");
    }
    PageQueryUtil pageUtil = new PageQueryUtil(params);
    return ResultGenerator.genSuccessResult(goodsCategoryService.getGoodsCategoryList(pageUtil));
  }

  @GetMapping("/categories/listForSelect")
  public Result<?> listForSelect(@RequestParam("categoryId") Long categoryId) {
    if (Objects.isNull(categoryId) || categoryId < 1) {
      return ResultGenerator.genFailResult("参数不合法");
    }
    GoodsCategory goodsCategory = goodsCategoryService.getGoodsCategoryById(categoryId);
    if (goodsCategory == null
        || goodsCategory.getCategoryLevel() == CategoryLevelEnum.LEVEL_THREE.getLevel()) {
      return ResultGenerator.genFailResult("参数异常！");
    }
    Map<String, List<GoodsCategory>> result = new HashMap<>(2);
    if (goodsCategory.getCategoryLevel() == CategoryLevelEnum.LEVEL_ONE.getLevel()) {
      List<GoodsCategory> secondLevelCategories =
          goodsCategoryService.selectByLevelAndParentIdsAndNumber(
              Collections.singletonList(categoryId), CategoryLevelEnum.LEVEL_TWO.getLevel());
      if (!CollectionUtils.isEmpty(secondLevelCategories)) {
        List<GoodsCategory> thirdLevelCategories =
            goodsCategoryService.selectByLevelAndParentIdsAndNumber(
                Collections.singletonList(secondLevelCategories.get(0).getCategoryId()),
                CategoryLevelEnum.LEVEL_THREE.getLevel());
        result.put("secondLevelCategories", secondLevelCategories);
        result.put("thirdLevelCategories", thirdLevelCategories);
      }
    }
    if (goodsCategory.getCategoryLevel() == CategoryLevelEnum.LEVEL_TWO.getLevel()) {
      List<GoodsCategory> thirdLevelCategories =
          goodsCategoryService.selectByLevelAndParentIdsAndNumber(
              Collections.singletonList(categoryId), CategoryLevelEnum.LEVEL_THREE.getLevel());
      result.put("thirdLevelCategories", thirdLevelCategories);
    }
    return ResultGenerator.genSuccessResult(result);
  }

  @PostMapping("/categories/save")
  public Result<?> save(@RequestBody GoodsCategory goodsCategory) {
    if (Objects.isNull(goodsCategory.getCategoryLevel())
        || StringUtils.isEmpty(goodsCategory.getCategoryName())
        || Objects.isNull(goodsCategory.getCategoryRank())
        || Objects.isNull(goodsCategory.getParentId())) {
      return ResultGenerator.genFailResult("参数不合法");
    }
    if (goodsCategoryService.saveGoodsCategory(goodsCategory)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("保存失败");
  }

  @PostMapping("/categories/update")
  public Result<?> update(@RequestBody GoodsCategory goodsCategory) {
    if (Objects.isNull(goodsCategory.getCategoryId())
        || Objects.isNull(goodsCategory.getCategoryLevel())
        || StringUtils.isEmpty(goodsCategory.getCategoryName())
        || Objects.isNull(goodsCategory.getCategoryRank())
        || Objects.isNull(goodsCategory.getParentId())) {
      return ResultGenerator.genFailResult("参数不合法");
    }
    if (goodsCategoryService.updateGoodsCategory(goodsCategory)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("更新失败");
  }

  @GetMapping("/categories/info/{id}")
  public Result<?> info(@PathVariable("id") Long id) {
    //
    return ResultGenerator.genSuccessResult();
  }

  @PostMapping("/categories/delete")
  public Result<?> delete(@RequestBody Integer[] ids) {
    if (ids.length < 1) {
      return ResultGenerator.genFailResult("参数不合法");
    }
    if (goodsCategoryService.deleteBatch(ids)) {
      return ResultGenerator.genSuccessResult();
    }
    return ResultGenerator.genFailResult("删除失败");
  }
}
