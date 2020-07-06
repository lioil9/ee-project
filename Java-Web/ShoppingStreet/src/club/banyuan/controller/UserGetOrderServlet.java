package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import club.banyuan.service.IOrderService;
import club.banyuan.service.impl.OrderServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserGetOrderServlet", urlPatterns = "/getOrder.do")
public class UserGetOrderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    IOrderService orderService = new OrderServiceImpl();
    try {
      List<Order> orders = orderService.getOrderByUserId(user.getId());
      request.setAttribute("userOrders", orders);
      request.getRequestDispatcher("Member_Order.jsp").forward(request, response);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}
