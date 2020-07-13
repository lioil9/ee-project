package club.banyuan.service;

import club.banyuan.entity.SoldItem;
import java.sql.SQLException;
import java.util.List;

public interface ISoldItemService {
    List<SoldItem> getAllSoldItem() throws SQLException;
    Boolean addSoldItem(SoldItem soldItem) throws SQLException;
}
