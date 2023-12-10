<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        function confirmMsgDel() {
            if (confirm("删除客户信息,您确定要删除吗?"))
                window.close();
        }

        //首页
        function firstPage() {
            document.forms[0].action = "${pageContext.request.contextPath}/";
            document.forms[0].submit();
        }

        //上一页
        function priviousPage() {
            var pageNow = eval(${custlist.pageNo});
            if (pageNow == 1) {
                alert("已经是第一页！");
                return false;
            }
            var pageT = pageNow - 1;
            document.forms[0].action = "${pageContext.request.contextPath}/cust/getCustListByPage?pageNo=" + pageT + "&pageSize=10";
            document.forms[0].submit();
        }

        //下一页
        function nextPage() {
            var pageNow = eval(${custlist.pageNo});
            if (pageNow >= (eval(${custlist.offsetSize}) - 1)) {
                alert("已经是最后一页！");
                return false;
            }
            var pageT = pageNow + 1;
            document.forms[0].action = "${pageContext.request.contextPath}/cust/getCustListByPage?pageNo=" + pageT + "&pageSize=10";
            document.forms[0].submit();
        }

        //末页
        function lastPage() {
            var pageT = eval(${custlist.offsetSize}) - 1;
            document.forms[0].action = "${pageContext.request.contextPath}/cust/getCustListByPage?pageNo=" + pageT + "&pageSize=10";
            document.forms[0].submit();
        }

        //转到第几页
        function goPage() {
            var page = document.getElementById("inputpage").value;
            if (page == '') {
                alert("请输入页码");
                return false;
            }
            if (page >= eval(${custlist.offsetSize})) {
                alert("输入页码不能大于总页数");
                return false;
            }
            if (page < 1) {
                alert("输入页码不能小于1");
                return false;
            }
            document.forms[0].action = "${pageContext.request.contextPath}/cust/getCustListByPage?pageNo=" + page + "&pageSize=10";
            document.forms[0].submit();
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
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">客户信息管理</a></li>
    </ul>
</div>
<form action="clientinfo/openList_clientInfo" method="post">
    <div class="formbody">
        <ul class="seachform">
            <li><label>客户经理编号</label><input name="c_cm_idstr" type="text" class="scinput" value=''/></li>
            <li><label>客户姓名</label><input name="c_name" type="text" class="scinput" value=''/></li>
            <li><label>客户身份证号</label><input name="c_ssn" type="text" class="scinput" value=''/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
        </ul>
    </div>
    <div class="rightinfo">
        <div class="tools">
            <ul class="toolbar1">
                <li><a href="clientInfoAdd.html"><span><img
                        src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                <li><a href="clientInfoUpdate.html"><span><img src="${pageContext.request.contextPath}/images/t02.png"/></span>修改</a>
                </li>
                <li><a href="javascript:confirmMsgDel()"><span><img
                        src="${pageContext.request.contextPath}/images/t03.png"/></span>删除</a></li>
            </ul>
        </div>
        <table class="tablelist">
            <thead>
            <tr class="tablehead">
                <td colspan="11">客户信息列表</td>
            </tr>
            </thead>
            <thead>
            <tr>
                <th><input name="" type="checkbox" value=""/></th>
                <th>姓名</th>
                <th>身份证号</th>
                <th>联系方式</th>
                <th>年收入（万元）</th>
                <th>资产（万元）</th>
                <th>负债（万元）</th>
                <th>客户单位</th>
                <th>家庭住址</th>
                <th>业务关联</th>
                <th>客户经理</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty custlist}">
                <tr>
                    <td colspan="11" align="center"><font color="red">您检索的数据不存在！</font></td>
                </tr>
            </c:if>
            <c:if test="${not empty custlist}">
                <c:forEach var="cust" items="${custlist.list}">
                    <tr>
                        <td><input name="" type="checkbox" value="${cust.name}"/></td>
                        <td>${cust.name}</td>
                        <td>${cust.ssn}</td>
                        <td>${cust.tel}</td>
                        <td>${cust.salary}</td>
                        <td>${cust.balance}</td>
                        <td>${cust.debt}</td>
                        <td>${cust.unit}</td>
                        <td>${cust.address}</td>
                        <td>${cust.business}</td>
                        <td>${cust.business}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <div class="pagin">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="STYLE4">
                        <div class="message">共<i class="blue">${custlist.rowCount}</i>&nbsp;条记录，当前显示第&nbsp;<i
                                class="blue">${custlist.pageNo}&nbsp;</i>页
                        </div>
                    </td>
                    <td>
                        <table border="0" align="right" cellpadding="0" cellspacing="0">
                            <tr>
                                <td width="45"><img src="${pageContext.request.contextPath}/images/first.gif" width="33"
                                                    height="20" style="cursor:hand" onclick="firstPage()"/></td>
                                <td width="50"><img src="${pageContext.request.contextPath}/images/back.gif" width="43"
                                                    height="20" style="cursor:hand" onclick="priviousPage()"/></td>
                                <td width="50"><img src="${pageContext.request.contextPath}/images/next.gif" width="43"
                                                    height="20" style="cursor:hand" onclick="nextPage()"/></td>
                                <td width="40"><img src="${pageContext.request.contextPath}/images/last.gif" width="33"
                                                    height="20" style="cursor:hand" onclick="lastPage()"/></td>
                                <td width="100">
                                    <div align="center"><span class="STYLE1">转到第
                 <input name="inputpage" id="inputpage" type="text" size="4"
                        style="height:16px; width:35px; border:1px solid #999999;"/>
                 页 </span></div>
                                </td>
                                <td width="40"><img src="${pageContext.request.contextPath}/images/go.gif" width="33"
                                                    height="17" style="cursor:hand" onclick="goPage()"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>