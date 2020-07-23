package club.banyuan.service.impl;

import club.banyuan.dao.IProductDao;
import club.banyuan.entity.Product;
import club.banyuan.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
  @Autowired
  private IProductDao productDao;


  @Override
  public List<Product> searchProduct(String name) throws Exception {

    return productDao.getProductByName(name);
  }

  @Override
  public Product searchProductById(Integer id) throws Exception {
    return productDao.getProductById(id);
  }
}
