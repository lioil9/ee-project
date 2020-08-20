package club.banyuan.mall.service;

import club.banyuan.mall.dto.NewBeeMallGoods;
import club.banyuan.mall.util.PageQueryUtil;
import club.banyuan.mall.util.PageResult;

public interface GoodsService {
    PageResult getGoodsList(PageQueryUtil pageUtil);
    NewBeeMallGoods getGoodsById(Long goodsId);
    boolean saveGoods(NewBeeMallGoods goods);
    boolean updateGoods(NewBeeMallGoods goods);
    boolean updateGoodsSellStatusBatch(Long[] goodsIds, int sellStatus);
}
