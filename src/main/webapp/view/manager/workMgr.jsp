<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        function confirmMsgDel() {
            if (confirm("删除工作记录,您确定要删除吗?"))
                window.close();
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
    <script>
        // 验证输入的是否为数字
        function validate() {
            var t = document.getElementById('cminfoId').value;
            if (!isNumber(t) && t != "") {
                alert('工作管理编号不是有效数字!');
                return false;
            } else {
                return true;
            }
        }

        function isNumber(value) {
            var patrn = /^(-)?\d+(\.\d+)?$/;
            if (patrn.exec(value) == null || value == "") {
                return false
            } else {
                return true
            }
        }
    </script>
    <%--复选框--%>
    <script>
        $(function () {
            $("#checkAll").click(function () {
                $("tbody input").prop("checked", this.checked);
            });
        });

        function checkk() {
            var allcheckbox = "";
            var becheckbox = "";
            $("input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                if ($(this).attr("checked")) //如果被选中
                    becheckbox += $(this).val() + ","; //获取被选中的值
            });
            if (becheckbox.length > 0) //如果获取到
                becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉
            window.location = "${pageContext.request.contextPath}/work/deleteMany?checkTnum=" + becheckbox;
        }
    </script>
    <script>
        function goPage() {
            var page = document.getElementById("textfield").value;
            var workKey = document.getElementById("workKey").value;
            var inDate = document.getElementById("inDate").value;
            if (!isNumber(page)) {
                alert("请输入合法数字！");
                return false;
            }
            if (page == '') {
                alert("请输入页码");
                return false;
            }
            if (page > eval(${info.pages})) {
                alert("输入页码不能大于总页数");
                return false;
            }
            if (page < 1) {
                alert("输入页码不能小于1");
                return false;
            }
            var str = "/work/queryWorkList?pageNum=" + page + "&workKey=" + workKey + "&inDate=" + inDate;
            window.location.href = "${pageContext.request.contextPath}" + str;
        }

        function lastPage() {
            window.location.href = "${pageContext.request.contextPath}/work/queryWorkList?workKey=${workKey}&inDate=${inDate}&pageNum=${info.pages}";
        }

        function firstPage() {
            window.location.href = "${pageContext.request.contextPath}/work/queryWorkList?workKey=${workKey}&inDate=${inDate}&pageNum=1";
        }

        function nextPage() {
            window.location.href = "${pageContext.request.contextPath}/work/queryWorkList?workKey=${workKey}&inDate=${inDate}&pageNum=${info.nextPage}";
        }

        function prePage() {
            window.location.href = "${pageContext.request.contextPath}/work/queryWorkList?workKey=${workKey}&inDate=${inDate}&pageNum=${info.prePage}"
        }
    </script>
</head>
${msg}
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">工作管理</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/work/queryWorkList" method="post">
    <div class="formbody">
        <ul class="seachform">
            <li><label>工作管理编号</label><input id="workKey" name="workKey" type="text" class="scinput" value="${workKey}"/>
            </li>
            <li><label>录入日期</label><input id="inDate" name="inDate" type="text" class="scinput" value="${inDate}"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
        </ul>
    </div>
</form>
<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar1">
            <li><a href="${pageContext.request.contextPath}/view/manager/workMgrAdd.jsp"><span><img
                    src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
            <li><a href="javascript:checkk()"><span><img
                    src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</a></li>
        </ul>
    </div>
    <table class="tablelist">
        <thead>
        <tr class="tablehead">
            <td colspan="11">工作记录</td>
        </tr>
        </thead>
        <thead>
        <tr>
            <th><input id="checkAll" name="checkAll" type="checkbox" value=""/></th>
            <th>记录时间</th>
            <th>客户维护</th>
            <th>产品信息</th>
            <th>货后管理</th>
            <th>风险预警</th>
            <th>发现问题</th>
            <th>工作建议及感悟</th>
            <th width="15%">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${info.list}" var="ww">
            <tr>
                <td><input name="checkchild" type="checkbox" value="${ww.cmKey}"/></td>
                <td><fmt:formatDate value="${ww.cmDate}" pattern="yyyy-MM-dd"/></td>
                <td>${ww.cmManagement}</td>
                <td>${ww.cmProduct}</td>
                <td>${ww.cmLoan}</td>
                <td>${ww.cmWarning}</td>
                <td>${ww.cmIssue}</td>
                <td>${ww.cmWorkProposal}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/work/beforeUpdate?workId=${ww.cmKey}"><img
                            src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                    <a href="${pageContext.request.contextPath}/work/deleteWork?workId=${ww.cmKey}"><img
                            src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td class="STYLE4">
                    <div class="message">共<i class="blue">${info.total}</i>条记录，当前显示第&nbsp;<i
                            class="blue">${info.pageNum}&nbsp;</i>页
                    </div>
                </td>
                <td>
                    <table border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="45"><img src="${pageContext.request.contextPath}/images/first.gif" width="33"
                                                height="20" style="cursor:hand" onclick="firstPage()"/></td>
                            <c:if test="${info.hasPreviousPage==true}">
                                <td width="50"><img src="${pageContext.request.contextPath}/images/back.gif" width="43"
                                                    height="20" style="cursor:hand" onclick="prePage()"/></td>
                            </c:if>
                            <c:if test="${info.hasPreviousPage==false}">
                                <td width="50"><img src="${pageContext.request.contextPath}/images/back.gif" width="43"
                                                    height="20" style="cursor:hand" onclick="alert('已经是第一页！')"/></td>
                            </c:if>
                            <c:if test="${info.hasNextPage==true}">
                                <td width="50"><img src="${pageContext.request.contextPath}/images/next.gif" width="43"
                                                    height="20" style="cursor:hand" onclick="nextPage()"/></td>
                            </c:if>
                            <c:if test="${info.hasNextPage==false}">
                                <td width="50"><img src="${pageContext.request.contextPath}/images/next.gif" width="43"
                                                    height="20" style="cursor:hand" onclick="alert('已经是最后一页！')"/></td>
                            </c:if>
                            <td width="40"><img src="${pageContext.request.contextPath}/images/last.gif" width="33"
                                                height="20" style="cursor:hand" onclick="lastPage()"/></td>
                            <td width="100">
                                <div align="center"><span class="STYLE1">转到第
	                    <input id="textfield" name="textfield" type="text" size="4"
                               style="height:16px; width:35px; border:1px solid #999999;"/>
	                    页 </span></div>
                            </td>
                            <td width="40"><img src="${pageContext.request.contextPath}/images/go.gif" width="33"
                                                height="17" style="cursor:hand" onclick="return goPage()"/></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>