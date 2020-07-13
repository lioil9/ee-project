package club.banyuan.service.impl;

import club.banyuan.dao.ISoldItemDao;
import club.banyuan.dao.Impl.SoldItemDaoImpl;
import club.banyuan.entity.SoldItem;
import club.banyuan.service.ISoldItemService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SoldItemServiceImpl implements ISoldItemService {


  @Override
  public List<SoldItem> getAllSoldItem() throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    ISoldItemDao soldItemDao = new SoldItemDaoImpl(connection);
    return soldItemDao.getAllSoldItem();
  }

  @Override
  public Boolean addSoldItem(SoldItem soldItem) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    ISoldItemDao soldItemDao = new SoldItemDaoImpl(connection);
    return soldItemDao.add(soldItem) > 0;
  }
}
