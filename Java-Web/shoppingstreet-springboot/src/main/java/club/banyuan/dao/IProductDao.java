package club.banyuan.dao;

import club.banyuan.entity.Product;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IProductDao {
  List<Product> getProductByName(String name);
  Product getProductById(Integer id);
}
