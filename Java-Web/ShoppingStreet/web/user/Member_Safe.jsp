<%@ page import="club.banyuan.entity.User" %>
<%@ page import="club.banyuan.entity.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map.Entry" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="../css/style.css"/>
    <!--[if IE 6]>
    <script src="../js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->

    <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/menu.js"></script>

    <script type="text/javascript" src="../js/select.js"></script>

    <title>购物街</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>"/>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <!--Begin 所在收货地区 Begin-->
        <span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;"
                               cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span
                                    class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	<span class="fl">
               <div class="ss_list">
                    <a href="<%=request.getContextPath()%>/user/Member.jsp">${sessionScope.user.loginName}</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="<%=request.getContextPath()%>/logout.do">退出登录</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                &nbsp;|&nbsp;<a href="#">我的订单</a>
            </span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png"
                                                              align="absmiddle"/></a></span>
        </span>
    </div>
</div>
<div class="m_top_bg">
    <div class="top">
        <div class="m_logo"><a href="<%=request.getContextPath()%>/index.jsp"><img
                src="images/logo1.png"/></a></div>
        <div class="m_search">
            <form>
                <input type="text" value="" class="m_ipt"/>
                <input type="submit" value="搜索" class="m_btn"/>
            </form>
            <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a
                    href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
        </div>
        <div class="i_car">
            <%
                Double sum = 0.0;
                Map<Product, Integer> cart = new HashMap<>();
                if (session.getAttribute("cart") != null) {
                    cart = (Map<Product, Integer>) session.getAttribute("cart");
                }
            %>
            <div class="car_t">购物车 [ <span><%=cart.size()%></span> ]</div>
            <div class="car_bg">
                <div>
                    <!--Begin 购物车已登录 Begin-->
                    <ul class="cars">
                        <c:if test="${sessionScope.cart.size() == 0}">
                            <div class="un_login">购物车里还没有商品，赶快去添加吧！</div>
                        </c:if>
                        <c:if test="${sessionScope.cart.size() > 0}">
                            <%
                                for (Entry<Product, Integer> p : cart.entrySet()) {
                                    sum += p.getKey().getPrice() * p.getValue();
                            %>
                            <li>
                                <div class="img"><a href="#"><img src="images/car1.jpg" width="58"
                                                                  height="58"/></a></div>
                                <div class="name"><a href="#"><%=p.getKey().getName()%>>
                                </a></div>
                                <div class="price"><font color="#ff4e00">￥
                                    <%=String.format("%.0f", p.getKey().getPrice())%>
                                </font> X<%=p.getValue()%>
                                </div>
                            </li>
                            <%
                                }
                            %>
                        </c:if>
                    </ul>
                    <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span><%=String
                            .format("%.0f", sum)%></span></div>
                    <div class="price_a"><a href="<%=request.getContextPath()%>/user/BuyCar.jsp">去购物车结算</a>
                    </div>
                    <!--End 购物车已登录 End-->
                </div>
            </div>
        </div>
    </div>
