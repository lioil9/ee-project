package club.banyuan.dao;

import club.banyuan.entity.SoldItem;
import java.util.List;

public interface ISoldItemDao extends IBaseDao{
  Integer add(SoldItem soldItem);
  List<SoldItem> getAllSoldItem();
}
