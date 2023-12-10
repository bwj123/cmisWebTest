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
        <li><a href="${pageContext.request.contextPath}/learn/queryLearnList">学习园地管理</a></li>
        <li><a href="#">添加</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/learn/insertLearn" method="post" enctype="multipart/form-data">
    <div class="formbody">
        <div class="formtitle"><span>学习园地资料管理</span></div>
        <ul class="forminfo">
            <li><label>资料名称</label><input name="lName" type="text" class="dfinput" required/></li>
            <li><label>完全公开</label><cite><input name="ispublic" type="radio" value="" checked="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name="ispublic" type="radio" value=""/>否</cite></li>
            <li><label>资料类型</label><cite><select class="dfselect1" name="lType">
                <option value="">请选择</option>
                <option value="规章制度">规章制度</option>
                <option value="学习培训材料">学习培训材料</option>
                <option value="资格岗位考试教程">资格岗位考试教程</option>
                <option value="客户营销技巧">客户营销技巧</option>
            </select></cite></li>
            <li><label>资料描述</label><textarea name="lDes" cols="" rows="" class="textinput" required></textarea></li>
            <li><label>附件上传</label><input name="file" type="file" class="dfinputfile"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="重置"/></li>
        </ul>
    </div>
</form>
</body>
</html>