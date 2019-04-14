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
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/css/back.css">

    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/js/jquery-2.1.1.js">
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
                    width: 15% !important;
                }


            </style>

            <blockquote class="layui-elem-quote">
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/pier/show">墩台质量验收数据</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a><cite>修改墩台质量数据</cite></a>
            </blockquote>


            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">
                    <form action="/page/pier/update" method="post">
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

                            </colgroup>
                            <thead>
                            <tr>
                                <th>结构编号</th>
                                <th>墩台长</th>
                                <th>墩台宽</th>
                                <th>顶面高程</th>
                                <th>轴线偏差</th>
                                <th>垂直度</th>
                                <th>墙面垂直</th>
                                <th>墙面平整度</th>
                                <th>节段间错台</th>



                            </tr>
                            <tbody>


                            <tr>
                                <td>
                                    <input type="hidden" name="id" value="${pier.id}">

                                    <input name="struId" type="textarea" value="${pier.struId}" style="width: 100px" required>

                                </td>
                                <td>
                                    <input name="length" type="textarea" value="${pier.length}"
                                           style="width: 100px" required>
                                </td>
                                <td>
                                    <input name="width" type="textarea" value="${pier.width}"
                                           style="width: 100px" required>
                                </td>

                                <td>
                                    <input name="topElev" type="textarea" value="${pier.topElev}"
                                           style="width: 100px" required>

                                </td>

                                <td>
                                    <input name="axisOffs" type="textarea" value="${pier.axisOffs}"
                                           style="width: 100px" required>

                                </td>

                                <td>
                                    <input name="vert" type="textarea" value="${pier.vert}"
                                           style="width: 100px" required>

                                </td>

                                <td>
                                    <input name="surfVert" type="textarea" value="${pier.surfVert}"
                                           style="width: 100px" required>

                                </td>

                                <td>
                                    <input name="planeness" type="textarea" value="${pier.planeness}"
                                           style="width: 100px" required>

                                </td>

                                <td>
                                    <input name="inteFaultTable" type="textarea" value="${pier.inteFaultTable}"
                                           style="width: 100px" required>

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