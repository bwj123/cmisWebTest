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
        function oWorkPerformDel() {
            if (confirm("删除年度工作业绩，您确定要删除吗？"))
                window.close();
        }
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
                width: 260
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            document.getElementById("tab1").style.display = "none";
            document.getElementById("tab2").style.display = "none";
            document.getElementById("tab3").style.display = "none";
            document.getElementById("tab4").style.display = "none";
            document.getElementById("tab5").style.display = "none";
            document.getElementById("tab6").style.display = "none";
            document.getElementById("tab7").style.display = "none";
            var hash = "${hash}";
            // alert(hash);
            document.getElementById(hash).style.display = "";//显示
            var block = "${light}";
            // alert(block);
            if (block != null && block != '') {
                document.getElementById(block).style.display = 'block';
            }
        });
    </script>
    <script>
        function isNumber(value) {
            var patrn = /^(-)?\d+(\.\d+)?$/;
            if (patrn.exec(value) == null || value == "") {
                return false
            } else {
                return true
            }
        }
    </script>
    <script type="text/javascript">
        function goPage(tag) {
            if (tag == 1) {
                window.location.href = "${pageContext.request.contextPath}/results/queryList";
            } else if (tag == 2) {
                window.location.href = "${pageContext.request.contextPath}/certificate/queryList";
            } else if (tag == 3) {
                window.location.href = "${pageContext.request.contextPath}/cmrpr/queryList";
            } else if (tag == 4) {
                window.location.href = "${pageContext.request.contextPath}/cmass/queryList";
            } else if (tag == 5) {
                window.location.href = "${pageContext.request.contextPath}/cmltr/queryList";
            } else if (tag == 6) {
                window.location.href = "${pageContext.request.contextPath}/cmlevel/queryList";
            } else if (tag == 7) {
                window.location.href = "${pageContext.request.contextPath}/cmwork/queryList";
            }
        }
    </script>
</head>
${msg}
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">客户经理辅助信息维护</a></li>
    </ul>
