package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.IProductService;
import club.banyuan.service.impl.ProductServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取跳转详情页的请求
 */
@WebServlet(name = "ProductDetailServlet", urlPatterns = "/detail.do")
public class ProductDetailServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String pid = request.getParameter("pid");
    IProductService productService = new ProductServiceImpl();
    try {
      Product product = productService.searchProductById(Integer.valueOf(pid));
      request.setAttribute("product", product);
      request.getRequestDispatcher("Product.jsp").forward(request, response);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
