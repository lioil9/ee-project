<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request
                .getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>竞拍系统</title>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <%--搜索框begin--%>
    <form action="managerGetAuctionItems.do" method="post">
        <div class="forms">
            <label for="name">名称</label>
            <input name="name" type="text" class="nwinput" id="name"/>
            <label for="names">描述</label>
            <input name="remark" type="text" id="names" class="nwinput"/>
            <label for="time">开始时间</label>
            <input name="startTime" type="text" id="time" class="nwinput"/>
            <label for="end-time">结束时间</label>
            <input name="endTime" type="text" id="end-time" class="nwinput"/>
            <label for="price">起拍价</label>
            <input name="startPrice" type="text" id="price" class="nwinput"/>
            <input name="" type="submit" value="查询" class="spbg buttombg f14  sale-buttom"/>
            <input id="addBtn" type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb"/>
        </div>
    </form>
    <%--搜索框end--%>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>
        <c:if test="${requestScope.auctionItems.size() == 0}">
            <ul class="rows">
                <li>没有查询到竞拍品</li>
            </ul>
        </c:if>
        <c:if test="${requestScope.auctionItems.size()>0}">
        <c:forEach var="auctionItem" items="${requestScope.auctionItems}" varStatus="status">
            <c:if test="${status.index%2 == 0}">
             <ul class="rows">
            </c:if>
            <c:if test="${status.index%2 == 1}">
            <ul class="rows even">
            </c:if>
                <li><a href="国书" title="">${auctionItem.name}</a></li>
                <li class="list-wd">${auctionItem.remark}</li>
                <li>${auctionItem.startTime}</li>
                <li>${auctionItem.endTime}</li>
                <li>${auctionItem.startPrice}</li>
                <li class="borderno red">
                    <a href="detail.do?itemId=${auctionItem.id}" title="竞拍" onclick="dele();">修改</a>|
                    <a href="delete.do?itemId=${auctionItem.id}" title="竞拍" onclick="abc();">删除</a>
                </li>
            </ul>
            </c:forEach>
            </c:if>
            <div class="page">
                <a href="#" title="">首页</a>
                <a href="#" title="">上一页</a>
                <span class="red">前5页</span>
                <a href="#" title="">1</a>
                <a href="#" title="">2</a>
                <a href="#" title="">3</a>
                <a href="#" title="">4</a>
                <a href="#" title="">5</a>
                <a href="#" title="">下一页</a>
                <a href="#" title="">尾页</a>
            </div>
    </div>
    <script>
        $(function () {
          $("#addBtn").click(function () {
            window.location.href = "manager/AddItems.jsp";
          })
        })
      function abc() {

        if (confirm("你真的确认要删除吗？请确认")) {

          return true;
        } else {
          return false;
        }

      };

      function dele() {
        if (confirm("你真的确认要修改吗？请确认")) {
          return true;
        } else {
          return false;
        }
      }
    </script>
    <!-- main end-->
</div>
</body>
</html>
