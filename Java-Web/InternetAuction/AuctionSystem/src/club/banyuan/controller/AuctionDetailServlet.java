package club.banyuan.controller;

import club.banyuan.dao.IBidRecordDao;
import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.BidRecord;
import club.banyuan.service.IBidRecordService;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.BidRecordServiceImpl;
import club.banyuan.service.impl.ItemServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AuctionDetailServlet", urlPatterns = "/auctionDetail.do")
public class AuctionDetailServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      Integer itemId = Integer.valueOf(request.getParameter("itemId"));
    IBidRecordService bidRecordService = new BidRecordServiceImpl();
    IItemService itemService = new ItemServiceImpl();
    AuctionItem auctionItem = null;
    List<BidRecord> bidRecordList = new ArrayList<>();
    try {
      bidRecordList = bidRecordService.getBidRecord(itemId);
      auctionItem = itemService.getAuctionItemById(itemId);
      if(auctionItem != null) {
        request.setAttribute("auctionItem", auctionItem);
        request.setAttribute("bidRecordList", bidRecordList);
        request.getRequestDispatcher("Auction.jsp").forward(request,response);
        return;
      }
    }catch (Exception e){
      e.printStackTrace();
    }
    response.sendRedirect("userGetAuctionItems.do");
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
