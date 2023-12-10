<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2020/7/3
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });
            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });
            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });
            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });
        });
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/member/queryMemberList">用户管理</a></li>
        <li><a href="#">添加</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/member/addMember" method="post">
    <div class="formbody">
        <div class="formtitle"><span>用户基本信息</span></div>
        <ul class="forminfo">
            <li><label>姓名</label><input name="cname" type="text" class="dfinput" value=""/></li>
            <li><label>密码</label><input name="MemPass" type="password" class="dfinput" value=""/></li>
            <li><label>性别</label><cite><input name="memSex" type="radio" value="" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;<input name="memSex" type="radio" value=""/>女</cite></li>
            <li><label>出生日期</label><input name="memBorn" type="text" class="dfinput" value=""/></li>
            <li><label>角色</label><cite><select name="roleid" class="dfselect">
                <option value="0">请选择</option>
                <option value="1">管理员</option>
                <option value="2">客户经理</option>
            </select></cite></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="重置"/></li>
        </ul>
    </div>
</form>
</body>
</html>