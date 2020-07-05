package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.entity.UserAddress;
import club.banyuan.service.IUserAddressService;
import club.banyuan.service.impl.UserAddressServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddAddressServlet", urlPatterns = "/addAddress.do")
public class AddAddressServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("content-type", "text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();

    IUserAddressService userAddressService = new UserAddressServiceImpl();
    UserAddress userAddress = new UserAddress();
    try {
      Enumeration e = request.getParameterNames();
      while (e.hasMoreElements()) {
        String name = (String) e.nextElement();
        if (request.getParameter(name).isBlank()) {
          System.out.println(name);
          throw new Exception();
        }
      }
      userAddress.setUserId(user.getId());
      userAddress.setAddress(request.getParameter("address"));
      userAddress.setCreateTime(df.format(new Date()));
      userAddress.setIsDefault(Integer.valueOf(request.getParameter("isDefault")));
      userAddress.setRemark(request.getParameter("remark"));
      userAddressService.addAddress(userAddress);
      request.getRequestDispatcher("Member_Address.jsp").forward(request,response);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      writer.println("<script>alert('请输入必填的地址信息');location.href='Member_Address.jsp'</script>");
      e.printStackTrace();
    }
  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
