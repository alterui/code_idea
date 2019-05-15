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


    <script src="${ctx}/static/js/public/jquery-2.1.1.js"></script>
    <script src="${ctx}/static/js/back.bak.js"></script>
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>
    <script src="${ctx}/static/js/qualityShowJS/bearShow.js"></script>
    
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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;墩台已审核数据显示
            </blockquote>
            <br>
            <div align="center"><font color="blue"><h1>${year}年${month}月${day}日墩台已审核数据明细</h1></font></div>
            <br>





            <table class="layui-table" lay-data="{id:'tableDate'}" lay-filter="demo">

                <thead>
                <tr>

                    <th lay-data="{hide:true,field:'id'}"></th>

                    <th lay-data="{field:'struId', align:'center',width:120, sort: true}">结构编号</th>
                    <th lay-data="{field:'auditStatus',align:'center',width:120,sort: true}">审核状态</th>

                    <th lay-data="{field:'length', align:'center',width:120, sort: true}">墩台长</th>
                    <th lay-data="{field:'width', align:'center',width:120, sort: true}">墩台宽</th>
                    <th lay-data="{field:'topElev', align:'center',width:120, sort: true}">顶面高程</th>
                    <th lay-data="{field:'axisOffs', align:'center',width:120, sort: true}">轴线偏差</th>
                    <th lay-data="{field:'vert', align:'center',width:120, sort: true}">垂直度</th>
                    <th lay-data="{field:'surfVert', align:'center',width:120, sort: true}">墙面垂直</th>
                    <th lay-data="{field:'planeness', align:'center',width:120, sort: true}">墙面平整度</th>
                    <th lay-data="{field:'inteFaultTable', align:'center',width:120, sort: true}">节段间错台</th>


                    <th lay-data="{fixed: 'right',width:200, align:'center', toolbar: '#barDemo'}">操作</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${pageInfo.list}" var="pier">
                    <tr>


                        <td>
                                ${pier.id}
                        </td>

                        <td>
                                ${pier.struId}
                        </td>

                        <td>
                            <!-- -1代表等待审核，0代表审核不通过(不合格)，1代表审核通过(合格),-->
                            <c:choose>

                                <c:when test="${pier.isQualify==-1}">
                                    <b>等待审核</b>
                                </c:when>

                                <c:when test="${pier.isQualify==0}">
                                    <b><font color="red">不通过</font></b>
                                </c:when>

                                <c:otherwise>
                                    <b><font color="green">通过</font></b>
                                </c:otherwise>
                            </c:choose>


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