package club.banyuan.service;

import club.banyuan.entity.Product;
import java.util.List;

public interface IProductService {
  List<Product> searchProduct(String name) throws Exception;
  Product searchProductById(Integer id)throws Exception;
}
