package club.banyuan.controller;

import club.banyuan.service.IProductService;
import club.banyuan.service.impl.ProductServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchProductServlet", urlPatterns = "/search.do")
public class SearchProductServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String searchName = request.getParameter("searchName");
    IProductService productService = new ProductServiceImpl();

    try {
      productService.searchProduct(searchName);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
