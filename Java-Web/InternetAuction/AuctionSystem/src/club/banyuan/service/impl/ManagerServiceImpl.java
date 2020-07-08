package club.banyuan.service.impl;

import club.banyuan.dao.IManagerDao;
import club.banyuan.dao.Impl.ManagerDaoImpl;
import club.banyuan.entity.Manager;
import club.banyuan.service.IManagerService;
import club.banyuan.util.DataSourceUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class ManagerServiceImpl implements IManagerService {

  @Override
  public Manager login(String userName, String password) throws SQLException {
    Connection connection = DataSourceUtil.openConnection();
    IManagerDao managerDao = new ManagerDaoImpl(connection);
    return managerDao.getLogin(userName,password);
  }
}
