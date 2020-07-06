package club.banyuan.controller;

import club.banyuan.entity.Product;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConfirmOrderServlet", urlPatterns = "confirm.do")
public class ConfirmOrderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      request.getRequestDispatcher("Login.jsp").forward(request, response);
    } else {
      // 2、计算总价
      Map<Product, Integer> car = (Map<Product, Integer>) session.getAttribute("cart");
      double totalPrice = 0;
      for (Product product : car.keySet()) {
        totalPrice += product.getPrice() * car.get(product);
      }
      session.setAttribute("totalPrice", totalPrice);
      request.getRequestDispatcher("BuyCar_Two.jsp").forward(request, response);
    }
  }
}
