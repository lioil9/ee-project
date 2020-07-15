package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.SoldItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.ISoldItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import club.banyuan.service.impl.SoldItemServiceImpl;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetAuctionResultServlet", urlPatterns = "/getAuctionResult.do")
public class GetAuctionResultServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    ISoldItemService soldItemService = new SoldItemServiceImpl();
    IItemService itemService = new ItemServiceImpl();
    List<SoldItem> soldItemList = new ArrayList<>();
    List<AuctionItem> auctionItemList = new ArrayList<>();
    try {
      soldItemList = soldItemService.getAllSoldItem();
      for (SoldItem soldItem : soldItemList) {
        auctionItemList.add(itemService.getAuctionItemById(soldItem.getItemId()));
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
