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
    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">

    <script src="${ctx}/static/js/jquery-2.1.1.js"></script>
    <script src="${ctx}/static/js/back.bak.js"></script>
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>


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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/beam/show">梁验收数据</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a><cite>添加梁质量数据</cite></a>
            </blockquote>

            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">
                    <form action="/page/beam/add" method="post"  class="layui-form">


                        <table class="layui-table" >
                            <colgroup>
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>结构编号</th>
                                <th>轴位偏差</th>
                                <th>断面偏差</th>
                                <th>顶面高程偏差</th>
                                <th>节段高差偏差</th>
                                <th>长度偏差</th>
                                <th>横坡偏差</th>
                                <th>预埋件位置偏差</th>
                                <th>平整度偏差</th>
                                <th>索管轴位偏</th>
                                <th>预应力筋轴位偏差</th>
                                <th>拉索索力</th>
                                <th>左右幅</th>


                            </tr>

                            </thead>
                            <tbody>


                            <tr>
                                <td>
                                    <input name="struId" type="textarea" style="width: 60px" required>
                                </td>
                                <td>
                                    <input name="axialDevi" type="textarea" required
                                           style="width: 60px">
                                </td>

                                <td>
                                    <input name="sectionDevi" type="textarea" required
                                           style="width: 60px">
                                </td>

                                <td>
                                    <input name="topElevDevi" type="textarea" required
                                           style="width: 60px">

                                </td>

                                <td>
                                    <input name="segmHeightDevi" type="textarea" required
                                           style="width: 60px">

                                </td>

                                <td>
                                    <input name="heightDevi" type="textarea" required
                                           style="width: 60px">

                                </td>

                                <td>
                                    <input name="crossSlopeDevi" type="textarea" required
                                           style="width: 60px">

                                </td>

                                <td>
                                    <input name="embePartsDevi" type="textarea" required
                                           style="width: 60px">

                                </td>
                                <td>
                                    <input name="smooDevi" type="textarea" required
                                           style="width: 60px">

                                </td>
                                <td>
                                    <input name="cableTubeAxisDevi" type="textarea" required
                                           style="width: 60px">

                                </td>
                                <td>
                                    <input name="prestTendDevi" type="textarea" required
                                           style="width: 60px">

                                </td>

                                <td>
                                    <input name="cableTensi" type="textarea" required
                                           style="width: 60px">

                                </td>

                                <td>
                                    <input name="bridgeSite" type="textarea" required
                                           style="width: 60px">

                                </td>


                            </tr>

                            <tr>

                                <td colspan="13">

                                    <div style="width: 216px; margin: 0; text-align:right; float:right" ;>


                                        <button class="layui-btn layui-btn-mini" type="submit">保存
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>



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