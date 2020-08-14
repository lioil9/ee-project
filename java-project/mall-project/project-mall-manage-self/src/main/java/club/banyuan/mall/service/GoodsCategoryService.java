package club.banyuan.mall.service;

import club.banyuan.mall.dto.GoodsCategory;
import club.banyuan.mall.entity.GoodsCategoryEntity;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;

import java.util.List;

public interface GoodsCategoryService {
    PageResult getGoodsCategoryList(PageQueryUtil pageUtil);
    boolean saveGoodsCategory(GoodsCategory goodsCategory);
    boolean updateGoodsCategory(GoodsCategory goodsCategory);
    boolean deleteBatch(Integer[] ids);
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
    GoodsCategory getGoodsCategoryById(Long categoryId);
}
