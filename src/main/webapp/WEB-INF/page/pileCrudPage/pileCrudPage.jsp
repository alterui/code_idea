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


    <script type="text/javascript">
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //墨绿主题
            laydate.render({
                elem: '#start'
                ,theme: 'molv'
            });

            //墨绿主题
            laydate.render({
                elem: '#end'
                ,theme: 'molv'
            });


        });
        //删除表里面的数据
        function deleteData(id) {
            layer.confirm('真的要删除吗？',function (index) {
                window.location.href = "${pageContext.request.contextPath}/page/pile/delete/" + id;
            })
        }

        layui.use('table', function(){
            var table = layui.table;

            //转换静态表格
            table.init('demo', {

            });
        });
        layui.use('table', function () {
            var table = layui.table;
            var $ = layui.$, active = {
                reload: function () {
                    var demoReload = $('#demoReload');

                    //执行重载
                    table.reload('tableDate', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            id: demoReload.val()
                        }
                    });
                }
            };


            var $ = layui.$, active = {
                delCheckData:function () {
                    var checkStatus = table.checkStatus('tableDate')
                        ,data = checkStatus.data
                        ,delList=[];
                    data.forEach(function(n){
                        delList.push(n.id);
                    });


                    if(delList!=''){
                        layer.confirm('真的删除这'+data.length+'行吗？', function(index){
                            $.ajax({
                                url: '/page/pile/deleteMore',
                                type:'post',
                                dataType:'json',
                                data:"id="+delList,
                                success:function (res) {

                                    if(res.length==0){
                                        window.location.href = "${pageContext.request.contextPath}/page/pile/show/";
                                    }else{
                                        layer.msg('删除失败');
                                    }
                                },
                                'error':function () {
                                    layer.msg('系统错误');
                                }
                            })
                        })
                    }else{
                        layer.msg("请选择行");
                    };
                }
            };

            $('.demoTable .layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        });




        function getPileSearch(){

            var start = $("#start").val();
            var end = $("#end").val();

            if (start=="" || end=="") {
                alert("起止时间不能为空！");
                return false;
            }
            //结束时间不能比开始时间小。
            var startTime = new Date(start).getTime();
            var endTime = new Date(end).getTime();
            if (startTime>endTime){
                alert("开始时间不能大于结束时间！");
                return false;
            }

            window.location.href = "${pageContext.request.contextPath}/page/pile/getSearch?start=" + start + " &end=" + end + "";

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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;<a href="/page/pile/show"><font color="#228b22">桩质量数据</font></a>
            </blockquote>

            <!-- 搜索框 -->
             <div class="layui-tab" >
                <form action="/page/pile/search" method="post">
                    <button class="layui-btn"   style=" float: right">搜索</button>
                    <input type="text" name="search"  style="margin-right: 6px; float: right " required placeholder="请输入搜索内容" class="layui-input">
                </form>
             </div>

            <!-- 功能按钮 -->

            <div class="demoTable">

                <a href="/page/pile/addData" class="layui-btn layui-btn-mini">增加数据</a>
                <button class="layui-btn layui-btn-danger" data-type="delCheckData">删除选中</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                开始时间&nbsp;&nbsp;<input  type="text" id="start" name="start" value="${showStart}" class="layui-input">&nbsp;&nbsp;&nbsp;&nbsp;
                结束时间&nbsp;&nbsp;<input   type="text" id="end" name="end" value="${showEnd}" class="layui-input" >
                <button  onclick="return getPileSearch()"  class="layui-btn layui-btn-mini" type="submit">查询</button>


            </div>

            <script type="text/html" id="barDemo">

                <a href="/page/pile/edit/{{d.id}}"
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
                          <th lay-data="{field:'pileDevi', align:'center',width:120, sort: true}">桩位偏差</th>
                          <th lay-data="{field:'sediThiDevi', align:'center',width:150, sort: true}">沉渣厚度偏差</th>
                          <th lay-data="{field:'vertDevi', align:'center',width:150, sort: true}">垂直度偏差</th>
                          <th lay-data="{field:'holeDepthDevi', align:'center',width:150, sort: true}">成孔深度偏差</th>
                          <th lay-data="{field:'aperDevi', align:'center',width:120, sort: true}">孔径偏差</th>
                          <th lay-data="{field:'mudPropDevi', align:'center',width:120, sort: true}">泥浆比重</th>
                          <th lay-data="{field:'mudSurfDevi', align:'center',width:150, sort: true}">泥浆面标高偏差</th>
                          <th lay-data="{field:'rebarDevi', align:'center',width:180, sort: true}">钢筋笼安装深度偏差</th>
                          <th lay-data="{field:'conctre', align:'center',width:120, sort: true}">混凝土强度</th>
                          <th lay-data="{field:'fillingFactor', align:'center',width:150, sort: true}">混凝土充盈系数</th>
                          <th lay-data="{field:'pileTopDevi', align:'center',width:150, sort: true}">桩顶高程偏差</th>

                          <th lay-data="{field:'pilequalityCheckTime', align:'center',width:180, sort: true}">验收时间</th>
                          <th lay-data="{fixed: 'right',width:150, align:'center', toolbar: '#barDemo'}">操作</th>

                      </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${pageInfo.list}" var="pile">
                            <tr>
                                <td>

                                </td>

                                <td>
                                        ${pile.id}
                                </td>

                                <td>
                                        ${pile.struId}
                                </td>
                                <td>
                                        ${pile.pileDevi}
                                </td>
                                <td>
                                        ${pile.sediThiDevi}
                                </td>

                                <td>
                                        ${pile.vertDevi}
                                </td>

                                <td>
                                        ${pile.holeDepthDevi}
                                </td>

                                <td>
                                        ${pile.aperDevi}
                                </td>

                                <td>
                                        ${pile.mudPropDevi}
                                </td>

                                <td>
                                        ${pile.mudSurfDevi}
                                </td>

                                <td>
                                        ${pile.rebarDevi}
                                </td>

                                <td>
                                        ${pile.conctre}
                                </td>

                                <td>
                                        ${pile.fillingFactor}
                                </td>

                                <td>
                                        ${pile.pileTopDevi}
                                </td>



                                <td>
                                    <fmt:formatDate value="${pile.pilequalityCheckTime}"
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