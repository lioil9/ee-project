package club.banyuan.service.impl;

import club.banyuan.dao.IProductDao;
import club.banyuan.dao.impl.ProductDaoImpl;
import club.banyuan.entity.Product;
import club.banyuan.service.IProductService;
import club.banyuan.util.DataSourceUtil;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {

  @Override
  public List<Product> searchProduct(String name) throws SQLException {
    IProductDao productDao = new ProductDaoImpl(DataSourceUtil.openConnection());
    return productDao.getProductByName(name);
  }
}
