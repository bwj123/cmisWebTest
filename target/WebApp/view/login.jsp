<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String msg = (String) request.getSession().getAttribute("msg");
    if(msg==null){
        msg="";
    }
    request.getSession().removeAttribute("msg");
%>
<html>
<head>

    <title>欢迎光临客户经理管理系统</title>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <title>欢迎登录客户经理信息管理系统</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>
    <script type="text/javascript">
        function login() {
            var loginName = document.forms[0].elements["loginName"];
            var loginPass = document.forms[0].elements["loginPass"];
            if (loginName.value == "" || loginPass.value == "") {
                alert("用户名或密码错误!");
                return false;
            }
        }
    </script>
</head>

<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>
<form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/login" method="post">
    <div class="loginbody">
        <span></span>
        <div class="loginbox">
            <ul>
                <li><input name="loginName" type="text" class="loginuser"  onclick="JavaScript:this.value=''"/></li>
                <li><input name="loginPass" type="password" class="loginpwd"  onclick="JavaScript:this.value=''"/></li>
                <b ><font color="red">${msg}</font></b>
                <li><input name="" type="submit" class="loginbtn" value="登录" onclick="return login()"/><label><input name="" type="checkbox" value="" checked="checked"/>记住密码</label></li>

            </ul>
        </div>
    </div>
</form>
</body>
</html>
