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
    <style type="text/css">
        .input {
            width: 260px;
            height: 20px;
            line-height: 32px;
            border-top: solid 1px #a7b5bc;
            border-left: solid 1px #a7b5bc;
            border-right: solid 1px #ced9df;
            border-bottom: solid 1px #ced9df;
            background: url(${pageContext.request.contextPath}/images/inputbg.gif) repeat-x;
            text-indent: 10px;
        }
    </style>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/cminfo/queryCminfoList">客户经理信息综合管理维护</a></li>
        <li><a href="#">修改</a></li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/cminfo/updateCminfo" method="post" enctype="multipart/form-data">
    <div class="formbody">
        <div class="formtitle"><span>客户经理基本信息</span></div>
        <ul class="forminfo">
            <input type="hidden" name="cmId" value="${cminfo.cmId}"/>
            <li><label>姓名</label><input name="cmName" type="text" class="dfinput" value="${cminfo.cmName}"/></li>
            <li><label>性别</label><cite><input name="cmSex" type="radio" value="M"  ${cminfo.cmSex=='M'?'checked':''} />男&nbsp;&nbsp;&nbsp;&nbsp;<input
                    name="cmSex" type="radio" ${cminfo.cmSex=='F'?'checked':''} value="F"/>女</cite></li>
            <li><label>身份证号</label><input name="cmSsn" type="text" class="dfinput" value="${cminfo.cmSsn}"/></li>
            <li><label>出生年月</label><input name="cmBirthday" type="text" class="dfinput"
                                          value="<fmt:formatDate value="${cminfo.cmBirthday}" pattern="yyyy-MM-dd"/>"/>
            </li>
            <li><label>年龄</label><input name="cmAge" type="text" class="dfinput" value="${cminfo.cmAge}"/></li>
            <li><label>民族</label><cite><select name="cmNation" class="dfselect">
                <option value="0">请选择</option>
                <option value="汉族" ${cminfo.cmNation=='汉族'?'selected':''} >汉族</option>
                <option value="少数民族" ${cminfo.cmNation=='少数民族'?'selected':''}>少数民族</option>
                <option value="其他" ${cminfo.cmNation=='其他'?'selected':''}>其他</option>
            </select></cite></li>
            <li><label>政治面貌</label><cite><select name="cmPoliticalLandscape" class="dfselect">
                <option value="无" ${cminfo.cmPoliticalLandscape=='无'?'selected':''}>请选择</option>
                <option value="中共党员"${cminfo.cmPoliticalLandscape=='中共党员'?'selected':''} >中共党员</option>
                <option value="中共预备党员"${cminfo.cmPoliticalLandscape=='中共预备党员'?'selected':''}>中共预备党员</option>
                <option value="共青团员" ${cminfo.cmPoliticalLandscape=='共青团员'?'selected':''}>共青团员</option>
                <option value="群众" ${cminfo.cmPoliticalLandscape=='群众'?'selected':''}>群众</option>
                <option value="其他" ${cminfo.cmPoliticalLandscape=='其他'?'selected':''}>其他</option>
            </select></cite></li>
            <li><label>籍贯</label><input name="cmHometown" type="text" class="dfinput" value="${cminfo.cmHometown}"/>
            </li>
            <li><label>照片</label><input name="picture" type="file" class="dfselect1" value="${cminfo.cmPhoto}"/></li>
            <li><label>学历</label><cite><select name="cmEducation" class="dfselect1">
                <option value="无" ${cminfo.cmEducation=='无'?'selected':''}>请选择</option>
                <option value="小学" ${cminfo.cmEducation=='小学'?'selected':''}>小学</option>
                <option value="初中" ${cminfo.cmEducation=='初中'?'selected':''}>初中</option>
                <option value="高中" ${cminfo.cmEducation=='高中'?'selected':''}>高中</option>
                <option value="中专" ${cminfo.cmEducation=='中专'?'selected':''}>中专</option>
                <option value="高职" ${cminfo.cmEducation=='高职'?'selected':''}>高职</option>
                <option value="专科">专科</option>
                <option value="本科" ${cminfo.cmEducation=='本科'?'selected':''}>本科</option>
                <option value="硕士研究生" ${cminfo.cmEducation=='硕士研究生'?'selected':''} >硕士研究生</option>
                <option value="博士研究生" ${cminfo.cmEducation=='博士研究生'?'selected':''}>博士研究生</option>
            </select></cite></li>
            <li><label>学位</label><cite><select name="cmDegree" class="dfselect">
                <option value="无" ${cminfo.cmDegree=='无'?'selected':''}>请选择</option>
                <option value="学士" ${cminfo.cmDegree=='学士'?'selected':''}>学士</option>
                <option value="硕士" ${cminfo.cmDegree=='硕士'?'selected':''}>硕士</option>
                <option value="博士" ${cminfo.cmDegree=='博士'?'selected':''}>博士</option>
                <option value="其他" ${cminfo.cmDegree=='其他'?'selected':''}>其他</option>
            </select></cite></li>
            <li><label>毕业院校及专业</label><input name="cmGraduated" type="text" class="dfinput"
                                             value="${cminfo.cmGraduated}"/></li>
            <li><label>专业技术职称</label>
                <div class="vocation">
                    <select name="cmProfessionalTitles" class="dfselect1">
                        <option value="无" ${cminfo.cmProfessionalTitles=='无'?'selected':''}>请选择</option>
                        <option value="工程专业技术人员 高级工程师" ${cminfo.cmProfessionalTitles=='工程专业技术人员 高级工程师'?'selected':''}>
                            工程专业技术人员 高级工程师
                        </option>
                        <option value="工程专业技术人员 工程师" ${cminfo.cmProfessionalTitles=='工程专业技术人员 工程师'?'selected':''}>
                            工程专业技术人员 工程师
                        </option>
                        <option value="工程专业技术人员 助理工程师" ${cminfo.cmProfessionalTitles=='工程专业技术人员 助理工程师'?'selected':''}>
                            工程专业技术人员 助理工程师
                        </option>
                        <option value="经济专业技术人员 高级经济师" ${cminfo.cmProfessionalTitles=='经济专业技术人员 高级经济师'?'selected':''}>
                            经济专业技术人员 高级经济师
                        </option>
                        <option value="经济专业技术人员 经济师" ${cminfo.cmProfessionalTitles=='经济专业技术人员 经济师'?'selected':''}>
                            经济专业技术人员 经济师
                        </option>
                        <option value="经济专业技术人员 助理经济师" ${cminfo.cmProfessionalTitles=='经济专业技术人员 助理经济师'?'selected':''}>
                            经济专业技术人员 助理经济师
                        </option>
                        <option value="会计专业技术人员 高级会计师" ${cminfo.cmProfessionalTitles=='会计专业技术人员 高级会计师'?'selected':''}>
                            会计专业技术人员 高级会计师
                        </option>
                        <option value="会计专业技术人员 会计师" ${cminfo.cmProfessionalTitles=='会计专业技术人员 会计师'?'selected':''}>
                            会计专业技术人员 会计师
                        </option>
                        <option value="会计专业技术人员 助理会计师" ${cminfo.cmProfessionalTitles=='会计专业技术人员 助理会计师'?'selected':''}>
                            会计专业技术人员 助理会计师
                        </option>
                        <option value="统计专业技术人员 高级统计师" ${cminfo.cmProfessionalTitles=='统计专业技术人员 高级统计师'?'selected':''}>
                            统计专业技术人员 高级统计师
                        </option>
                        <option value="统计专业技术人员 统计师" ${cminfo.cmProfessionalTitles=='统计专业技术人员 统计师'?'selected':''}>
                            统计专业技术人员 统计师
                        </option>
                        <option value="统计专业技术人员 助理统计师" ${cminfo.cmProfessionalTitles=='统计专业技术人员 助理统计师'?'selected':''}>
                            统计专业技术人员 助理统计师
                        </option>
                        <option value="审计专业技术人员 高级审计师" ${cminfo.cmProfessionalTitles=='审计专业技术人员 高级审计师'?'selected':''}>
                            审计专业技术人员 高级审计师
                        </option>
                        <option value="审计专业技术人员 审计师" ${cminfo.cmProfessionalTitles=='审计专业技术人员 审计师'?'selected':''}>
                            审计专业技术人员 审计师
                        </option>
                        <option value="审计专业技术人员 助理审计师" ${cminfo.cmProfessionalTitles=='审计专业技术人员 助理审计师'?'selected':''}>
                            审计专业技术人员 助理审计师
                        </option>
                        <option value="政工专业技术人员 助理政工师" ${cminfo.cmProfessionalTitles=='政工专业技术人员 助理政工师'?'selected':''}>
                            政工专业技术人员 助理政工师
                        </option>
                        <option value="政工专业技术人员 高级政工师" ${cminfo.cmProfessionalTitles=='政工专业技术人员 高级政工师'?'selected':''}>
                            政工专业技术人员 高级政工师
                        </option>
                        <option value="政工专业技术人员 政工师" ${cminfo.cmProfessionalTitles=='政工专业技术人员 政工师'?'selected':''}>
                            政工专业技术人员 政工师
                        </option>
                    </select></div>
            </li>
            <li><label>客户经理等级</label><cite><select name="cmLevel" class="dfselect1">
                <option value="无">请选择</option>
                <option value="高级专家级客户经理" ${cminfo.cmLevel=='高级专家级客户经理'?'selected':''}>高级专家级客户经理</option>
                <option value="专家级客户经理" ${cminfo.cmLevel=='专家级客户经理'?'selected':''} >专家级客户经理</option>
                <option value="资深客户经理" ${cminfo.cmLevel=='资深客户经理'?'selected':''}>资深客户经理</option>
                <option value="高级客户经理" ${cminfo.cmLevel=='高级客户经理'?'selected':''}>高级客户经理</option>
                <option value="客户经理" ${cminfo.cmLevel=='客户经理'?'selected':''}>客户经理</option>
                <option value="客户经理助理" ${cminfo.cmLevel=='客户经理助理'?'selected':''}>客户经理助理</option>
            </select></cite></li>
            <li><label>所在单位</label><input name="cmUnit" type="text" class="dfinput" value="${cminfo.cmUnit}"/></li>
            <li><label>部门</label><input name="cmDept" type="text" class="dfinput" value="${cminfo.cmDept}"/></li>
            <li><label>职务</label><input name="cmPosition" type="text" class="dfinput" value="${cminfo.cmPosition}"/>
            </li>
            <li><label>业务条线</label><cite><select name="cmBusinessLines" class="dfselect">
                <option value="无" ${cminfo.cmBusinessLines=='无'?'selected':''}>请选择</option>
                <option value="对公" ${cminfo.cmBusinessLines=='对公'?'selected':''}>对公</option>
                <option value="对个人" ${cminfo.cmBusinessLines=='对个人'?'selected':''}>对个人</option>
            </select></cite></li>
            <li><label>参加工作时间</label><input name="cmHiredate" type="text" class="dfinput"
                                            value="<fmt:formatDate value="${cminfo.cmHiredate}" pattern="yyyy-MM-dd"/>"/>
            </li>
            <li><label>入行时间</label><input name="cmEntryTime" type="text" class="dfinput"
                                          value="<fmt:formatDate value="${cminfo.cmEntryTime}" pattern="yyyy-MM-dd"/>"/>
            </li>
            <li><label>从事金融工作年限</label><input name="cmFinancialYears" type="text" class="dfinput"
                                              value="${cminfo.cmFinancialYears}"/></li>
            <li><label>客户经理从业年限</label><input name="cmWorkingYears" type="text" class="dfinput"
                                              value="${cminfo.cmWorkingYears}"/></li>
            <li><label>退出时间</label><input name="cmExitTime" type="text" class="dfinput"
                                          value="<fmt:formatDate value="${cminfo.cmExitTime}" pattern="yyyy-MM-dd"/>"/>
            </li>
            <li><label>办公电话</label><input name="cmTel" type="text" class="dfinput" value="${cminfo.cmMobile}"/></li>
            <li><label>手机</label><input name="cmMobile" type="text" class="dfinput" value="${cminfo.cmTel}"/></li>
            <li>&nbsp;&nbsp;<input name="" type="submit" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="reset" class="btn" value="重置"/>
            </li>
        </ul>
    </div>
</form>
</body>
</html>