package club.banyuan.dao;

import club.banyuan.entity.SoldItem;
import java.util.List;

public interface ISoldItemDao {
  Integer add(SoldItem soldItem);
  List<SoldItem> getAllSoldItem();
}
