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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;支座已审核数据显示
            </blockquote>
            <br>
            <div align="center"><font color="blue"><h1>${year}年${month}月${day}日支座已审核数据明细</h1></font></div>
            <br>





            <table class="layui-table" lay-data="{id:'tableDate'}"   lay-filter="demo">
                <thead>
                <tr>

                    <th lay-data="{hide:true,field:'id'}"></th>
                    <th lay-data="{field:'struId',align:'center',width:120,sort:true}">结构编号</th>
                    <th lay-data="{field:'auditStatus',align:'center',width:120,sort: true}">审核状态</th>
                    <th lay-data="{field:'upCentVert',align:'center',width:180,sort:true}">上座板中心纵向错动量</th>
                    <th lay-data="{field:'downCentTran',align:'center',width:180,sort:true}">下座板中心横向错动量</th>
                    <th lay-data="{field:'sameCentVert',align:'center',width:180, sort:true}">同端支座中心横向距离</th>
                    <th lay-data="{field:'sameRela',align:'center',width:200,sort:true}">同一梁端亮支座相对高差</th>
                    <th lay-data="{field:'edgeHeig',align:'center',width:180, sort:true}">每一支座的边缘高差</th>
                    <th lay-data="{field:'crossLineTors',align:'center',width:180,sort:true}">上下座板十字线扭转</th>
                    <th lay-data="{field:'actiVert',align:'center',width:180, sort:true}">活动支座的纵向错动量</th>
                    <th lay-data="{field:'bearingqualityCheckTime',align:'center',width:180,sort:true}">验收时间</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${pageInfo.list}" var="bear">
                    <tr>

                        <td>
                                ${bear.id}
                        </td>
                        <td>

                                ${bear.struId}
                        </td>

                        <td>
                            <!-- -1代表等待审核，0代表审核不通过(不合格)，1代表审核通过(合格),-->
                            <c:choose>

                                <c:when test="${bear.isQualify==-1}">
                                    <b>等待审核</b>
                                </c:when>

                                <c:when test="${bear.isQualify==0}">
                                    <b><font color="red">不通过</font></b>
                                </c:when>

                                <c:otherwise>
                                    <b><font color="green">通过</font></b>
                                </c:otherwise>
                            </c:choose>


                        </td>



                        <td>

                            <!-- copy-->

                            <c:set var="upCentVert" value="${bear.upCentVert}"></c:set>

                            <c:choose>

                                <c:when test="${upCentVert>=upCentVertStandardLeft && upCentVert<=upCentVertStandardRight}">
                                    <b>${bear.upCentVert}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.upCentVert}</font></b>
                                </c:otherwise>
                            </c:choose>


                        </td>

                        <td>

                            <c:set var="downCentTran" value="${bear.downCentTran}"></c:set>

                            <c:choose>

                                <c:when test="${downCentTran>=downCentTranStandardLeft && downCentTran<=downCentTranStandardRight}">
                                    <b>${bear.downCentTran}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.downCentTran}</font></b>
                                </c:otherwise>
                            </c:choose>



                        </td>

                        <td>

                            <c:set var="sameCentVert" value="${bear.sameCentVert}"></c:set>

                            <c:choose>

                                <c:when test="${sameCentVert>=sameCentVertStandardLeft && sameCentVert<=sameCentVertStandardRight}">
                                    <b>${bear.sameCentVert}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.sameCentVert}</font></b>
                                </c:otherwise>
                            </c:choose>


                        </td>

                        <td>

                            <c:set var="sameRela" value="${bear.sameRela}"></c:set>

                            <c:choose>

                                <c:when test="${sameRela>=sameRelaStandardLeft && sameRela<=sameRelaStandardRight}">
                                    <b>${bear.sameRela}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.sameRela}</font></b>
                                </c:otherwise>
                            </c:choose>

                        </td>

                        <td>




                            <c:set var="edgeHeig" value="${bear.edgeHeig}"></c:set>

                            <c:choose>

                                <c:when test="${edgeHeig>=edgeHeigStandardLeft && edgeHeig<=edgeHeigStandardRight}">
                                    <b>${bear.edgeHeig}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.edgeHeig}</font></b>
                                </c:otherwise>
                            </c:choose>

                        </td>

                        <td>

                            <c:set var="crossLineTors" value="${bear.crossLineTors}"></c:set>

                            <c:choose>

                                <c:when test="${crossLineTors>=crossLineTorsStandardLeft && crossLineTors<=crossLineTorsStandardRight}">
                                    <b>${bear.crossLineTors}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.crossLineTors}</font></b>
                                </c:otherwise>
                            </c:choose>



                        </td>

                        <td>


                            <c:set var="actiVert" value="${bear.actiVert}"></c:set>

                            <c:choose>

                                <c:when test="${actiVert>=actiVertStandardLeft && actiVert<=actiVertStandardRight}">
                                    <b>${bear.actiVert}</b>
                                </c:when>


                                <c:otherwise>
                                    <b><font color="red">${bear.actiVert}</font></b>
                                </c:otherwise>
                            </c:choose>

                        </td>



                        <td>
                            <fmt:formatDate value="${bear.bearingqualityCheckTime}"
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