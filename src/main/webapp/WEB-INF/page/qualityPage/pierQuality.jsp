<%--
  Created by IntelliJ IDEA.质量审核
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
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="${ctx}/static/css/back.css">
    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">

    <script src="${ctx}/static/js/public/jquery-2.1.1.js"></script>
    <script src="${ctx}/static/js/back.bak.js"></script>
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>
    <script src="${ctx}/static/js/qualityAuditJS/pierQuality.js"></script>



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

                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;墩台质量审核
                &nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/pier"><font color="#228b22">待确认审核</font></a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a href="/page/pier/hasQuality"><font color="#228b22">已确认审核</font></a>


              <%--  <div style="float: right">
                    其他质量审核&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a  class="layui-this" href="/page/beam">梁质量审核</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/bear">支座质量审核</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pile">桩质量审核</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/tower">索塔质量审核</a>
                </div>--%>
            </blockquote>


            <!-- 搜索框 -->
            <div class="layui-tab" >

                <form action="/page/pier/notQualitySearch" method="post">

                    <button class="layui-btn"   style=" float: right"><i class="layui-icon">&#xe615;</i>搜索</button>
                    <input type="text" value="${search}"  name="notQualitySearch"  style="margin-right: 6px; float: right " required placeholder="请输入结构编号搜索" class="layui-input">

                </form>
            </div>


            <div class="demoTable">

                <button class="layui-btn layui-btn-mini" data-type="qualityMore"><i class="layui-icon">&#x1005;</i>批量通过</button>
                <button class="layui-btn layui-btn-danger" data-type="notQualityMore"><i class="layui-icon">&#x1007;</i>批量不通过</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                开始时间&nbsp;&nbsp;<input  type="text" id="start" name="start" value="${showStart}" class="layui-input">&nbsp;&nbsp;&nbsp;&nbsp;
                结束时间&nbsp;&nbsp;<input   type="text" id="end" name="end" value="${showEnd}" class="layui-input" >
                <button  onclick="return getPierSearch()"  class="layui-btn layui-btn-mini" type="submit"><i class="layui-icon">&#xe615;</i>查询</button>


            </div>


            <script type="text/html" id="barDemo">



                <a onclick="qualityData({{d.id}})"
                   class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1005;</i>通过

                </a>
                <a
                        onclick="notQualityData({{d.id}})"
                        class="layui-btn layui-btn-danger layui-btn-sm"><i class="layui-icon">&#x1007;</i>不通过
                </a>

            </script>


              <table class="layui-table"  lay-data="{id:'tableDate'}" lay-filter="demo">
                  <thead>
                      <tr>
                          <th lay-data="{type:'checkbox'}"></th>
                          <th lay-data="{hide:true,field:'id'}"></th>

                          <th lay-data="{field:'struId', align:'center',width:120, sort: true}">结构编号</th>
                          <th lay-data="{field:'length', align:'center',width:120, sort: true}">墩台长</th>
                          <th lay-data="{field:'width', align:'center',width:120, sort: true}">墩台宽</th>
                          <th lay-data="{field:'topElev', align:'center',width:120, sort: true}">顶面高程</th>
                          <th lay-data="{field:'axisOffs', align:'center',width:120, sort: true}">轴线偏差</th>
                          <th lay-data="{field:'vert', align:'center',width:120, sort: true}">垂直度</th>
                          <th lay-data="{field:'surfVert', align:'center',width:120, sort: true}">墙面垂直</th>
                          <th lay-data="{field:'planeness', align:'center',width:120, sort: true}">墙面平整度</th>
                          <th lay-data="{field:'inteFaultTable', align:'center',width:120, sort: true}">节段间错台</th>
                          <th lay-data="{field:'pierqualityCheckTime', align:'center',width:180, sort: true}">验收时间</th>

                          <th lay-data="{fixed: 'right',width:200, align:'center', toolbar: '#barDemo'}">操作</th>


                      </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${pageInfo.list}" var="pier">

                                <tr>

                                    <td>

                                    </td>

                                    <td>
                                            ${pier.id}
                                    </td>


                                    <td>
                                            ${pier.struId}
                                    </td>





                                    <td>

                                        <!-- copy-->

                                        <c:set var="length" value="${pier.length}"></c:set>

                                        <c:choose>

                                            <c:when test="${length>=lengthStandardLeft && length<=lengthStandardRight}">
                                                <b>${pier.length}</b>
                                            </c:when>


                                            <c:otherwise>
                                                <b><font color="red">${pier.length}</font></b>
                                            </c:otherwise>
                                        </c:choose>


                                    </td>
                                    <td>

                                        <c:set var="width" value="${pier.width}"></c:set>

                                        <c:choose>

                                            <c:when test="${width>=widthStandardLeft && width<=widthStandardRight}">
                                                <b>${pier.width}</b>
                                            </c:when>


                                            <c:otherwise>
                                                <b><font color="red">${pier.width}</font></b>
                                            </c:otherwise>
                                        </c:choose>



                                    </td>

                                    <td>

                                        <c:set var="topElev" value="${pier.topElev}"></c:set>

                                        <c:choose>

                                            <c:when test="${topElev>=topElevStandardLeft && topElev<=topElevStandardRight}">
                                                <b>${pier.topElev}</b>
                                            </c:when>


                                            <c:otherwise>
                                                <b><font color="red">${pier.topElev}</font></b>
                                            </c:otherwise>
                                        </c:choose>



                                    </td>

                                    <td>

                                        <c:set var="axisOffs" value="${pier.axisOffs}"></c:set>

                                        <c:choose>

                                            <c:when test="${axisOffs>=axisOffsStandardLeft && axisOffs<=axisOffsStandardRight}">
                                                <b>${pier.axisOffs}</b>
                                            </c:when>


                                            <c:otherwise>
                                                <b><font color="red">${pier.axisOffs}</font></b>
                                            </c:otherwise>
                                        </c:choose>


                                    </td>

                                    <td>

                                        <c:set var="vert" value="${pier.vert}"></c:set>

                                        <c:choose>

                                            <c:when test="${vert>=vertStandardLeft && vert<=vertStandardRight}">
                                                <b>${pier.vert}</b>
                                            </c:when>


                                            <c:otherwise>
                                                <b><font color="red">${pier.vert}</font></b>
                                            </c:otherwise>
                                        </c:choose>

                                    </td>

                                    <td>


                                        <c:set var="surfVert" value="${pier.surfVert}"></c:set>

                                        <c:choose>

                                            <c:when test="${ 0.0<=surfVert && surfVert<=surfVertStandard }">
                                                <b>${pier.surfVert}</b>
                                            </c:when>

                                            <c:otherwise>
                                                <b><font color="red">${pier.surfVert}</font></b>
                                            </c:otherwise>
                                        </c:choose>


                                    </td>

                                    <td>


                                        <c:set var="planeness" value="${pier.planeness}"></c:set>

                                        <c:choose>

                                            <c:when test="${ 0.0<=planeness && planeness<=planenessStandard }">
                                                <b>${pier.planeness}</b>
                                            </c:when>

                                            <c:otherwise>
                                                <b><font color="red">${pier.planeness}</font></b>
                                            </c:otherwise>
                                        </c:choose>


                                    </td>

                                    <td>

                                        <c:set var="inteFaultTable" value="${pier.inteFaultTable}"></c:set>

                                        <c:choose>

                                            <c:when test="${ 0.0<=inteFaultTable && inteFaultTable<=inteFaultTableStandard }">
                                                <b>${pier.inteFaultTable}</b>
                                            </c:when>

                                            <c:otherwise>
                                                <b><font color="red">${pier.inteFaultTable}</font></b>
                                            </c:otherwise>
                                        </c:choose>


                                    </td>


                                    <td>
                                        <fmt:formatDate value="${pier.pierqualityCheckTime}"
                                                        pattern="yyyy-MM-dd HH:mm:ss"/>
                                    </td>





                                </tr>
                            </c:forEach>
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