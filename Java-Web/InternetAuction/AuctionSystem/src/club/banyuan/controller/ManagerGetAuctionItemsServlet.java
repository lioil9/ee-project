package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.IItemService;
import club.banyuan.service.impl.ItemServiceImpl;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManagerGetItemsServlet", urlPatterns = "/managerGetAuctionItems.do")
public class ManagerGetAuctionItemsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    List<AuctionItem> auctionItems = new ArrayList<>();
    System.out.println("auction");
    request.setCharacterEncoding("utf-8");
    try {
      IItemService itemService = new ItemServiceImpl();
      HttpSession session = request.getSession();
      String name = isNull(request, "name", String.class);
      System.out.println(name);
      Double startPrice = isNull(request, "startPrice", Double.class);
      String startTime = isNull(request, "startTime", String.class);
      String endTime = isNull(request, "endTime", String.class);
      String remark = isNull(request, "remark", String.class);

      Integer page = 1;
      if (request.getAttribute("page") != null) {
        page = (Integer) request.getAttribute("page");
      }
      System.out.println(page);
      auctionItems = itemService
          .getAuctionItems(name, remark, startTime, endTime, startPrice, page);
      request.setAttribute("auctionItems", auctionItems);
      auctionItems.forEach(s -> System.out.println(s.getName()));
      System.out.println("manager");
      request.getRequestDispatcher("manager/ManagerItems.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * 判断请求得到的值是否为空，并且对要得到参数指定类型返回，
   * 将getParameter方法得到的字符串值进行指定类型自动转换
   * @param request
   * @param s
   * @param type
   * @param <T>
   * @return
   */
  private static <T> T isNull(HttpServletRequest request, String s, Class<T> type) {
    T result = null;
    if (request.getParameter(s) == null || request.getParameter(s).isBlank()) {
      return result;
    }
    try {
      Constructor<T> constructor = type.getConstructor(String.class);
      constructor.setAccessible(true);
      result = constructor.newInstance(request.getParameter(s));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

}
