package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.IOrderService;
import club.banyuan.service.IUserAddressService;
import club.banyuan.service.impl.OrderServiceImpl;
import club.banyuan.service.impl.UserAddressServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddOrderServlet", urlPatterns = "/addOrder.do")
public class AddOrderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("user") == null) {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } else {
      User user = (User) session.getAttribute("user");

      IUserAddressService userAddressService = new UserAddressServiceImpl();
      String address = null;
      try {
        address = userAddressService.getDefaultAddress(user.getId()).getAddress();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      double totalPrice = Double.parseDouble(session.getAttribute("totalPrice").toString());
      Map<Product, Integer> car = (Map<Product, Integer>) session.getAttribute("cart");
      IOrderService orderService = new OrderServiceImpl();
      Order order = orderService.addOrder(car, totalPrice, user, address);
      request.setAttribute("order", order);

      session.removeAttribute("cart");
      session.removeAttribute("totalPrice");
      request.getRequestDispatcher("BuyCar_Three.jsp").forward(request, response);
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
