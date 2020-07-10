package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ChangeItemServlet", urlPatterns = "/changeItem.do")
public class ChangeItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    IItemService itemService = new ItemServiceImpl();
    request.setCharacterEncoding("utf-8");

    try {
      Integer id =  Integer.valueOf(request.getParameter("itemId"));
      AuctionItem auctionItem = itemService.getAuctionItemById(id);
      auctionItem.setName(request.getParameter("name"));
      auctionItem.setStartPrice(Double.valueOf(request.getParameter("startPrice")));
      auctionItem.setBasePrice(Double.valueOf(request.getParameter("basePrice")));
      auctionItem.setStartTime(request.getParameter("startTime"));
      auctionItem.setEndTime(request.getParameter("endTime"));
      auctionItem.setRemark(request.getParameter("remark"));

      itemService.changeAuctionItem(auctionItem);

      response.sendRedirect("managerGetAuctionItems.do");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
