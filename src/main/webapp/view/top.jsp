<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>欢迎登录客户经理信息管理系统</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //顶部导航切换
            $(".nav li a").click(function () {
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>
</head>

<body style="background:url(../images/topbg.gif);">
<div class="topleft">
    <img src="${pageContext.request.contextPath}/images/logo.png" title="系统首页"/>
</div>
<div class="topright">
    <ul>
        <li><span><img src="${pageContext.request.contextPath}/images/i07.png" title="论坛" class="helpimg" height="16"
                       width="16"/></span><a target="_parent">论坛</a></li>
        <li><span><img src="${pageContext.request.contextPath}/images/help.png" title="帮助" class="helpimg"/></span><a
                target="_parent">帮助</a></li>
        <li><span><img src="${pageContext.request.contextPath}/images/i10.png" title="注销" class="helpimg" height="16"
                       width="16"/></span><a href="${pageContext.request.contextPath}/logout" target="_parent">注销</a>
        </li>
    </ul>
    <div class="user">
        <span>欢迎${uname}登录！</span>
    </div>
</div>
</body>
</html>