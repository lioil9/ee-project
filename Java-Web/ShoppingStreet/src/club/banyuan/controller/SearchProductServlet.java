package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.IProductService;
import club.banyuan.service.impl.ProductServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取搜索商品的请求
 */
@WebServlet(name = "SearchProductServlet", urlPatterns = "/search.do")
public class SearchProductServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String searchName = request.getParameter("searchName");
    if (searchName.isBlank()) {
      request.getRequestDispatcher("index.jsp").forward(request, response);
      return;
    }
    IProductService productService = new ProductServiceImpl();
    System.out.println(searchName);
    try {
      List<Product> products = productService.searchProduct(searchName);
      request.setAttribute("searchResult", products);
      request.getRequestDispatcher("CategoryList.jsp").forward(request, response);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


}
