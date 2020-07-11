package club.banyuan.controller;


import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import club.banyuan.util.FilterDataUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserGetItemsServlet", urlPatterns = "/userGetAuctionItems.do")
public class UserGetAuctionItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    List<AuctionItem> auctionItems = new ArrayList<>();
    System.out.println("auction");
    request.setCharacterEncoding("utf-8");
    try {
      IItemService iItemService = new ItemServiceImpl();
      HttpSession session = request.getSession();

      String name = FilterDataUtil.isNull(request, "name",String.class);
      System.out.println(name);
      Double startPrice = FilterDataUtil.isNull(request, "startPrice", Double.class);
      String startTime = FilterDataUtil.isNull(request, "startTime",String.class);
      String endTime = FilterDataUtil.isNull(request, "endTime",String.class);
      String remark = FilterDataUtil.isNull(request, "remark",String.class);

      Integer page = 1;
      if (request.getAttribute("page") != null) {
        page = (Integer) request.getAttribute("page");
      }
      System.out.println(page);
      auctionItems = iItemService
          .getAuctionItems(name, remark, startTime, endTime, startPrice, page);
      request.setAttribute("auctionItems", auctionItems);
      auctionItems.forEach(s -> System.out.println(s.getName()));
      System.out.println("user");
      request.getRequestDispatcher("AuctionItemsList.jsp").forward(request, response);
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
