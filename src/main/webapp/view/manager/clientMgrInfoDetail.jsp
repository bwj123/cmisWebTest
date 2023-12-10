<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 400
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/cminfo/queryCminfoList">客户经理信息综合管理维护</a></li>
        <li><a href="#">查看</a></li>
    </ul>
</div>
<form action="" method="post">
    <div class="formbody">
        <div class="formtitle"><span>客户经理基本信息</span></div>
        <ul class="forminfo">
            <li><label>员工号</label><cite>${cminfo.cmId}</cite></li>
            <li><label>姓名</label><cite>${cminfo.cmName}</cite></li>
            <li><label>性别</label><c:if test="${cminfo.cmSex=='M'}"><cite>男</cite></c:if><c:if
                    test="${cminfo.cmSex=='F'}"><cite>女</cite></c:if></li>
            <li><label>身份证号</label><cite>${cminfo.cmSsn}</cite></li>
            <li><label>出生年月</label><cite><fmt:formatDate value="${cminfo.cmBirthday}" pattern="yyyy-MM-dd"/></cite></li>
            <li><label>年龄</label><cite>${cminfo.cmAge}</cite></li>
            <li><label>民族</label><cite>${cminfo.cmNation}</cite></li>
            <li><label>政治面貌</label><cite>${cminfo.cmPoliticalLandscape}</cite></li>
            <li><label>籍贯</label><cite>${cminfo.cmHometown}</cite></li>
            <li><label>照片</label><cite><c:if test="${cminfo.cmPhoto!=null}"><img
                    src="${pageContext.request.contextPath}/upload/cminfoPic/${cminfo.cmPhoto}" width="50px"
                    height="auto"/></c:if></cite></li>
            <li><label>学历</label><cite>${cminfo.cmEducation}</cite></li>
            <li><label>学位</label><cite>${cminfo.cmDegree}</cite></li>
            <li><label>毕业院校及专业</label><cite>${cminfo.cmGraduated}</cite></li>
            <li><label>专业技术职称</label><cite>${cminfo.cmProfessionalTitles}</cite></li>
            <li><label>客户经理等级</label><cite>${cminfo.cmLevel}</cite></li>
            <li><label>所在单位</label><cite>${cminfo.cmUnit}</cite></li>
            <li><label>部门</label><cite>${cminfo.cmDept}</cite></li>
            <li><label>职务</label><cite>${cminfo.cmPosition}</cite></li>
            <li><label>业务条线</label><cite>${cminfo.cmBusinessLines}</cite></li>
            <li><label>参加工作时间</label><cite><fmt:formatDate value="${cminfo.cmHiredate}" pattern="yyyy-MM-dd"/></cite>
            </li>
            <li><label>入行时间</label><cite><fmt:formatDate value="${cminfo.cmEntryTime}" pattern="yyyy-MM-dd"/></cite>
            </li>
            <li><label>从事金融工作年限</label><cite>${cminfo.cmFinancialYears}</cite></li>
            <li><label>客户经理从业年限</label><cite>${cminfo.cmWorkingYears}</cite></li>
            <li><label>退出时间</label><cite><fmt:formatDate value="${cminfo.cmExitTime}" pattern="yyyy-MM-dd"/></cite></li>
            <li><label>办公电话</label><cite>${cminfo.cmTel}</cite></li>
            <li><label>手机</label><cite>${cminfo.cmMobile}</cite></li>
            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
        </ul>
    </div>
</form>
</body>
</html>