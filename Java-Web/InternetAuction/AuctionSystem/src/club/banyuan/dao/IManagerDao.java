package club.banyuan.dao;

import club.banyuan.entity.Manager;

public interface IManagerDao extends IBaseDao{
  Manager getLogin(String userName, String password);
}
