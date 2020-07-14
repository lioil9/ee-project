package club.banyuan.dao;

import club.banyuan.entity.Manager;
import org.apache.ibatis.annotations.Param;

public interface IManagerDao {
  Manager getLogin(@Param("userName") String userName, @Param("password") String password);
}
