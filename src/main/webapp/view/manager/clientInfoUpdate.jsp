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
        <li><a href="${pageContext.request.contextPath}/cinfo/queryCinfoList">客户信息管理</a></li>
        <li><a href="#">修改</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/cinfo/updateCinfo" method="post">
    <div class="formbody">
        <div class="formtitle"><span>客户基本信息</span></div>
        <ul class="forminfo">
            <input type="hidden" value="${cinfo.cKey}" name="cKey"/>
            <li><label>客户姓名</label><input name="cName" type="text" class="dfinput" value="${cinfo.cName}" required/><i>姓名不能超过8个字符</i>
            </li>
            <li><label>身份证号</label><input name="cSsn" type="text" class="dfinput" value="${cinfo.cSsn}" required/></li>
            <li><label>联系方式</label><input name="cTel" type="text" class="dfinput" value="${cinfo.cTel}" required/></li>
            <li><label>年收入（万元）</label><input name="cSalary" type="text" class="dfinput" value="${cinfo.cSalary}"
                                             required/></li>
            <li><label>资产（万元）</label><input name="cBalance" type="text" class="dfinput" value="${cinfo.cBalance}"/></li>
            <li><label>负债（万元）</label><input name="cDebt" type="text" class="dfinput" value="${cinfo.cDebt}"/></li>
            <li><label>所在单位</label><input name="cUnit" type="text" class="dfinput" value="${cinfo.cUnit}"/></li>
            <li><label>家庭住址</label><input name="cAdd" type="text" class="dfinput" value="${cinfo.cAdd}"/></li>
            <li><label>业务关联</label><input name="cBusiness" type="text" class="dfinput" value="${cinfo.cBusiness}"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input
                    name="" type="reset" class="btn" value="重置"/></li>
        </ul>
    </div>
</form>
</body>
</html>