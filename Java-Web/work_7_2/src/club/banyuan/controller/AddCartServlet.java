package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.IProductService;
import club.banyuan.service.impl.ProductServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddCartServlet", urlPatterns = "/addCart.do")
public class AddCartServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    int id = Integer.valueOf(request.getParameter("pid"));
    int num = Integer.valueOf(request.getParameter("quantity"));
    IProductService productService = new ProductServiceImpl();
    Product product = null;
    try {
      product = productService.searchProductById(id);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    if(product!=null) {
      HttpSession session = request.getSession();
      Map<Product, Integer> cart;
      if(session.getAttribute("cart") == null){
        cart  = new HashMap<>();
      }else {
        cart = (Map<Product, Integer>) session.getAttribute("cart");
      }
      if(cart.containsKey(product)){
        cart.replace(product,cart.get(product)+num);
      }else {
        cart.put(product,num);
      }
      session.setAttribute("cart",cart);
    }

    request.getRequestDispatcher("<%=request.getContextPath()%>/user/BuyCar.jsp").forward(request,response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(request.getParameter("quantity"));
    System.out.println(request.getParameter("pid"));


  }
}
