<%--
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
    <link rel="stylesheet" href="${ctx}/static/js/jquery-2.1.1.js">
    <link rel="stylesheet" href="${ctx}/static/js/back.bak.js">
    <script src="${ctx}/layui/layui.all.js"></script>
    <script src="${ctx}/layui/layui.js"></script>


    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });


        function confirmDelete() {
            var msg = "您确定要删除吗？";
            if (confirm(msg) == true) {

                return true;
            } else {
                return false;
            }
        }


        //删除表里面的数据
        function deleteData(id) {
            if (confirmDelete() == true) {

                window.location.href = "${pageContext.request.contextPath}/page/bear/delete/" + id;
            }
        }


    </script>


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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;<a href="/page/apply/show"><font color="#228b22">报审申请表</font></a>
            </blockquote>

            <!-- 搜索框 -->
            <div class="layui-tab" >
                <form action="/page/bear/search" method="post">
                    <button class="layui-btn"   style=" float: right">搜索</button>
                    <input type="text" name="search"  style="margin-right: 6px; float: right " required placeholder="请输入搜索内容" class="layui-input">
                </form>
                <div class="layui-tab">


                    <div class="layui-tab layui-tab-card">


                        <table class="layui-table">
                            <colgroup>
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="150">
                                <col width="300">
                            </colgroup>
                            <thead>
                            <tr>

                                <th>承包单位</th>
                                <th>标段号</th>
                                <th>监理单位</th>
                                <th>编号</th>
                                <th>申请审批表名称</th>
                                <th>总监办名称</th>
                                <th>工程名称</th>
                                <th>承包人</th>
                                <th>申请时间</th>
                                <th>操作</th>

                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${pageInfo.list}" var="env">
                                <tr>
                                    <td>
                                        <input type="hidden" name="id" value="${env.id}">
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
                                        <fmt:formatDate value="${env.applicationTime}"
                                                        pattern="yyyy-MM-dd HH:mm:ss"/>
                                    </td>
                                    <td>
                                        <a href="/page/bear/edit/${env.id}"
                                           class="layui-btn layui-btn-mini">编辑</a>
                                        <a
                                                onclick="deleteData(${env.id})"
                                                class="layui-btn layui-btn-danger layui-btn-mini">删除
                                        </a>

                                        <a href="/page/apply/downloadDoc/${env.id}"
                                                class="layui-btn layui-btn-normal">下载
                                        </a>

                                    </td>

                                </tr>
                            </c:forEach>
                            <tr>

                                <td colspan="10">

                                    <div style="width: 216px; margin: 0; text-align:right; float:right" ;>

                                        <%-- <button class="layui-btn layui-btn-normal layui-btn-radius" >
                                             <a href="beamAddPage.jsp">
                                                 增加数据
                                             </a>
                                         </button>--%>

                                        <a href="${ctx}/page/crudPage/bearAddPage.jsp"
                                           class="layui-btn layui-btn-mini">增加数据
                                        </a>

                                    </div>
                                </td>
                            </tr>
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
