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
        <li><a href="${pageContext.request.contextPath}/regularMeeting/queryRegularList">例会记录管理</a></li>
        <li><a href="#">添加</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/regularMeeting/insertRegular" method="post"
      enctype="multipart/form-data">
    <div class="formbody">
        <div class="formtitle"><span>例会记录</span></div>
        <ul class="forminfo">
            <li><label>主题</label><input name="cmRegularTheme" type="text" class="dfinput" value=""/></li>
            <li><label>日期</label><input name="cmRegularDate" type="text" class="dfinput" value=""/></li>
            <li><label>与会人员</label><textarea name="cmRegularPersonnel" cols="" rows="" class="textinput"></textarea>
            </li>
            <li><label>附件</label><input name="refile" type="file" class="dfinputfile"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input
                    name="" type="reset" class="btn" value="重置"/></li>
        </ul>
    </div>
</form>
</body>
</html>