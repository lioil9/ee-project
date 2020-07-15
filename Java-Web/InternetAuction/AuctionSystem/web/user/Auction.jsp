<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>竞拍系统</title>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>

    <script type="text/javascript">
      $(function () {
        $("#returnBtn").click(function () {
          window.location.href = "userGetAuctionItems.do";
        })
        $("#flashBtn").click(function () {
          window.location.href = "auctionDetail.do?itemId=${requestScope.auctionItem.id}";
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
        <div class="login right">当前用户：<span class="blue strong"><a
                href="#">${sessionScope.user.userName}</a>&nbsp;&nbsp;</span></div>
    </div>
    <div class="items sg-font lf">
        <ul class="rows">
            <li>名称：</li>
            <li class="borderno">${requestScope.auctionItem.name}</li>
        </ul>
        <ul class="rows">
            <li>描述：</li>
            <li class="borderno">${requestScope.auctionItem.remark}</li>
        </ul>
        <ul class="rows">
            <li>开始时间：</li>
            <li class="borderno">${requestScope.auctionItem.startTime}</li>
        </ul>
        <ul class="rows">
            <li>结束时间：</li>
            <li class="borderno">${requestScope.auctionItem.endTime}</li>
        </ul>
        <ul class="rows border-no">
            <li>起拍价：</li>
            <li class="borderno">${requestScope.auctionItem.startPrice}</li>
        </ul>
    </div>
    <div class="rg borders"><img src="images/ad20.jpg" width="270" height="185" alt=""/></div>
    <div class="cl"></div>
    <div class="top10 salebd">
        <form action="addBidRecord.do" method="post">
        <p>
            <label for="sale">出价：</label>
            <input name="itemId" style="display: none" value="${requestScope.auctionItem.id}"/>
            <input name="userId" style="display: none" value="${sessionScope.user.id}"/>
            <c:if test="${requestScope.maxPrice == 0}">
            <input name="bidPrice" type="text" class="inputwd" id="sale" value="${requestScope.auctionItem.startPrice}"/>
            </c:if>
            <c:if test="${requestScope.maxPrice > 0}">
            <input name="bidPrice" type="text" class="inputwd" id="sale" value="${requestScope.maxPrice}"/>
            </c:if>
            <input name="" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom"/>
        </p>
        </form>
        <p class="f14 red">不能低于最高竞拍价</p>
    </div>
    <div class="top10">
        <input id="flashBtn" name="" type="button" value="刷 新" class="spbg buttombg f14"/>
        <input id="returnBtn" name="" type="button" value="返回列表" class="spbg buttombg f14"/>
    </div>
    <div class="offer">
        <h3>出价记录</h3>
        <div class="items sg-font">
            <ul class="rows even strong">
                <li>竞拍时间</li>
                <li>竞拍价格</li>
                <li class="borderno">竞拍人</li>
            </ul>
            <c:if test="${requestScope.bidRecordList.size() == 0}">
                <ul class="rows">
                    <li>暂未有出价记录</li>
                </ul>
            </c:if>
            <c:if test="${requestScope.bidRecordList.size() > 0}">
            <c:forEach var="bidRecord" items="${requestScope.bidRecordList}" varStatus="status">
            <c:if test="${status.index%2 == 0}">
                <ul class="rows">
            </c:if>
            <c:if test="${status.index%2 == 1}">
                <ul class="rows even">
            </c:if>
                    <li>${bidRecord.bidTime}</li>
                    <li>${bidRecord.bidPrice}</li>
                    <li class="borderno">${bidRecord.userName}</li>
                </ul>
            </c:forEach>

            </c:if>
        </div>
    </div>
    <!-- main end-->
</div>
</body>
</html>
