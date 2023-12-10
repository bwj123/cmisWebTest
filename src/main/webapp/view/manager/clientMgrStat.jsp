<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/select-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/editor/kindeditor.js"></script>
    <script type="text/javascript">
        function exportMsg() {
            if (confirm("您确定要导出excel文件吗?"))
                window.location.href = "${pageContext.request.contextPath}/cminfo/exportMgrStat?cmUnit=${cmUnit}&cmStatus=${cmStatus}&cmSex=${cmSex}&cmEdu=${cmEdu}&cmLevel=${cmLevel}&cmPL=${cmPL}";
        }
    </script>
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
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 100
            });
            $(".select2").uedSelect({
                width: 200
            });
            $(".select3").uedSelect({
                width: 150
            });
        });
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">报表管理</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/cminfo/queryCminfoStatList" method="post">
    <div class="formbody">
        <ul class="seachform">
            <li><label>机构</label><input name="cmUnit" type="text" class="scinput" value="${cmUnit}"/></li>
            <li><label>状态</label>
                <div class="vocation">
                    <select class="select1" name="cmStatus">
                        <option value="">请选择</option>
                        <option value="T" ${cmStatus=='T'?'selected':''}>在职</option>
                        <option value="F" ${cmStatus=='F'?'selected':''}>退出</option>
                    </select>
                </div>
            </li>
            <li><label>性别</label>
                <div class="vocation">
                    <select class="select1" name="cmSex">
                        <option value="">请选择</option>
                        <option value="M" ${cmSex=='M'?'selected':''}>男</option>
                        <option value="F" ${cmSex=='F'?'selected':''}>女</option>
                    </select>
                </div>
            </li>
            <li><label>学历</label>
                <div class="vocation"><select name="cmEdu" class="select1">
                    <option value="" ${cmEdu==''?'selected':''}>请选择</option>
                    <option value="小学" ${cmEdu=='小学'?'selected':''}>小学</option>
                    <option value="初中" ${cmEdu=='初中'?'selected':''}>初中</option>
                    <option value="高中" ${cmEdu=='高中'?'selected':''}>高中</option>
                    <option value="中专" ${cmEdu=='中专'?'selected':''}>中专</option>
                    <option value="高职" ${cmEdu=='高职'?'selected':''}>高职</option>
                    <option value="专科">专科</option>
                    <option value="本科" ${cmEdu=='本科'?'selected':''}>本科</option>
                    <option value="硕士研究生" ${cmEdu=='硕士研究生'?'selected':''} >硕士研究生</option>
                    <option value="博士研究生" ${cmEdu=='博士研究生'?'selected':''}>博士研究生</option>
                </select></div>
            </li>
            <li><label>专业技术职称</label>
                <div class="vocation">
                    <select class="select2" name="cmPL">
                        <option value="" ${cmPL==''?'selected':''}>请选择</option>
                        <option value="工程专业技术人员 高级工程师" ${cmPL=='工程专业技术人员 高级工程师'?'selected':''}>工程专业技术人员 高级工程师</option>
                        <option value="工程专业技术人员 工程师" ${cmPL=='工程专业技术人员 工程师'?'selected':''}>工程专业技术人员 工程师</option>
                        <option value="工程专业技术人员 助理工程师" ${cmPL=='工程专业技术人员 助理工程师'?'selected':''}>工程专业技术人员 助理工程师</option>
                        <option value="经济专业技术人员 高级经济师" ${cmPL=='经济专业技术人员 高级经济师'?'selected':''}>经济专业技术人员 高级经济师</option>
                        <option value="经济专业技术人员 经济师" ${cmPL=='经济专业技术人员 经济师'?'selected':''}>经济专业技术人员 经济师</option>
                        <option value="经济专业技术人员 助理经济师" ${cmPL=='经济专业技术人员 助理经济师'?'selected':''}>经济专业技术人员 助理经济师</option>
                        <option value="会计专业技术人员 高级会计师" ${cmPL=='会计专业技术人员 高级会计师'?'selected':''}>会计专业技术人员 高级会计师</option>
                        <option value="会计专业技术人员 会计师" ${cmPL=='会计专业技术人员 会计师'?'selected':''}>会计专业技术人员 会计师</option>
                        <option value="会计专业技术人员 助理会计师" ${cmPL=='会计专业技术人员 助理会计师'?'selected':''}>会计专业技术人员 助理会计师</option>
                        <option value="统计专业技术人员 高级统计师" ${cmPL=='统计专业技术人员 高级统计师'?'selected':''}>统计专业技术人员 高级统计师</option>
                        <option value="统计专业技术人员 统计师" ${cmPL=='统计专业技术人员 统计师'?'selected':''}>统计专业技术人员 统计师</option>
                        <option value="统计专业技术人员 助理统计师" ${cmPL=='统计专业技术人员 助理统计师'?'selected':''}>统计专业技术人员 助理统计师</option>
                        <option value="审计专业技术人员 高级审计师" ${cmPL=='审计专业技术人员 高级审计师'?'selected':''}>审计专业技术人员 高级审计师</option>
                        <option value="审计专业技术人员 审计师" ${cmPL=='审计专业技术人员 审计师'?'selected':''}>审计专业技术人员 审计师</option>
                        <option value="审计专业技术人员 助理审计师" ${cmPL=='审计专业技术人员 助理审计师'?'selected':''}>审计专业技术人员 助理审计师</option>
                        <option value="政工专业技术人员 助理政工师" ${cmPL=='政工专业技术人员 助理政工师'?'selected':''}>政工专业技术人员 助理政工师</option>
                        <option value="政工专业技术人员 高级政工师" ${cmPL=='政工专业技术人员 高级政工师'?'selected':''}>政工专业技术人员 高级政工师</option>
                        <option value="政工专业技术人员 政工师" ${cmPL=='政工专业技术人员 政工师'?'selected':''}>政工专业技术人员 政工师</option>
                    </select></div>
            </li>
            <li><label>客户经理等级</label>
                <div class="vocation"><select name="cmLevel" class="select3">
                    <option value="">请选择</option>
                    <option value="高级专家级客户经理" ${cmLevel=='高级专家级客户经理'?'selected':''}>高级专家级客户经理</option>
                    <option value="专家级客户经理" ${cmLevel=='专家级客户经理'?'selected':''} >专家级客户经理</option>
                    <option value="资深客户经理" ${cmLevel=='资深客户经理'?'selected':''}>资深客户经理</option>
                    <option value="高级客户经理" ${cmLevel=='高级客户经理'?'selected':''}>高级客户经理</option>
                    <option value="客户经理" ${cmLevel=='客户经理'?'selected':''}>客户经理</option>
                    <option value="客户经理助理" ${cmLevel=='客户经理助理'?'selected':''}>客户经理助理</option>
                </select></div>
            </li>
            <li><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/>
                &nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="button" class="scbtn" value="导出excel" onClick="exportMsg()"/></li>
        </ul>
    </div>
