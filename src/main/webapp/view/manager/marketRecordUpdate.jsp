<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <li><a href="${pageContext.request.contextPath}/marketRecord/queryList">营销记录管理</a></li>
        <li><a href="#">修改</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/marketRecord/update" method="post" enctype="multipart/form-data">
    <div class="formbody">
        <div class="formtitle"><span>营销记录</span></div>
        <ul class="forminfo">
            <input type="hidden" value="${mr.cKey}" name="cKey"/>
            <li><label>客户姓名</label><input name="cName" type="text" class="dfinput" value="${mr.cName}" required/><i>姓名不能超过8个字符</i>
            </li>
            <li><label>客户生产经营情况</label><textarea name="cManagement" cols="" rows="" class="textinput">${mr.cManagement}</textarea></li>
            <li><label>客户需求</label><textarea name="cDemand" cols="" rows="" class="textinput">${mr.cDemand}</textarea>
            </li>
            <li><label>客户拜访报告书</label><input name="report" type="file" class="dfinputfile"/></li>
            <li><label>客户推荐表</label><input name="recommendTable" type="file" class="dfinputfile" value=""/></li>
            <li><label>客户综合评价</label><input name="evaluation" type="file" class="dfinputfile" value=""/></li>
            <li><label>拜访日期</label><input name="cDate" type="text" class="dfinput"
                                          value="<fmt:formatDate value="${mr.cDate}" pattern="yyyy-MM-dd"/>"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input
                    name="" type="reset" class="btn" value="重置"/></li>
        </ul>
    </div>
</form>
</body>
</html>