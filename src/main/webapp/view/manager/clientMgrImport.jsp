<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
${msg}
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">批量导入</a></li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>导入客户经理数据</span></div>
    <form action="${pageContext.request.contextPath}/cminfo/importCminfo" method="post" enctype="multipart/form-data">
        <ul class="forminfo">
            <li><label>选择文件路径:</label><input name="exclefile" type="file" class="dfinputfile"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="导入"/></li>
        </ul>
    </form>
</div>
</body>
</html>