</form>
<div class="rightinfo">
    <div class="tools">
        <ul>
            <li></li>
        </ul>
    </div>
    <table class="tablelist">
        <thead>
        <tr class="tablehead">
            <td colspan="14">客户经理信息列表</td>
        </tr>
        </thead>
        <thead>
        <tr>
            <th>员工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>客户经理等级</th>
            <th>机构</th>
            <th>部门</th>
            <th>业务条线</th>
            <th>职务</th>
            <th>客户经理从业年限</th>
            <th>联系电话</th>
            <th>在职</th>
            <th>年龄</th>
            <th>学历</th>
            <th>专业职称</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="cm">
            <tr>
                <td>${cm.cmId}</td>
                <td>${cm.cmName}</td>
                <c:if test="${cm.cmSex=='M'}">
                    <td>男</td>
                </c:if>
                <c:if test="${cm.cmSex=='F'}">
                    <td>女</td>
                </c:if>
                <td>${cm.cmLevel}</td>
                <td>${cm.cmUnit}</td>
                <td>${cm.cmDept}</td>
                <td>${cm.cmBusinessLines}</td>
                <td>${cm.cmPosition}</td>
                <td>${cm.cmWorkingYears}</td>
                <td>${cm.cmMobile}</td>
                <c:if test="${cm.cmStatus=='T'}">
                    <td>在职</td>
                </c:if>
                <c:if test="${cm.cmStatus=='F'}">
                    <td>退出</td>
                </c:if>
                <td>${cm.cmAge}</td>
                <td>${cm.cmEducation}</td>
                <td>${cm.cmProfessionalTitles}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>