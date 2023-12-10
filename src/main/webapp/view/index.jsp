<%@ page isELIgnored="false" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>欢迎登录客户经理信息管理系统</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
    </ul>
</div>
<div class="mainindex">
    <div class="welinfo">
        <span><img src="${pageContext.request.contextPath}/images/sun.png" alt="天气"/></span>
        <b>${uname}早上好，欢迎访问客户经理信息管理系统</b>
    </div>
</div>
</body>
</html>