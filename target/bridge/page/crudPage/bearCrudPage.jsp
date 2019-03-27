<%--
  Created by IntelliJ IDEA.质量验收
  User: ALTERUI
  Date: 2019/3/25
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="../top.jsp"%>
<%@include file="../left.jsp"%>
<%@include file="../bottom.jsp"%>

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


    <script type="text/javascript" >
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

/*
                $.ajax({
                    type: "POST",  //提交方式
                    url: "${pageContext.request.contextPath}/page/bear/delete/" + id,//路径
                    dataType: "text",
                    success: function (result) {//返回数据根据结果进行相应的处理
                        if (result.success) {
                            alert("success");
                        } else {
                            alert("fail");
                        }
                    }
                });
                */

                /* $.ajax({
                     async: false,
                     type: "POST",
                     url: '/page/bear/delete/' + id,
                     contentType: "application/x-www-form-urlencoded; charset=utf-8",
                     dataType: "text",
                     complete: function () {
                         window.location.reload();
                     }
                 })*/


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
                    width: 33.333% !important;
                }


            </style>


            <blockquote class="layui-elem-quote">
                <span class="layui-breadcrumb" lay-separator="/">
                  <a>当前位置</a>
                  <a><cite>梁质量数据</cite></a>
                </span>
            </blockquote>

            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">


                    <input type="hidden" name="currentUrl" id="currentUrl" value="">
                    <table class="layui-table">
                        <colgroup>
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="200">
                            <col width="250">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>结构编号</th>
                            <th>上座板中心纵向错动量</th>
                            <th>下座板中心横向错动量</th>
                            <th>同端支座中心横向距离</th>
                            <th>同一梁端亮支座相对高差</th>
                            <th>每一支座的边缘高差</th>
                            <th>上下座板十字线扭转</th>
                            <th>活动支座的纵向错动量</th>
                            <th>验收时间</th>


                            <th>操作</th>

                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${pageInfo.list}" var="bear">
                            <tr>
                                <td>
                                    <input type="hidden" name="id" value="${bear.id}">
                                        ${bear.struId}
                                </td>
                                <td>
                                        ${bear.upCentVert}
                                </td>
                                <td>
                                        ${bear.downCentTran}
                                </td>

                                <td>
                                        ${bear.sameCentVert}
                                </td>

                                <td>
                                        ${bear.sameRela}
                                </td>

                                <td>
                                        ${bear.edgeHeig}
                                </td>

                                <td>
                                        ${bear.crossLineTors}
                                </td>

                                <td>
                                        ${ bear.actiVert}
                                </td>

                                <td>
                                    <fmt:formatDate value="${bear.bearingqualityCheckTime}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <a href="/page/bear/edit/${bear.id}"
                                       class="layui-btn layui-btn-mini">编辑</a>
                                    <a
                                            onclick="deleteData(${bear.id})"
                                            class="layui-btn layui-btn-danger layui-btn-mini">删除
                                    </a>

                                </td>

                            </tr>
                        </c:forEach>
                        <tr>

                            <td colspan="10">

                                <div style="width: 216px; margin: 0; text-align:right; float:right" ;>

                                    <button class="layui-btn layui-btn-normal layui-btn-radius" type="submit">增加数据
                                    </button>
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
</html>