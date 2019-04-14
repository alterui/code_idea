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

<%@include file="../adminPage/top.jsp"%>
<%@include file="../adminPage/left.jsp"%>
<%@include file="../adminPage/bottom.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${ctx}/static/css/back.css">
    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/js/jquery-2.1.1.js">
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>
    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });

        //合格的确认
        function confirmQuality() {
            var msg = "您确定合格吗？";
            if (confirm(msg) == true) {

                return true;
            } else {
                return false;
            }
        }

        //合格
        function qualityData(id) {
            if (confirmQuality() == true) {

                window.location.href = "${pageContext.request.contextPath}/page/beam/qualified/" + id;
            }
        }

        //不合格的确认
        function confirmNotQuality() {
            var msg = "您确定不合格吗？";
            if (confirm(msg) == true) {

                return true;
            } else {
                return false;
            }
        }

        //不合格
        function notQualityData(id) {
            if (confirmNotQuality() == true) {

                window.location.href = "${pageContext.request.contextPath}/page/beam/notQualified/" + id;
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

                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;梁质量验收&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                位置跳转&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/beam/"><font color="#228b22">待确认验收</font></a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/beam/hasQuality"><font color="#228b22">已确认验收</font></a>


                <div style="float: right">
                    其他质量验收&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a  class="layui-this" href="/page/beam/">梁质量验收</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/bear/">支座质量验收</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pier/">墩台质量验收</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pile/">桩质量验收</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/tower/">锁塔质量验收</a>
                </div>
            </blockquote>


            <div class="layui-tab" >

                <form action="/page/beam/notQualitySearch" method="post">

                    <button class="layui-btn"   style=" float: right">搜索</button>
                    <input type="text" name="notQualitySearch"  style="margin-right: 6px; float: right " required placeholder="请输入搜索内容" class="layui-input">

                </form>


            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">


                    <form   method="post"  action="/page/beam/qualified">
                        <input type="hidden" name="currentUrl" id="currentUrl" value="">
                        <table class="layui-table">
                            <colgroup>
                                <col width="150">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="130">
                                <col width="100">
                                <col width="100">
                                <col width="130">
                                <col width="100">
                                <col width="100">
                                <col width="150">
                                <col width="240">
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
                                <th>验收时间</th>
                                <th>操作</th>
                            </thead>
                            <tbody>

                            <c:forEach items="${pageInfo.list}" var="beam">
                                <tr>
                                    <td>
                                        <input type="hidden" name="id" value="${beam.id}">
                                            ${beam.struId}
                                    </td>
                                    <td>
                                            ${beam.axialDevi}
                                    </td>
                                    <td>
                                            ${beam.sectionDevi}
                                    </td>

                                    <td>
                                            ${beam.topElevDevi}
                                    </td>

                                    <td>
                                            ${beam.segmHeightDevi}
                                    </td>

                                    <td>
                                            ${beam.heightDevi}
                                    </td>

                                    <td>
                                            ${beam.crossSlopeDevi}
                                    </td>

                                    <td>
                                            ${beam.embePartsDevi}
                                    </td>

                                    <td>
                                            ${beam.smooDevi}
                                    </td>

                                    <td>
                                            ${beam.cableTubeAxisDevi}
                                    </td>

                                    <td>
                                            ${beam.prestTendDevi}
                                    </td>

                                    <td>
                                            ${beam.cableTensi}
                                    </td>

                                    <td>
                                            ${beam.bridgeSite}
                                    </td>





                                    <td>
                                        <fmt:formatDate value="${beam.beamqualityCheckTime}"
                                                        pattern="yyyy-MM-dd HH:mm:ss"/>
                                    </td>


                                    <td>
                                       <%-- 合格<input  type="radio" name="beam_${beam.id}" value="1"  checked="checked"

                                                >&nbsp;&nbsp;
                                        不合格<input type="radio" name="beam_${beam.id}" value="0" >--%>


                                           <a onclick="qualityData(${beam.id})"
                                              class="layui-btn layui-btn-mini">合格

                                           </a>
                                           <a
                                                   onclick="notQualityData(${beam.id})"
                                                   class="layui-btn layui-btn-danger layui-btn-mini">不合格
                                           </a>


                                    </td>

                                </tr>
                            </c:forEach>
                           <%-- <tr>

                                <td colspan="10">
                                    <div style="width: 216px; margin: 0; text-align:right; float:right"; >

                                        <button class="layui-btn layui-btn-fluid" type="submit" >提交</button>
                                    </div>

                                </td>
                            </tr>--%>
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