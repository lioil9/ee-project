package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "GetItemsServlet", urlPatterns = "/getAuctionItems.do")
public class GetAuctionItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    List<AuctionItem> auctionItems = new ArrayList<>();
    System.out.println("auction");
    try {
      IItemService iItemService = new ItemServiceImpl();
      HttpSession session = request.getSession();
      String name = request.getParameter("name");
      Double startPrice = request.getParameter("startPrice") == null ? null
          : Double.valueOf(request.getParameter("startPrice"));
      String startTime = request.getParameter("startTime");
      String endTime = request.getParameter("endTime");
      String remark = request.getParameter("remark");
      Integer page = (Integer) request.getAttribute("page");

      auctionItems = iItemService
          .getAuctionItems(name, remark, startTime, endTime, startPrice, page);
      request.setAttribute("auctionItems", auctionItems);

      if(request.getAttribute("identity").equals("user")) {
        System.out.println("user");
        request.getRequestDispatcher("AuctionItemsList.jsp").forward(request, response);
      }else if(request.getAttribute("identity").equals("manager")){
        System.out.println("manager");
        request.getRequestDispatcher("manager/ManagerItems.jsp").forward(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }


}
