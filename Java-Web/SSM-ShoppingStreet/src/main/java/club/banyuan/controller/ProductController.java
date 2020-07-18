package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
  @Autowired
  private IProductService productService;

  @RequestMapping("/search")
  public String searchProduct(String searchName, Model model){
    System.out.println(searchName);
    try{
      List<Product>  products = productService.searchProduct(searchName);
      model.addAttribute("searchResult",products);
    } catch (Exception e){
      e.printStackTrace();
    }
    return "CategoryList";
  }

  @RequestMapping("/getProductDetail")
  public String getProductDetail(Integer pid, Model model){
    System.out.println(pid);
    try{
      Product product = productService.searchProductById(pid);
      model.addAttribute("product", product);
    } catch (Exception e){
      e.printStackTrace();
    }
    return "Product";
  }

}
