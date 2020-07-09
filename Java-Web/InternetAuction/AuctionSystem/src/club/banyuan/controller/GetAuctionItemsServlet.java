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
    request.setCharacterEncoding("utf-8");
    try {
      IItemService iItemService = new ItemServiceImpl();
      HttpSession session = request.getSession();
      String name = request.getParameter("name");
      System.out.println(name);
      Double startPrice =null;
      if(request.getParameter("startPrice") != null && !request.getParameter("startPrice").isBlank()) {
        startPrice = Double.valueOf(request.getParameter("startPrice"));
      }
//      String startTime = request.getParameter("startTime");
//      String endTime = request.getParameter("endTime");
//      String remark = request.getParameter("remark");
//      Integer page = (Integer) request.getAttribute("page");
      String startTime = isNull(request,"startTime");
      String endTime = isNull(request,"endTime");
      String remark = isNull(request,"remark");

//      Integer page = (Integer) request.getAttribute("page");
//      System.out.println(page);
      auctionItems = iItemService
          .getAuctionItems(name, remark, startTime, endTime, startPrice, 1);
      request.setAttribute("auctionItems", auctionItems);
      auctionItems.forEach(s -> System.out.println(s.getName()));
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

  private static String isNull(HttpServletRequest request, String s){
    if(request.getParameter(s)==null || request.getParameter(s).isBlank()){
      return null;
    }else {
      return request.getParameter(s);
    }
  }


}
