package club.banyuan.service;

import club.banyuan.entity.Product;
import java.sql.SQLException;
import java.util.List;

public interface IProductService {
  List<Product> searchProduct(String name) throws SQLException;
  Product searchProductById(Integer id)throws SQLException;
}
