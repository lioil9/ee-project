package club.banyuan.mall.service.impl;

import club.banyuan.mall.dto.NewBeeMallGoods;
import club.banyuan.mall.entity.GoodsEntity;
import club.banyuan.mall.mapper.GoodsMapper;
import club.banyuan.mall.service.GoodsService;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Autowired private GoodsMapper goodsMapper;

  @Override
  public PageResult getGoodsList(PageQueryUtil pageUtil) {
    List<GoodsEntity> goodsEntities = goodsMapper.findGoodsList(pageUtil);
    List<NewBeeMallGoods> newBeeMallGoodsList = new ArrayList<>();
    int total = goodsMapper.getTotalGoods(pageUtil);
    for (GoodsEntity goodsEntity : goodsEntities) {
      NewBeeMallGoods newBeeMallGood = new NewBeeMallGoods();
      BeanUtils.copyProperties(goodsEntity, newBeeMallGood);
      newBeeMallGoodsList.add(newBeeMallGood);
    }
    return new PageResult(newBeeMallGoodsList, total, pageUtil.getLimit(), pageUtil.getPage());
  }

  @Override
  public NewBeeMallGoods getGoodsById(Long goodsId) {
    GoodsEntity goodsEntity = goodsMapper.selectByPrimaryKey(goodsId);
    NewBeeMallGoods goods = new NewBeeMallGoods();
    if (goodsEntity != null) {
      BeanUtils.copyProperties(goodsEntity, goods);
    }
    return goods;
  }

  @Override
  public boolean saveGoods(NewBeeMallGoods goods) {
    GoodsEntity goodsEntity = new GoodsEntity();
    BeanUtils.copyProperties(goods, goodsEntity);
    return goodsMapper.insertSelective(goodsEntity) > 0;
  }

  @Override
  public boolean updateGoods(NewBeeMallGoods goods) {
    GoodsEntity goodsEntity = goodsMapper.selectByPrimaryKey(goods.getGoodsId());
    if (goodsEntity != null) {
      GoodsEntity temp = new GoodsEntity();
      BeanUtils.copyProperties(goods, temp);
      return goodsMapper.updateByPrimaryKeySelective(temp) > 0;
    }
    return false;
  }

  @Override
  public boolean updateGoodsSellStatusBatch(Long[] goodsIds, int sellStatus) {
    return goodsMapper.batchUpdateSellStatus(goodsIds, sellStatus) > 0;
  }
}
