package club.banyuan.mall.mapper;

import club.banyuan.mall.entity.GoodsEntity;
import club.banyuan.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
  List<GoodsEntity> findGoodsList(PageQueryUtil pageUtil);

  int getTotalGoods(PageQueryUtil pageUtil);

  int insertSelective(GoodsEntity goodsEntity);

  int updateByPrimaryKeySelective(GoodsEntity goodsEntity);

  int batchUpdateSellStatus(
      @Param("orderIds") Long[] orderIds, @Param("sellStatus") int sellStatus);

  GoodsEntity selectByPrimaryKey(Long goodsId);
}
