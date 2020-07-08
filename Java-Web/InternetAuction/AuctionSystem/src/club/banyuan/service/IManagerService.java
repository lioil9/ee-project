package club.banyuan.service;

import club.banyuan.entity.Manager;
import java.sql.SQLException;

public interface IManagerService {
  Manager login(String userName,String password) throws SQLException;
}
