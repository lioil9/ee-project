package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.GoodsCategory;
import club.banyuan.mall.entity.GoodsCategoryEntity;
import club.banyuan.mall.mapper.GoodsCategoryMapper;
import club.banyuan.mall.service.GoodsCategoryService;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

  @Autowired private GoodsCategoryMapper goodsCategoryMapper;

  @Override
  public PageResult getGoodsCategoryList(PageQueryUtil pageUtil) {
    List<GoodsCategoryEntity> goodsCategoryEntities =
        goodsCategoryMapper.findGoodsCategoryList(pageUtil);
    List<GoodsCategory> goodsCategories = new ArrayList<>();
    int total = goodsCategoryMapper.getTotalGoodsCategories(pageUtil);
    for (GoodsCategoryEntity goodsCategoryEntity : goodsCategoryEntities) {
      GoodsCategory goodsCategory = new GoodsCategory();
      BeanUtils.copyProperties(goodsCategoryEntity, goodsCategory);
      goodsCategories.add(goodsCategory);
    }
    return new PageResult(goodsCategories, total, pageUtil.getLimit(), pageUtil.getPage());
  }

  @Override
  public boolean saveGoodsCategory(GoodsCategory goodsCategory) {
    GoodsCategoryEntity categoryEntity =
        goodsCategoryMapper.selectByLevelAndName(
            goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
    if (categoryEntity == null) {
      GoodsCategoryEntity goodsCategoryEntity = new GoodsCategoryEntity();
      BeanUtils.copyProperties(goodsCategory, goodsCategoryEntity);
      return goodsCategoryMapper.insertSelective(goodsCategoryEntity) > 0;
    }
    return false;
  }

  @Override
  public boolean updateGoodsCategory(GoodsCategory goodsCategory) {
    GoodsCategoryEntity entity =
        goodsCategoryMapper.selectByLevelAndName(
            goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
    if (entity != null && !entity.getCategoryId().equals(goodsCategory.getCategoryId())) {
      return false;
    }
    GoodsCategoryEntity goodsCategoryEntity =
        goodsCategoryMapper.selectByPrimaryKey(goodsCategory.getCategoryId());
    if (goodsCategoryEntity != null) {
      goodsCategoryEntity.setCategoryLevel(goodsCategory.getCategoryLevel());
      goodsCategoryEntity.setCategoryName(goodsCategory.getCategoryName());
      goodsCategoryEntity.setCategoryRank(goodsCategory.getCategoryRank());
      goodsCategoryEntity.setParentId(goodsCategory.getParentId());
      goodsCategoryEntity.setUpdateTime(new Date());
      return goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategoryEntity) > 0;
    }
    return false;
  }

  @Override
  public boolean deleteBatch(Integer[] ids) {
    if (ids.length < 1) {
      return false;
    }
    return goodsCategoryMapper.deleteBatch(ids) > 0;
  }

  @Override
  public List<GoodsCategory> selectByLevelAndParentIdsAndNumber(
      List<Long> parentIds, int categoryLevel) {
    List<GoodsCategoryEntity> goodsCategoryEntities = goodsCategoryMapper.selectByLevelAndParentIdsAndNumber(parentIds, categoryLevel, 0);
    List<GoodsCategory> goodsCategories = new ArrayList<>();
    for (GoodsCategoryEntity goodsCategoryEntity : goodsCategoryEntities) {
      GoodsCategory goodsCategory = new GoodsCategory();
      BeanUtils.copyProperties(goodsCategoryEntity, goodsCategory);
      goodsCategories.add(goodsCategory);
    }
    return goodsCategories;
  }

  @Override
  public GoodsCategory getGoodsCategoryById(Long categoryId) {
    GoodsCategoryEntity goodsCategoryEntity = goodsCategoryMapper.selectByPrimaryKey(categoryId);
    GoodsCategory goodsCategory = new GoodsCategory();
    if(goodsCategoryEntity != null){
      BeanUtils.copyProperties(goodsCategoryEntity, goodsCategory);
    }
    return goodsCategory;
  }
}
