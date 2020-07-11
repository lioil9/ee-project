<%@ page import="club.banyuan.entity.AuctionItem" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
  <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>竞拍系统</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>

  <script type="text/javascript">
    $(function () {
      $("#cancelBtn").click(function () {
        window.location.href = "managerGetAuctionItems.do";
      })
    })
  </script>
</head>

<body>
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <form action="changeItem.do" method="post">
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
          <dl>
            <dd >
              <label>名称：</label>
              <input name="itemId" style="display: none" value="${requestScope.auctionItem.id}"/>
              <input type="text" name="name" class="inputh lf" value="${requestScope.auctionItem.name}" />
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" name="startPrice" class="inputh lf" value="${requestScope.auctionItem.startPrice}" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input type="text" name="basePrice" class="inputh lf" value="${requestScope.auctionItem.basePrice}" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" name="startTime" class="inputh lf" value="${requestScope.auctionItem.startTime}" />
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" name="endTime" class="inputh lf" value="${requestScope.auctionItem.endTime}" />
              <div class="lf red laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd class="dds">
              <label>描述：</label>
              <textarea name="remark" cols="" rows="" class="textarea">${requestScope.auctionItem.remark}</textarea>
            </dd>
            <dd>
              <label>修改图片：</label>
              <div class="lf salebd"><a href="#"><img src="images/ad20.jpg" width="100" height="100" /></a></div>
               <input name="" type="file" class="marg10" />
            </dd>
            <dd class="hegas">
                <input name="" type="submit" value="保 存" class="spbg buttombg buttombgs f14 lf buttomb" />
                <input id="cancelBtn" name="" type="button" value="取 消" class="spbg buttombg buttombgs f14 lf buttomb" />
            </dd>
          </dl>

    </div>
  </form>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</body>
</html>
