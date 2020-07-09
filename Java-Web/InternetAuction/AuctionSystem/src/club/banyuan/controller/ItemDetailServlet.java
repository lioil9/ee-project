package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ItemDetailServlet", urlPatterns = "/detail.do")
public class ItemDetailServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      Integer itemId = Integer.valueOf(request.getParameter("itemId"));
    IItemService itemService = new ItemServiceImpl();
    AuctionItem auctionItem = null;
    try {
      auctionItem = itemService.getAuctionItemById(itemId);

      if(auctionItem != null) {
        request.setAttribute("autionItem", auctionItem);
        request.getRequestDispatcher("ChangeItems.jsp").forward(request,response);
        return;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    request.getRequestDispatcher("manager/ManagerItems.jsp").forward(request,response);
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