</div>
<!--End Header End-->
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
    <div class="m_content">
        <div class="m_left">
            <div class="left_n">管理中心</div>
            <div class="left_m">
                <div class="left_m_t t_bg1">订单中心</div>
                <ul>
                    <li><a href="getOrder.do">我的订单</a></li>
                    <li><a href="<%=request.getContextPath()%>/user/Member_Address.jsp">收货地址</a>
                    </li>
                    <li><a href="#">缺货登记</a></li>
                    <li><a href="#">跟踪订单</a></li>
                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg2">会员中心</div>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/user/Member_User.jsp">用户信息</a></li>
                    <li><a href="Member_Collect.html">我的收藏</a></li>
                    <li><a href="Member_Msg.html">我的留言</a></li>
                    <li><a href="Member_Links.html">推广链接</a></li>
                    <li><a href="#">我的评论</a></li>
                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg3">账户中心</div>
                <ul>
                    <li><a href="<%=request.getContextPath()%>/user/Member_Safe.jsp" class="now">账户安全</a>
                    </li>
                    <li><a href="Member_Packet.html">我的红包</a></li>
                    <li><a href="Member_Money.html">资金管理</a></li>
                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg4">分销中心</div>
                <ul>
                    <li><a href="Member_Member.html">我的会员</a></li>
                    <li><a href="Member_Results.html">我的业绩</a></li>
                    <li><a href="Member_Commission.html">我的佣金</a></li>
                    <li><a href="Member_Cash.html">申请提现</a></li>
                </ul>
            </div>
        </div>
        <div class="m_right">
            <p></p>
            <div class="mem_tit">账户安全</div>
            <div class="m_des">
                <form action="change.do" method="post">
                    <table border="0" style="width:880px;" cellspacing="0" cellpadding="0">
                        <tr height="45">
                            <td width="80" align="right">原手机 &nbsp; &nbsp;</td>
                            <td><input type="text" name="originalValue" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="45">
                            <td align="right">新手机 &nbsp; &nbsp;</td>
                            <td><input type="text" name="changeValue" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="50">
                            <td>&nbsp;</td>
                            <td><input type="submit" value="确认修改" class="btn_tj"/></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div class="m_des">
                <form action="change.do" method="post">
                    <table border="0" style="width:880px;" cellspacing="0" cellpadding="0">
                        <tr height="45">
                            <td width="80" align="right">原邮箱 &nbsp; &nbsp;</td>
                            <td><input type="text" name="originalValue" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="45">
                            <td align="right">新邮箱 &nbsp; &nbsp;</td>
                            <td><input type="text" name="changeValue" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="50">
                            <td>&nbsp;</td>
                            <td><input type="submit" value="确认修改" class="btn_tj"/></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div class="m_des">
                <form action="change.do" method="post">
                    <table border="0" style="width:880px;" cellspacing="0" cellpadding="0">
                        <tr height="45">
                            <td width="80" align="right">原密码 &nbsp; &nbsp;</td>
                            <td><input type="password" name="originalValue" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="45">
                            <td align="right">新密码 &nbsp; &nbsp;</td>
                            <td><input type="password" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="45">
                            <td align="right">确认密码 &nbsp; &nbsp;</td>
                            <td><input type="password" name="changeValue" value="" class="add_ipt"
                                       style="width:180px;"/>&nbsp; <font color="#ff4e00">*</font>
                            </td>
                        </tr>
                        <tr height="50">
                            <td>&nbsp;</td>
                            <td><input type="button" value="确认修改" class="btn_tj"/></td>
                        </tr>
                    </table>
                </form>
            </div>


        </div>
    </div>
    <!--End 用户中心 End-->
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0"
                   style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b1.png" width="62" height="62"/></td>
                    <td><h2>正品保障</h2>正品行货 放心购买</td>
                </tr>
            </table>
            <table border="0"
                   style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b2.png" width="62" height="62"/></td>
                    <td><h2>满38包邮</h2>满38包邮 免运费</td>
                </tr>
            </table>
            <table border="0"
                   style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b3.png" width="62" height="62"/></td>
                    <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                </tr>
            </table>
            <table border="0"
                   style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;"
                   cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="images/b4.png" width="62" height="62"/></td>
                    <td><h2>准时送达</h2>收货时间由你做主</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
        <dl>
            <dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
            <dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
            <dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
            <a href="#" class="b_sh1">新浪微博</a>
            <a href="#" class="b_sh2">腾讯微博</a>
            <p>
                服务热线：<br/>
                <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118"/></div>
            <img src="images/ss.png"/>
        </div>
    </div>
    <div class="btmbg">
        <div class="btm">
            备案/许可证编号：京ICP备070360号 Copyright © 2016-2019 购物街 All Rights Reserved. 复制必究 , Technical
            Support: ICT Group <br/>
            <img src="images/b_1.gif" width="98" height="33"/><img src="images/b_2.gif" width="98"
                                                                   height="33"/><img
                src="images/b_3.gif" width="98" height="33"/><img src="images/b_4.gif" width="98"
                                                                  height="33"/><img
                src="images/b_5.gif" width="98" height="33"/><img src="images/b_6.gif" width="98"
                                                                  height="33"/>
        </div>
    </div>
    <!--End Footer End -->
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
