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
    <script src="${ctx}/static/js/qualityShowJS/beamShow.js"></script>



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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;<a href="/page/beam/show"><font color="#228b22">梁质量数据</font></a>
            </blockquote>

            <!-- 搜索框 -->
             <div class="layui-tab" >
                <form action="/page/beam/search" method="post">
                    <button class="layui-btn"   style=" float: right">搜索</button>
                    <input type="text" value="${search}"  name="search"  style="margin-right: 6px; float: right " required placeholder="请输入结构编号搜索" class="layui-input">
                </form>

             </div>

            <!-- 功能按钮 -->

            <div class="demoTable">

                <a href="/page/beam/addData" class="layui-btn layui-btn-mini">增加数据</a>
                <button class="layui-btn layui-btn-danger" data-type="delCheckData">删除选中</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                开始时间&nbsp;&nbsp;<input  type="text" id="start" name="start" value="${showStart}" class="layui-input">&nbsp;&nbsp;&nbsp;&nbsp;
                结束时间&nbsp;&nbsp;<input   type="text" id="end" name="end" value="${showEnd}" class="layui-input" >
                <button  onclick="return getBeamSearch()"  class="layui-btn layui-btn-mini" type="submit">查询</button>


            </div>

            <script type="text/html" id="barDemo">

                <a href="/page/beam/edit/{{d.id}}"
                   class="layui-btn layui-btn-sm">编辑</a>
                <a
                        onclick="deleteData({{d.id}})"
                        class="layui-btn layui-btn-danger layui-btn-sm">删除
                </a>

            </script>



          <table class="layui-table" lay-data="{id:'tableDate'}" lay-filter="demo">

                <thead>
                     <tr>
                         <th lay-data="{type:'checkbox'}"></th>
                         <th lay-data="{hide:true,field:'id'}"></th>

                         <th lay-data="{field:'struId', align:'center',width:120, sort: true}">结构编号</th>
                         <th lay-data="{field:'axialDevi', align:'center',width:120, sort: true}">轴位偏差</th>
                         <th lay-data="{field:'sectionDevi', align:'center',width:120,sort: true}">断面偏差</th>
                         <th lay-data="{field:'topElevDevi', align:'center',width:120, sort: true}">顶面高程偏差</th>
                         <th lay-data="{field:'segmHeightDevi', align:'center',width:120, sort: true}">节段高差偏差</th>
                         <th lay-data="{field:'heightDevi',align:'center',width:120,sort: true}">长度偏差</th>
                         <th lay-data="{field:'crossSlopeDevi',align:'center',width:120,sort: true}">横坡偏差</th>
                         <th lay-data="{field:'embePartsDevi',align:'center',width:160,sort: true}">预埋件位置偏差</th>
                         <th lay-data="{field:'smooDevi',align:'center',width:120,sort: true}">平整度偏差</th>
                         <th lay-data="{field:'cableTubeAxisDevi',align:'center',width:120,sort: true}">索管轴位偏</th>
                         <th lay-data="{field:'prestTendDevi',align:'center',width:160,sort: true}">预应力筋轴位偏差</th>
                         <th lay-data="{field:'cableTensi',align:'center',width:100,sort: true}">拉索索力</th>
                         <th lay-data="{field:'bridgeSite',align:'center',width:100,sort: true}">左右幅</th>

                         <th lay-data="{field:'beamqualityCheckTime',align:'center',width:180,sort: true}">验收时间</th>
                         <th lay-data="{field:'auditStatus',align:'center',width:120,sort: true}">审核状态</th>
                         <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#barDemo'}">操作</th>

                     </tr>
                     </thead>
                     <tbody>

                        <c:forEach items="${pageInfo.list}" var="beam">
                            <tr>
                                <td>

                                </td>

                                <td>
                                        ${beam.id}
                                </td>
                                <td>
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
                                    <!-- -1代表等待审核，0代表审核不通过(不合格)，1代表审核通过(合格),-->
                                    <c:choose>

                                        <c:when test="${beam.isQualify==-1}">
                                            <b>等待审核</b>
                                        </c:when>

                                        <c:when test="${beam.isQualify==0}">
                                            <b><font color="red">不合格</font></b>
                                        </c:when>

                                        <c:otherwise>
                                            <b><font color="green">合格</font></b>
                                        </c:otherwise>
                                    </c:choose>


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