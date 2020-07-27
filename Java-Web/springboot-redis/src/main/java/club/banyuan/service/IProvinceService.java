package club.banyuan.service;

import club.banyuan.entity.Province;

import java.sql.SQLException;
import java.util.List;

public interface IProvinceService {
    List<Province> getAll() throws SQLException;
}
