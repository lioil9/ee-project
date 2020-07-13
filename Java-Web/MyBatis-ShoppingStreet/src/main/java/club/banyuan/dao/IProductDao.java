package club.banyuan.dao;

import club.banyuan.entity.Product;
import java.util.List;

public interface IProductDao {
  List<Product> getProductByName(String name);
  Product getProductById(Integer id);
}
