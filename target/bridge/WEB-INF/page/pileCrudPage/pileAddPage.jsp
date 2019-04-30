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
    <link rel="stylesheet" href="${ctx}/static/js/public/jquery-2.1.1.js">
    <link rel="stylesheet" href="${ctx}/static/js/back.bak.js">
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>


    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });


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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/pile/show">桩验收数据</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a><cite>添加桩质量数据</cite></a>
            </blockquote>

            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">
                    <form action="/page/pile/add" method="post"  class="layui-form">


                        <table class="layui-table">
                            <colgroup>
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="130">
                                <col width="100">
                                <col width="100">
                                <col width="100">


                            </colgroup>
                            <thead>
                            <tr>
                                <th>结构编号</th>
                                <th>桩位偏差</th>
                                <th>沉渣厚度偏差</th>
                                <th>垂直度偏差</th>
                                <th>成孔深度偏差</th>
                                <th>孔径偏差</th>
                                <th>泥浆比重</th>
                                <th>泥浆面标高偏差</th>
                                <th>钢筋笼安装深度偏差</th>
                                <th>混凝土强度</th>
                                <th>混凝土充盈系数</th>
                                <th>桩顶高程偏差</th>

                            </tr>

                            </thead>
                            <tbody>


                            <tr>
                                <td>
                                    <input name="struId" type="textarea" style="width: 70px" required>
                                </td>
                                <td>
                                    <input name="pileDevi" type="textarea" required
                                           style="width: 70px">
                                </td>

                                <td>
                                    <input name="sediThiDevi" type="textarea" required
                                           style="width: 70px">
                                </td>

                                <td>
                                    <input name="vertDevi" type="textarea" required
                                           style="width: 70px">

                                </td>

                                <td>
                                    <input name="holeDepthDevi" type="textarea" required
                                           style="width: 70px">

                                </td>

                                <td>
                                    <input name="aperDevi" type="textarea" required
                                           style="width: 70px">

                                </td>

                                <td>
                                    <input name="mudPropDevi" type="textarea" required
                                           style="width: 70px">

                                </td>

                                <td>
                                    <input name="mudSurfDevi" type="textarea" required
                                           style="width: 70px">

                                </td>
                                <td>
                                    <input name="rebarDevi" type="textarea" required
                                           style="width: 70px">

                                </td>
                                <td>
                                    <input name="conctre" type="textarea" required
                                           style="width: 70px">

                                </td>
                                <td>
                                    <input name="fillingFactor" type="textarea" required
                                           style="width: 70px">

                                </td>

                                <td>
                                    <input name="pileTopDevi" type="textarea" required
                                           style="width: 70px">

                                </td>




                            </tr>

                            <tr>

                                <td colspan="12">

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