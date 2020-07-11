package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteItemServlet", urlPatterns = "/delete.do")
public class DeleteItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    Integer itemId = Integer.valueOf(request.getParameter("itemId"));
    IItemService itemService = new ItemServiceImpl();
    response.setCharacterEncoding("utf-8");
    PrintWriter writer = response.getWriter();
    try {
      itemService.deleteAuctionItem(itemId);
      request.setAttribute("page", 1);
      request.setAttribute("identity", "manager");
      request.getRequestDispatcher("managerGetAuctionItems.do").forward(request, response);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
