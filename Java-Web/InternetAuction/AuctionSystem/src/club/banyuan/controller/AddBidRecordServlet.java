package club.banyuan.controller;

import club.banyuan.entity.BidRecord;
import club.banyuan.service.IBidRecordService;
import club.banyuan.service.impl.BidRecordServiceImpl;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBidRecordServlet", urlPatterns = "/addBidRecord.do")
public class AddBidRecordServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    BidRecord bidRecord = new BidRecord();
    IBidRecordService bidRecordService = new BidRecordServiceImpl();
    try {
      bidRecord.setItemId(Integer.valueOf(request.getParameter("itemId")));
      bidRecord.setBidTime(df.format(new Date()));
      bidRecord.setBidPrice(Double.valueOf(request.getParameter("bidPrice")));
      bidRecord.setUserId(Integer.valueOf(request.getParameter("userId")));

      if(bidRecordService.addBidRecord(bidRecord)){
        request.getRequestDispatcher("auctionDetail.do").forward(request,response);
      }
    }catch (Exception e){
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
