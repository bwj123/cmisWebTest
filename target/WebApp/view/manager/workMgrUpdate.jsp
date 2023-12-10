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
        <li><a href="${pageContext.request.contextPath}/work/queryWorkList">工作管理</a></li>
        <li><a href="#">修改</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/work/updateWork" method="post">
    <div class="formbody">
        <div class="formtitle"><span>工作记录</span></div>
        <ul class="forminfo">
            <input type="hidden" name="cmKey" value="${wr.cmKey}"/>
            <li><label>客户维护</label><textarea name="cmManagement" cols="" rows="" class="textinput">${wr.cmManagement}</textarea></li>
            <li><label>产品信息</label><textarea name="cmProduct" cols="" rows="" class="textinput">${wr.cmProduct}</textarea></li>
            <li><label>货后管理</label><textarea name="cmLoan" cols="" rows="" class="textinput">${wr.cmLoan}</textarea>
            </li>
            <li><label>风险预警</label><textarea name="cmWarning" cols="" rows="" class="textinput">${wr.cmWarning}</textarea></li>
            <li><label>发现问题</label><textarea name="cmIssue" cols="" rows="" class="textinput">${wr.cmIssue}</textarea>
            </li>
            <li><label>工作建议及感悟</label><textarea name="cmWorkProposal" cols="" rows="" class="textinput">${wr.cmWorkProposal}</textarea></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="重置"/></li>
        </ul>
    </div>
</form>
</body>
</html>