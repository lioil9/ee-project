package club.banyuan.dao.impl;

import club.banyuan.dao.IProductDao;
import club.banyuan.entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl implements IProductDao {

  public ProductDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<Product> getProductByName(String name) {
    List<Product> products = new ArrayList<>();
    String sql = "select * from product where name like ? or description like ?";
    Object[] parms = new Object[]{"%"+name+"%","%"+name+"%"};
    ResultSet rs = this.executeQuery(sql,parms);
    try{
      while (rs.next()){
        products.add(this.tableToClass(rs));
      }
    } catch (Exception e){
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }

    return products;
  }

  @Override
  public Product getProductById(Integer id) {
    Product product = null;
    String sql = "select * from product where id = ?";
    Object[] parms = new Object[]{id};
    ResultSet rs = this.executeQuery(sql,parms);
    try{
      while (rs.next()){
        product = this.tableToClass(rs);
      }
    } catch (Exception e){
      e.printStackTrace();
    } finally{
      this.closeResource();
      this.closeResource(rs);
    }
    return product;
  }

  @Override
  public Product tableToClass(ResultSet rs) throws Exception {
    Product product = new Product();
    product.setId(rs.getInt("id"));
    product.setName(rs.getString("name"));
    product.setDescription(rs.getString("description"));
    product.setPrice((double) rs.getFloat("price"));
    product.setStock(rs.getInt("stock"));
    product.setCategoryLevel1Id(rs.getInt("CategoryLevel1Id"));
    product.setCategoryLevel2Id(rs.getInt("CategoryLevel2Id"));
    product.setCategoryLevel3Id(rs.getInt("CategoryLevel3Id"));
    product.setFileName(rs.getString("fileName"));
    product.setIsDelete(rs.getInt("isDelete"));

    return product;
  }
}
