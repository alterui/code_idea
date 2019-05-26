<%--

  回执单审核
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/4/9
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="../publicPage/top.jsp"%>
<%@include file="../publicPage/left.jsp"%>
<%@include file="../publicPage/bottom.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/css/back.css">
    <link rel="stylesheet" href="${ctx}/font-awesome/css/font-awesome.min.css">

    <script src="${ctx}/static/js/public/jquery-2.1.1.js"></script>
    <script src="${ctx}/static/js/back.bak.js"></script>
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>
    <script src="${ctx}/static/js/applyAndReportJS/auditForm.js"></script>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <style>
                /*覆盖 layui*/
                .layui-input {
                    display: inline-block;
                    width: 15% !important;
                }
            </style>

            <blockquote class="layui-elem-quote">
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;回执单审核&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/apply/showCheck"><font color="#228b22">待确认审核</font></a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/apply/showHasCheck"><font color="#228b22">已确认审核</font></a>
            </blockquote>

            <!-- 搜索框 -->
            <div class="layui-tab">
                <form action="/page/apply/searchAudit" method="post">
                    <button class="layui-btn" style=" float: right"><i class="layui-icon">&#xe615;</i>搜索</button>
                    <input type="text" value="${search}" name="search" style="margin-right: 6px; float: right " required
                           placeholder="请输入表名搜索" class="layui-input">
                </form>

            </div>


            <!-- 功能按钮 -->

            <div class="demoTable">


                &nbsp;&nbsp;&nbsp;&nbsp;开始时间&nbsp;&nbsp;<input type="text" id="start" name="start" value="${showStart}" class="layui-input">&nbsp;&nbsp;&nbsp;&nbsp;
                结束时间&nbsp;&nbsp;<input type="text" id="end" name="end" value="${showEnd}" class="layui-input">
                <button onclick="return getApplySearch()" class="layui-btn layui-btn-mini" type="submit"><i class="layui-icon">&#xe615;</i>查询</button>


            </div>

            <script type="text/html" id="barDemo">

                <a href="/page/apply/audit/{{d.id}}"
                   class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe6b2;</i>审核</a>



            </script>


            <table class="layui-table" lay-data="{id:'tableDate'}" lay-filter="demo">
                <thead>
                <tr>

                    <th lay-data="{hide:true,field:'id'}"></th>

                    <th lay-data="{field:'contractorUnit', align:'center',width:120, sort: true}">承包单位</th>
                    <th lay-data="{field:'bidNum', align:'center',width:120, sort: true}">标段号</th>
                    <th lay-data="{field:'supervision', align:'center',width:120, sort: true}">监理单位</th>
                    <th lay-data="{field:'serialNum', align:'center',width:120, sort: true}">编号</th>
                    <th lay-data="{field:'formName', align:'center',width:200, sort: true}">申请审批表名称</th>
                    <th lay-data="{field:'director', align:'center',width:120, sort: true}">总监办名称</th>
                    <th lay-data="{field:'projectName', align:'center',width:120, sort: true}">工程名称</th>
                    <th lay-data="{field:'contractorName', align:'center',width:120, sort: true}">承包人</th>
                    <th lay-data="{field:'directorView', align:'center',width:180, sort: true}">申请原因</th>
                    <th lay-data="{field:'applicationTime', align:'center',width:180, sort: true}">申请时间</th>
                    <th lay-data="{fixed: 'right',width:100, align:'center', toolbar: '#barDemo'}">操作</th>


                </tr>
                </thead>
                <tbody>

                <c:forEach items="${pageInfo.list}" var="env">
                    <tr>



                        <td>
                                ${env.id}
                        </td>

                        <td>

                                ${env.contractorUnit}
                        </td>
                        <td>
                                ${env.bidNum}
                        </td>
                        <td>
                                ${env.supervision}
                        </td>

                        <td>
                                ${env.serialNum}
                        </td>

                        <td>
                                ${env.formName}
                        </td>

                        <td>
                                ${env.director}
                        </td>

                        <td>
                                ${env.projectName}
                        </td>

                        <td>
                                ${env.contractorName}
                        </td>

                        <td>
                                ${env.directorView}
                        </td>

                        <td>
                            <fmt:formatDate value="${env.applicationTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>


            <div class=".layui-location-block">
                <c:if test="${pageInfo.pages > 1}">
                    <%--分页 start--%>
                    <nav class="navigation pagination" role="navigation">
                        <div class="nav-links">
                            <c:choose>
                                <c:when test="${pageInfo.pages <= 3 }">
                                    <c:set var="begin" value="1"/>
                                    <c:set var="end" value="${pageInfo.pages }"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="begin" value="${pageInfo.pageNum-1 }"/>
                                    <c:set var="end" value="${pageInfo.pageNum + 2}"/>
                                    <c:if test="${begin < 2 }">
                                        <c:set var="begin" value="1"/>
                                        <c:set var="end" value="3"/>
                                    </c:if>
                                    <c:if test="${end > pageInfo.pages }">
                                        <c:set var="begin" value="${pageInfo.pages-2 }"/>
                                        <c:set var="end" value="${pageInfo.pages }"/>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                                <%--上一页 --%>
                            <c:choose>
                                <c:when test="${pageInfo.pageNum eq 1 }">
                                    <%--当前页为第一页，隐藏上一页按钮--%>
                                </c:when>
                                <c:otherwise>
                                    <a class="page-numbers"
                                       href="${pageUrlPrefix}=${pageInfo.pageNum-1}">
                                        <i class="layui-icon">&lt;</i>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                                <%--显示第一页的页码--%>
                            <c:if test="${begin >= 2 }">
                                <a class="page-numbers" href="${pageUrlPrefix}=1">1</a>
                            </c:if>
                                <%--显示点点点--%>
                            <c:if test="${begin  > 2 }">
                                <span class="page-numbers dots">…</span>
                            </c:if>
                                <%--打印 页码--%>
                            <c:forEach begin="${begin }" end="${end }" var="i">
                                <c:choose>
                                    <c:when test="${i eq pageInfo.pageNum }">
                                        <a class="page-numbers current">${i}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="page-numbers" href="${pageUrlPrefix}=${i}">${i}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                                <%-- 显示点点点 --%>
                            <c:if test="${end < pageInfo.pages-1 }">
                                <span class="page-numbers dots">…</span>
                            </c:if>
                                <%-- 显示最后一页的数字 --%>
                            <c:if test="${end < pageInfo.pages }">
                                <a href="${pageUrlPrefix}=${pageInfo.pages}">
                                        ${pageInfo.pages}
                                </a>
                            </c:if>
                                <%--下一页 --%>
                            <c:choose>
                                <c:when test="${pageInfo.pageNum eq pageInfo.pages }">
                                    <%--到了尾页隐藏，下一页按钮--%>
                                </c:when>
                                <c:otherwise>
                                    <a class="page-numbers"
                                       href="${pageUrlPrefix}=${pageInfo.pageNum+1}">
                                        <i class="layui-icon">&gt;</i>
                                    </a>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </nav>
                    <%--分页 end--%>
                </c:if>


            </div>
        </div>


    </div>


</div>
</div>
</div>
</body>
</html>
