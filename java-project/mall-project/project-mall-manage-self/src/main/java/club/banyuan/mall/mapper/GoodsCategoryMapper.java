package club.banyuan.mall.mapper;

import club.banyuan.mall.dto.GoodsCategory;
import club.banyuan.mall.entity.GoodsCategoryEntity;
import club.banyuan.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
    List<GoodsCategoryEntity> findGoodsCategoryList(PageQueryUtil pageUtil);
    int getTotalGoodsCategories(PageQueryUtil pageUtil);
    int insertSelective(GoodsCategoryEntity goodsCategoryEntity);
    GoodsCategoryEntity selectByLevelAndName(@Param("categoryLevel")Byte categoryLevel, @Param("categoryName")String categoryName);
    GoodsCategoryEntity selectByPrimaryKey(Long categoryId);
    int deleteBatch(Integer[] ids);
    int updateByPrimaryKeySelective(GoodsCategoryEntity goodsCategoryEntity);
    List<GoodsCategoryEntity> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);
}
