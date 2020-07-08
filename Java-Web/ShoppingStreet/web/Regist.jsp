<%@ page import="club.banyuan.entity.User" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/select.js"></script>

    <script type="text/javascript" src="js/lrscroll.js"></script>

    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>


    <title>购物街</title>
    <script type="text/javascript">
      $(function () {
        $("#loginName").blur(function () {
          var loginName = $("#loginName").val();
          if (loginName !== "") {
            $.get("loginName.do", "loginName=" + loginName, callBack);

            function callBack(data) {
              if (data === "false") {
                $("#loginNameNotice").html("用户名已被注册");
              }else {
                $("#loginNameNotice").html("");
              }
            }
          } else {
            $("#loginNameNotice").html("用户名不能为空");
          }
        })
      });

      $(function () {
        var flag = true;
        $("#userName").blur(function () {
          var userName = $("#userName").val();
          if (userName === "") {
            $("#userNameNotice").html("昵称不能为空");
            flag = false;
          }else {
            $("#userNameNotice").html("");
          }
        })
        $("#password").blur(function () {
          var password = $("#password").val();
          if(password === ""){
            $("#passwordNotice").html("密码不能为空");
            flag = false;
          }else {
            $("#passwordNotice").html("");
          }
        })
        $("#email").blur(function () {
          var email = $("#email").val();
          if(email === ""){
            $("#emailNotice").html("邮箱不能为空");
            flag = false;
          }else {
            $("#emailNotice").html("");
          }
        })
        $("#mobile").blur(function () {
          var mobile = $("#mobile").val();
          if(mobile === ""){
            $("#mobileNotice").html("手机号不能为空");
            flag = false;
          }else {
            $("#mobileNotice").html("");
          }
        })
        $("#submitBtn").click(function () {
          if(flag){
            $("#submitBtn").submit();
          }else {
            alert("请输入完整注册信息！")
          }
        })


      })

    </script>

</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <span class="fr">
        	<span class="fl">
                <%
                    Object userObj = session.getAttribute("user");
                    if (userObj != null) {
                        User user = (User) userObj;
                %>
               <div class="ss_list">
                    <a href="<%=request.getContextPath()%>/user/Member.jsp"><%=user
                            .getLoginName()%></a>
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
                <%
                    } else {
                        out.print(
                                "你好，请<a href=\"Login.jsp\">登录</a>&nbsp; <a href=\"Regist.jsp\" style=\"color:#ff4e00;\">免费注册</a>");
                    }
                %>
                &nbsp;|</span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png"
                                                              align="absmiddle"/></a></span>
        </span>
    </div>
</div>
<!--End Header End-->
<!--Begin Login Begin-->
<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="index.jsp"><img src="images/logo.png"/></a></div>
    </div>
    <div class="regist">
        <div class="log_img"><img src="images/l_img.png" width="611" height="425"/></div>
        <div class="reg_c">
            <form action="register.do" method="post" id="registerForm">
                <table border="0" style="width:420px; font-size:14px; margin-top:20px;"
                       cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="95">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">注册</span>
                            <span class="fr">已有商城账号，<a href="Login.jsp"
                                                       style="color:#ff4e00;">我要登录</a></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                        <td><input id="loginName" type="text" name="loginName" value=""
                                   class="l_user notNull"/></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td><div><span id="loginNameNotice" style='color:red'></span></div></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;用户昵称 &nbsp;</td>
                        <td><input type="text" id="userName" name="userName" value="" class="l_user notNull"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td><div><span id="userNameNotice" style='color:red'></span></div></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                        <td><input type="password" id="password" name="password" value="" class="l_pwd notNull"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td><div><span id="passwordNotice" style='color:red'></span></div></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                        <td><input type="password" name="confirmPassword" value=""
                                   class="l_pwd notNull"/></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td><div><span id="confirmPasswordNotice" style='color:red'></span></div></td>
                    </tr>
                    <tr height="50">
                        <td align="right">性别 &nbsp;</td>
                        <td><input type="text" name="sex" value="2" class="l_mem"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                        <td><input type="text" id="email" name="email" value="" class="l_email notNull"/></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td><div><span id="emailNotice" style='color:red'></span></div></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                        <td><input type="text" id="mobile" name="mobile" value="" class="l_tel notNull"/></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td><div><span id="mobileNotice" style='color:red'></span></div></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" id="isAgree" name="isAgree"
                                                    value="true"/></label><label class="r_txt">我已阅读并接受《用户协议》</label>
                    </span>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="button" id="submitBtn" value="立即注册" class="log_btn"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：京ICP备070360号 Copyright © 2016-2019 购物街 All Rights Reserved. 复制必究 , Technical
        Support: ICT Group <br/>
        <img src="images/b_1.gif" width="98" height="33"/><img src="images/b_2.gif" width="98"
                                                               height="33"/><img
            src="images/b_3.gif" width="98" height="33"/><img src="images/b_4.gif" width="98"
                                                              height="33"/><img src="images/b_5.gif"
                                                                                width="98"
                                                                                height="33"/><img
            src="images/b_6.gif" width="98" height="33"/>
    </div>
</div>
<!--End Footer End -->

</body>
<script></script>

<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