</div>
<div class="formbody">
    <div id="usual1" class="usual">
        <div class="itab">
            <ul>
                <li><a href="javascript:goPage(1)" ${hash=='tab1'?"class='selected'":''}>年度工作业绩</a></li>
                <li><a href="javascript:goPage(2)" ${hash=='tab2'?"class='selected'":''}>证照列表</a></li>
                <li><a href="javascript:goPage(3)" ${hash=='tab3'?"class='selected'":''}>奖惩记录</a></li>
                <li><a href="javascript:goPage(4)" ${hash=='tab4'?"class='selected'":''}>考核记录</a></li>
                <li><a href="javascript:goPage(5)" ${hash=='tab5'?"class='selected'":''}>学习培训记录</a></li>
                <li><a href="javascript:goPage(6)" ${hash=='tab6'?"class='selected'":''}>等级认定记录</a></li>
                <li><a href="javascript:goPage(7)" ${hash=='tab7'?"class='selected'":''}>工作经历</a></li>
            </ul>
        </div>
        <!--年度工作业绩  -->
        <%--年度工作业绩ajax--%>
        <script type="text/javascript">
            function deleteResult(id) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/results/deleteResult",
                    dataType: "josn",
                    data: {resId: id},
                    success: function (data) {
                        if (data == 1) {
                            alert("删除年度业绩成功");
                        } else {
                            alert("删除年度业绩失败");
                        }
                        window.location.href = "${pageContext.request.contextPath}/results/queryList?cmId1=${cmId1}&workYear=${workYear}"
                    }
                })
            }
        </script>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate() {
                var t = document.getElementById('cmId1').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk1() {
                var allcheckbox = "";
                var becheckbox = "";
                $("#tab1:input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉
                window.location = "${pageContext.request.contextPath}/results/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <div id="tab1" class="tabson">
            <form action="${pageContext.request.contextPath}/results/queryList" method="post">
                <ul class="seachform">
                    <li><label>客户经理绩编号</label><input id="cmId1" name="cmId1" type="text" class="scinput"
                                                     value="${cmId1}"/></li>
                    <li><label>工作年度</label><input name="workYear" type="text" class="scinput" value="${workYear}"/></li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(1)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk1()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</a></li>
                </ul>
            </div>
            <table class="tablelist" id="table1">
                <thead>
                <tr class="tablehead">
                    <td colspan="10">年度工作业绩</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input name="" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>工作年度</th>
                    <th>工作业绩</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${results}" var="rr">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${rr.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${rr.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td>${rr.cmYear}</td>
                        <td>${rr.cmResult}</td>
                        <td><fmt:formatDate value="${rr.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${rr.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/results/beforeUpdate?resId=${rr.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="javascript:deleteResult(${rr.cmKey})"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate2() {
                var t = document.getElementById('cmId2').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk2() {
                var allcheckbox = "";
                var becheckbox = "";
                $("#tab2:input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉

                window.location = "${pageContext.request.contextPath}/certificate/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <!--证件列表  -->
        <div id="tab2" class="tabson">
            <form action="${pageContext.request.contextPath}/certificate/queryList" method="post">
                <ul class="seachform">
                    <li><label>客户经理编号</label><input id="cmId2" name="cmId2" type="text" class="scinput"
                                                    value="${cmId2}"/></li>
                    <li><label>证照名称</label><input name="cerName" type="text" class="scinput" value="${cerName}"/></li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate2()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(3)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk2()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</a></li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                <tr class="tablehead">
                    <td colspan="14">证照列表</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input name="" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>证书名称</th>
                    <th>证书类型</th>
                    <th>证书编号</th>
                    <th>发证单位</th>
                    <th>发证时间</th>
                    <th>失效时间</th>
                    <th>有效性</th>
                    <th>作废标识</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${certs}" var="cer">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${cer.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${cer.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td>${cer.cmCertificateName}</td>
                        <td>${cer.cmCertificateType}</td>
                        <td>${cer.cmCertificateNo}</td>
                        <td>${cer.cmCertificateUnit}</td>
                        <td><fmt:formatDate value="${cer.cmStartDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${cer.cmEndDate}" pattern="yyyy-MM-dd"/></td>
                        <td>
                            <c:if test="${cer.cmPeriod==0}">
                                无效
                            </c:if>
                            <c:if test="${cer.cmPeriod==1}">
                                有效
                            </c:if>
                        </td>
                        <td>${cer.cmInvalid}</td>
                        <td><fmt:formatDate value="${cer.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cer.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/certificate/beforeUpdate?cerId=${cer.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="${pageContext.request.contextPath}/certificate/deleteCer?cerId=${cer.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate3() {
                var t = document.getElementById('cmId3').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk3() {
                var allcheckbox = "";
                var becheckbox = "";
                $("input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉

                window.location = "${pageContext.request.contextPath}/cmrpr/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <!--奖惩记录  -->
        <div id="tab3" class="tabson">
            <form method="post" action="${pageContext.request.contextPath}/cmrpr/queryList">
                <ul class="seachform">
                    <li><label>客户经理编号</label><input id="cmId3" name="cmId3" type="text" class="scinput"
                                                    value="${cmId3}"/></li>
                    <li><label>奖惩分类</label><input name="cmType" type="text" class="scinput" value="${cmType}"/></li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate3()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(5)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk3()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</a></li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                <tr class="tablehead">
                    <td colspan="14">奖惩记录</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input id="checkAll" name="checkAll" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>奖惩分类</th>
                    <th>奖惩内容</th>
                    <th>生效日期</th>
                    <th>审批单位</th>
                    <th>审批人</th>
                    <th>撤销日期</th>
                    <th>撤销原因</th>
                    <th>附件依据</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cmprprs}" var="cmm">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${cmm.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${cmm.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td>${cmm.cmType}</td>
                        <td>${cmm.cmSub}</td>
                        <td><fmt:formatDate value="${cmm.cmDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cmm.cmAunit}</td>
                        <td>${cmm.cmAperson}</td>
                        <td><fmt:formatDate value="${cmm.cmRdate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cmm.cmAreason}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmrpr/upload?fileName=${cmm.cmAttachment}">${cmm.cmAttachment}</a>
                        </td>
                        <td><fmt:formatDate value="${cmm.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cmm.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmrpr/beforeUpdate?cmrprId=${cmm.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="${pageContext.request.contextPath}/cmrpr/deleteCmprpr?cmrprId=${cmm.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate4() {
                var t = document.getElementById('cmId4').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk4() {
                var allcheckbox = "";
                var becheckbox = "";
                $("input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉

                window.location = "${pageContext.request.contextPath}/cmass/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <!--考核记录  -->
        <div id="tab4" class="tabson">
            <form action="${pageContext.request.contextPath}/cmass/queryList" method="post">
                <ul class="seachform">
                    <li><label>客户经理编号</label><input id="cmId4" name="cmId4" type="text" class="scinput"
                                                    value="${cmId4}"/></li>
                    <li><label>考核时间</label><input name="cmassDate" type="text" class="scinput" value="${cmassDate}"/>
                    </li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate4()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(7)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk4()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</a></li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                <tr class="tablehead">
                    <td colspan="12">考核记录</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input name="" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>考核时间</th>
                    <th>考核内容</th>
                    <th>考核结果</th>
                    <th>考核评价</th>
                    <th>考核单位</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cmasses}" var="cma">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${cma.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${cma.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td><fmt:formatDate value="${cma.cmAsstime}" pattern="yyyy-MM-dd"/></td>
                        <td>${cma.cmAssub}</td>
                        <td>${cma.cmAssperesult}</td>
                        <td>${cma.cmAssraisal}</td>
                        <td>${cma.cmAssunit}</td>
                        <td><fmt:formatDate value="${cma.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cma.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmass/beforeUpdate?cmassId=${cma.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="${pageContext.request.contextPath}/cmass/deleteCmass?cmassId=${cma.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate5() {
                var t = document.getElementById('cmId5').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk5() {
                var allcheckbox = "";
                var becheckbox = "";
                $("input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉
                window.location = "${pageContext.request.contextPath}/cmltr/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <!--学员培训记录  -->
        <div id="tab5" class="tabson">
            <form method="post" action="${pageContext.request.contextPath}/cmltr/queryList">
                <ul class="seachform">
                    <li><label>客户经理编号</label><input id="cmId5" name="cmId5" type="text" class="scinput"
                                                    value="${cmId5}"/></li>
                    <li><label>培训时间</label><input name="cmTime" type="text" class="scinput" value="${cmTime}"/></li>
                    <li><label>科目</label><input name="cmSub" type="text" class="scinput" value="${cmSub}"/></li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate5()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(9)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk5()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>批量删除</a></li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                <tr class="tablehead">
                    <td colspan="16">学员培训记录</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input name="" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>培训时间</th>
                    <th>科目</th>
                    <th>培训单位</th>
                    <th>开始日期</th>
                    <th>结束日期</th>
                    <th>学时</th>
                    <th>学分</th>
                    <th>成绩</th>
                    <th>附件依据</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cmltrs}" var="cml">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${cml.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${cml.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td><fmt:formatDate value="${cml.cmTdate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cml.cmSub}</td>
                        <td>${cml.cmTunit}</td>
                        <td><fmt:formatDate value="${cml.cmStartdate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${cml.cmEnddate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cml.cmKnow}</td>
                        <td>${cml.cmCredit}</td>
                        <td>${cml.cmScore}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmltr/upload?fileName=${cml.cmAttachment}">${cml.cmAttachment}</a>
                        </td>
                        <td><fmt:formatDate value="${cml.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cml.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmltr/beforeUpdate?cmltrId=${cml.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="${pageContext.request.contextPath}/cmltr/deleteCmltr?cmltrId=${cml.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate6() {
                var t = document.getElementById('cmId6').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk6() {
                var allcheckbox = "";
                var becheckbox = "";
                $("input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉

                window.location = "${pageContext.request.contextPath}/cmlevel/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <!--等级认定记录  -->
        <div id="tab6" class="tabson">
            <form method="post" action="${pageContext.request.contextPath}/cmlevel/queryList">
                <ul class="seachform">
                    <li><label>客户经理编号</label><input id="cmId6" name="cmId6" type="text" class="scinput"
                                                    value="${cmId6}"/></li>
                    <li><label>认定时间</label><input name="holdDate" type="text" class="scinput" value="${holdDate}"/></li>
                    <li><label>认定级别</label><input name="holdLevel" type="text" class="scinput" value="${holdLevel}"/>
                    </li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate6()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(11)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk6()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>删除</a></li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                <tr class="tablehead">
                    <td colspan="14">等级认定记录</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input name="" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>认定时间</th>
                    <th>认定级别</th>
                    <th>认定类型</th>
                    <th>附件依据</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cmlevels}" var="cl">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${cl.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${cl.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td><fmt:formatDate value="${cl.cmHoldDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cl.cmHoldLevel}</td>
                        <td>${cl.cmHoldType}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmlevel/upload?fileName=${cl.cmAttachment}">${cl.cmAttachment}</a>
                        </td>
                        <td><fmt:formatDate value="${cl.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cl.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmlevel/beforeUpdate?cmlevelId=${cl.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="${pageContext.request.contextPath}/cmlevel/deleteCmlevel?cmlevelId=${cl.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--复选框--%>
        <script>
            // 验证输入的是否为数字
            function validate7() {
                var t = document.getElementById('cmId7').value;
                if (!isNumber(t) && t != "") {
                    alert('客户经理ID不是有效的数字');
                    return false;
                } else {
                    return true;
                }
            }

            $(function () {
                $("#checkAll").click(function () {
                    $("tbody input").prop("checked", this.checked);
                });
            });

            function checkk7() {
                var allcheckbox = "";
                var becheckbox = "";
                $("input[name=checkchild]").each(function () { //遍历table里的全部checkbox
                    allcheckbox += $(this).val() + ","; //获取所有checkbox的值
                    if ($(this).attr("checked")) //如果被选中
                        becheckbox += $(this).val() + ","; //获取被选中的值
                });
                if (becheckbox.length > 0) //如果获取到
                    becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉
                window.location = "${pageContext.request.contextPath}/cmwork/deleteMany?checkTnum=" + becheckbox;
            }
        </script>
        <!--工作经历  -->
        <div id="tab7" class="tabson">
            <form method="post" action="${pageContext.request.contextPath}/cmwork/queryList">
                <ul class="seachform">
                    <li><label>客户经理编号</label><input id="cmId7" name="cmId7" type="text" class="scinput"
                                                    value="${cmId7}"/></li>
                    <li><label>职务</label><input name="cmPosition" type="text" class="scinput" value="${cmPosition}"/>
                    </li>
                    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"
                                                    onclick="return validate7()"/></li>
                </ul>
            </form>
            <div class="tools">
                <ul class="toolbar1">
                    <li><a href="javascript:openWindow(13)"><span><img
                            src="${pageContext.request.contextPath}/images/t01.png"/></span>添加</a></li>
                    <li><a href="javascript:checkk7()"><span><img
                            src="${pageContext.request.contextPath}/images/t03.png"/></span>删除</a></li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                <tr class="tablehead">
                    <td colspan="14">工作经历</td>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th><input name="" type="checkbox" value=""/></th>
                    <th>姓名</th>
                    <th>任职日期</th>
                    <th>职务</th>
                    <th>单位</th>
                    <th>工作经历</th>
                    <th>附件依据</th>
                    <th>维护日期</th>
                    <th>维护人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cmworks}" var="cmw">
                    <tr>
                        <td><input name="checkchild" type="checkbox" value="${cmw.cmKey}"/></td>
                        <c:forEach items="${cminfo}" var="cc">
                            <c:if test="${cmw.cmId==cc.cmId}">
                                <td>${cc.cmName}</td>
                            </c:if>
                        </c:forEach>
                        <td><fmt:formatDate value="${cmw.cmOfficeDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cmw.cmPosition}</td>
                        <td>${cmw.cmUnit}</td>
                        <td>${cmw.cmWork}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmwork/upload?fileName=${cmw.cmAttachment}">${cmw.cmAttachment}</a>
                        </td>
                        <td><fmt:formatDate value="${cmw.cmModificationDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${cmw.cmModificationPerson}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cmwork/beforeUpdate?cmworkId=${cmw.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t02.png"/>修改</a>
                            <a href="${pageContext.request.contextPath}/cmwork/deleteCmwork?cmworkId=${cmw.cmKey}"><img
                                    src="${pageContext.request.contextPath}/images/t03.png"/>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <script language="javascript">
            function openWindow(scanLog) {
                if (scanLog == 1) {
                    document.getElementById('light1').style.display = 'block';
                } else if (scanLog == 2) {
                    document.getElementById('light2').style.display = 'block';
                } else if (scanLog == 3) {
                    document.getElementById('light3').style.display = 'block';
                } else if (scanLog == 4) {
                    document.getElementById('light4').style.display = 'block';
                } else if (scanLog == 5) {
                    document.getElementById('light5').style.display = 'block';
                } else if (scanLog == 6) {
                    document.getElementById('light6').style.display = 'block';
                } else if (scanLog == 7) {
                    document.getElementById('light7').style.display = 'block';
                } else if (scanLog == 8) {
                    document.getElementById('light8').style.display = 'block';
                } else if (scanLog == 9) {
                    document.getElementById('light9').style.display = 'block';
                } else if (scanLog == 10) {
                    document.getElementById('light10').style.display = 'block';
                } else if (scanLog == 11) {
                    document.getElementById('light11').style.display = 'block';
                } else if (scanLog == 12) {
                    document.getElementById('light12').style.display = 'block';
                } else if (scanLog == 13) {
                    document.getElementById('light13').style.display = 'block';
                } else if (scanLog == 14) {
                    document.getElementById('light14').style.display = 'block';
                }
            }

            function closeWindow(id) {
                document.getElementById(id).style.display = 'none';
            }
        </script>
        <div id="light1" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/results/insert" method="post">
                <div class="formbody">
                    <div class="formtitle"><span>添加年度工作业绩</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="" required/></li>
                        <li><label>工作年度</label><input name="cmYear" type="text" class="dfinput" value="" required/></li>
                        <li><label>工作业绩</label><input name="cmResult" type="text" class="dfinput" value="" required/>
                        </li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light1')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light2" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/results/update" method="post">
                <div class="formbody">
                    <div class="formtitle"><span>修改年度工作业绩</span></div>
                    <ul class="forminfo">
                        <input type="hidden" value="${upResult.cmKey}" name="cmKey"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="${upResult.cmId}"
                                                        readonly/></li>
                        <li><label>工作年度</label><input name="cmYear" type="text" class="dfinput"
                                                      value="${upResult.cmYear}" required/></li>
                        <li><label>工作业绩</label><input name="cmResult" type="text" class="dfinput"
                                                      value="${upResult.cmResult}" required/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light2')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light3" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/certificate/insert" method="post"
                  enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>添加证件</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="" required/></li>
                        <li><label>证书名称</label><input name="cmCertificateName" type="text" class="dfinput" value=""
                                                      required/></li>
                        <li><label>证书类型</label>
                            <div class="vocation"><select class="select1" name="cmCertificateType" required>
                                <option value="0">请选择</option>
                                <option value="从业资格证">从业资格证</option>
                                <option value="岗位证书">岗位证书</option>
                            </select></div>
                        </li>
                        <li><label>证书编号</label><input name="cmCertificateNo" type="text" class="dfinput" value=""
                                                      required/></li>
                        <li><label>发证单位</label><input name="cmCertificateUnit" type="text" class="dfinput" value=""
                                                      required/></li>
                        <li><label>发证时间</label><input name="cmStartDate" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>失效时间</label><input name="cmEndDate" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>备注</label><input name="cmRemark" type="text" class="dfinput" value=""/></li>
                        <li><label>附件上传</label><input name="cerFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light3')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light4" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/certificate/update" method="post"
                  enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>修改证件</span></div>
                    <ul class="forminfo">
                        <input type="hidden" name="cmKey" value="${upCer.cmKey}"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="${upCer.cmId}"
                                                        readonly/></li>
                        <li><label>证书名称</label><input name="cmCertificateName" type="text" class="dfinput"
                                                      value="${upCer.cmCertificateName}" required/></li>
                        <li><label>证书类型</label>
                            <div class="vocation"><select class="select1" name="cmCertificateType">
                                <option value="0">请选择</option>
                                <option value="从业资格证" ${upCer.cmCertificateType=='从业资格证'?'selected':''}>从业资格证</option>
                                <option value="岗位证书" ${upCer.cmCertificateType=='岗位证书'?'selected':''}>岗位证书</option>
                            </select></div>
                        </li>
                        <li><label>证书编号</label><input name="cmCertificateNo" type="text" class="dfinput"
                                                      value="${upCer.cmCertificateNo}" required/></li>
                        <li><label>发证单位</label><input name="cmCertificateUnit" type="text" class="dfinput"
                                                      value="${upCer.cmCertificateUnit}" required/></li>
                        <li><label>发证时间</label><input name="cmStartDate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCer.cmStartDate}" pattern="yyyy-MM-dd"/>"
                                                      required/></li>
                        <li><label>失效时间</label><input name="cmEndDate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCer.cmEndDate}" pattern="yyyy-MM-dd"/>"
                                                      required/></li>
                        <li><label>备注</label><input name="cmRemark" type="text" class="dfinput"
                                                    value="${upCer.cmRemark}"/></li>
                        <li><label>附件上传</label><input name="cerFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light4')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light5" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmrpr/insert" method="post" enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>添加奖惩记录</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="" required/></li>
                        <li><label>奖惩分类</label><input name="cmType" type="text" class="dfinput" value="" required/></li>
                        <li><label>奖惩内容</label><input name="cmSub" type="text" class="dfinput" value="" required/></li>
                        <li><label>生效日期</label><input name="cmDate" type="text" class="dfinput" value="" required/></li>
                        <li><label>审批单位</label><input name="cmAunit" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>审批人</label><input name="cmAperson" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>撤销日期</label><input name="cmRdate" type="text" class="dfinput" value=""/></li>
                        <li><label>撤销原因</label><input name="cmAreason" type="text" class="dfinput" value=""/></li>
                        <li><label>备注</label><input name="cmRemark" type="text" class="dfinput" value=""/></li>
                        <li><label>附件上传</label><input name="cmrprFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light5')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light6" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmrpr/update" method="post" enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>修改奖惩记录</span></div>
                    <ul class="forminfo">
                        <input type="hidden" value="${upCmrpr.cmKey}" name="cmKey"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="${upCmrpr.cmId}"
                                                        readonly/></li>
                        <li><label>奖惩分类</label><input name="cmType" type="text" class="dfinput"
                                                      value="${upCmrpr.cmType}" required/></li>
                        <li><label>奖惩内容</label><input name="cmSub" type="text" class="dfinput" value="${upCmrpr.cmSub}"
                                                      required/></li>
                        <li><label>生效日期</label><input name="cmDate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmrpr.cmDate}" pattern="yyyy-MM-dd"/>"
                                                      required/></li>
                        <li><label>审批单位</label><input name="cmAunit" type="text" class="dfinput"
                                                      value="${upCmrpr.cmAunit}" required/></li>
                        <li><label>审批人</label><input name="cmAperson" type="text" class="dfinput"
                                                     value="${upCmrpr.cmAperson}" required/></li>
                        <li><label>撤销日期</label><input name="cmRdate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmrpr.cmRdate}" pattern="yyyy-MM-dd"/>"/>
                        </li>
                        <li><label>撤销原因</label><input name="cmAreason" type="text" class="dfinput"
                                                      value="${upCmrpr.cmAreason}"/></li>
                        <li><label>备注</label><input name="cmRemark" type="text" class="dfinput"
                                                    value="${upCmrpr.cmRemark}"/></li>
                        <li><label>附件上传</label><input name="cmrprFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light6')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light7" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmass/insert" method="post">
                <div class="formbody">
                    <div class="formtitle"><span>添加考核记录</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="" required/></li>
                        <li><label>考核时间</label><input name="cmAsstime" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>考核内容</label><input name="cmAssub" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>考核结果</label><input name="cmAssperesult" type="text" class="dfinput" value=""
                                                      required/></li>
                        <li><label>考核评价</label><input name="cmAssraisal" type="text" class="dfinput" value=""/></li>
                        <li><label>考核单位</label><input name="cmAssunit" type="text" class="dfinput" value=""/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light7')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light8" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmass/update" method="post">
                <div class="formbody">
                    <div class="formtitle"><span>修改考核记录</span></div>

                    <ul class="forminfo">
                        <input type="hidden" value="${upCmass.cmKey}" name="cmKey"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="${upCmass.cmId}"
                                                        readonly/></li>
                        <li><label>考核时间</label><input name="cmAsstime" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmass.cmAsstime}" pattern="yyyy-MM-dd"/>"
                                                      required/></li>
                        <li><label>考核内容</label><input name="cmAssub" type="text" class="dfinput"
                                                      value="${upCmass.cmAssub}" required/></li>
                        <li><label>考核结果</label><input name="cmAssperesult" type="text" class="dfinput"
                                                      value="${upCmass.cmAssperesult}" required/></li>
                        <li><label>考核评价</label><input name="cmAssraisal" type="text" class="dfinput"
                                                      value="${upCmass.cmAssraisal}"/></li>
                        <li><label>考核单位</label><input name="cmAssunit" type="text" class="dfinput"
                                                      value="${upCmass.cmAssunit}"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light8')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light9" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmltr/insert" method="post" enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>添加学习培训记录</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value=""/></li>
                        <li><label>培训时间</label><input name="cmTdate" type="text" class="dfinput" value=""/></li>
                        <li><label>科目</label><input name="cmSub" type="text" class="dfinput" value=""/></li>
                        <li><label>培训单位</label><input name="cmTunit" type="text" class="dfinput" value=""/></li>
                        <li><label>开始日期</label><input name="cmStartdate" type="text" class="dfinput" value=""/></li>
                        <li><label>结束日期</label><input name="cmEnddate" type="text" class="dfinput" value=""/></li>
                        <li><label>学时</label><input name="cmKnow" type="text" class="dfinput" value=""/></li>
                        <li><label>学分</label><input name="cmCredit" type="text" class="dfinput" value=""/></li>
                        <li><label>成绩</label><input name="cmScore" type="text" class="dfinput" value=""/></li>
                        <li><label>附件</label><input name="cmltrFile" type="file" class="dfinput"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light9')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light10" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmltr/update" method="post" enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>修改学习培训记录</span></div>
                    <ul class="forminfo">
                        <input type="hidden" name="cmKey" value="${upCmltr.cmKey}"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="${upCmltr.cmId}" readonly/></li>
                        <li><label>培训时间</label><input name="cmTdate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmltr.cmTdate}" pattern="yyyy-MM-dd"/>"
                                                      required/></li>
                        <li><label>科目</label><input name="cmSub" type="text" class="dfinput" value="${upCmltr.cmSub}"
                                                    required/></li>
                        <li><label>培训单位</label><input name="cmTunit" type="text" class="dfinput"
                                                      value="${upCmltr.cmTunit}" required/></li>
                        <li><label>开始日期</label><input name="cmStartdate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmltr.cmStartdate}" pattern="yyyy-MM-dd"/>" required/></li>
                        <li><label>结束日期</label><input name="cmEnddate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmltr.cmEnddate}" pattern="yyyy-MM-dd"/>" required/></li>
                        <li><label>学时</label><input name="cmKnow" type="text" class="dfinput"
                                                    value="${upCmltr.cmKnow}"/></li>
                        <li><label>学分</label><input name="cmCredit" type="text" class="dfinput"
                                                    value="${upCmltr.cmCredit}"/></li>
                        <li><label>成绩</label><input name="cmScore" type="text" class="dfinput"
                                                    value="${upCmltr.cmScore}"/></li>
                        <li><label>附件</label><input name="cmltrFile" type="file" class="dfinput"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light10')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light11" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmlevel/insert" method="post"
                  enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>添加等级认定记录</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="" required/></li>
                        <li><label>认定时间</label><input name="cmHoldDate" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>认定级别</label><input name="cmHoldLevel" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>认定类型</label><input name="cmHoldType" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>附件上传</label><input name="cmlevelFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light11')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light12" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmlevel/update" method="post"
                  enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>修改等级认定记录</span></div>
                    <ul class="forminfo">
                        <input value="${upCmlevel.cmKey}" type="hidden" name="cmKey"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput"
                                                        value="${upCmlevel.cmId}" readonly/></li>
                        <li><label>认定时间</label><input name="cmHoldDate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upCmlevel.cmHoldDate}" pattern="yyyy-MM-dd"/>" required/></li>
                        <li><label>认定级别</label><input name="cmHoldLevel" type="text" class="dfinput"
                                                      value="${upCmlevel.cmHoldLevel}" required/></li>
                        <li><label>认定类型</label><input name="cmHoldType" type="text" class="dfinput"
                                                      value="${upCmlevel.cmHoldType}" required/></li>
                        <li><label>附件上传</label><input name="cmlevelFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light12')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light13" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmwork/insert" method="post" enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>添加工作经历</span></div>
                    <ul class="forminfo">
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="" required/></li>
                        <li><label>任职日期</label><input name="cmOfficeDate" type="text" class="dfinput" value="" required/></li>
                        <li><label>职务</label><input name="cmPosition" type="text" class="dfinput" value="" required/>
                        </li>
                        <li><label>单位</label><input name="cmUnit" type="text" class="dfinput" value="" required/></li>
                        <li><label>工作经历</label><input name="cmWork" type="text" class="dfinput" value="" required/></li>
                        <li><label>附件上传</label><input name="cmworkFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="添加"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light13')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
        <div id="light14" class="firstScan_main">
            <form action="${pageContext.request.contextPath}/cmwork/update" method="post" enctype="multipart/form-data">
                <div class="formbody">
                    <div class="formtitle"><span>修改工作经历</span></div>
                    <ul class="forminfo">
                        <input value="${upcmWork.cmKey}" name="cmKey" type="hidden"/>
                        <li><label>客户经理编号</label><input name="cmId" type="text" class="dfinput" value="${upcmWork.cmId}"
                                                        readonly/></li>
                        <li><label>任职日期</label><input name="cmOfficeDate" type="text" class="dfinput"
                                                      value="<fmt:formatDate value="${upcmWork.cmOfficeDate}" pattern="yyyy-MM-dd"/>"
                                                      required/></li>
                        <li><label>职务</label><input name="cmPosition" type="text" class="dfinput"
                                                    value="${upcmWork.cmPosition}" required/></li>
                        <li><label>单位</label><input name="cmUnit" type="text" class="dfinput" value="${upcmWork.cmUnit}"
                                                    required/></li>
                        <li><label>工作经历</label><input name="cmWork" type="text" class="dfinput"
                                                      value="${upcmWork.cmWork}"/></li>
                        <li><label>附件上传</label><input name="cmworkFile" type="file" class="dfselect1"/></li>
                        <li>&nbsp;&nbsp;<input name="" type="submit" class="btn"
                                               value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="关闭" onclick="closeWindow('light14')"/>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $("#usual1 ul").idTabs();
    </script>
    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
</div>
</body>
</html>