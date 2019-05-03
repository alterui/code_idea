<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/4/9
  Time: 17:26
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
    <link rel="stylesheet" href="${ctx}/font-awesome/css/font-awesome.min.css">

    <script src="${ctx}/static/js/public/jquery-2.1.1.js"></script>
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
                window.location.href = "/deleteUser/" + id;
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
                                url: '/deleteUserMore',
                                type:'post',
                                dataType:'json',
                                data:"id="+delList,
                                success:function (res) {

                                    if(res.length==0){
                                        window.location.href = "/showUser";
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
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;<font color="#228b22"><a href="/showUser">用户列表</a></font>
                  </blockquote>

            <!-- 搜索框 -->
            <div class="layui-tab">
                <form action="/searchUser" method="post">
                    <button class="layui-btn" style=" float: right">搜索</button>
                    <input type="text" value="${search}" name="search" style="margin-right: 6px; float: right " required
                           placeholder="请输入用户姓名搜索" class="layui-input">
                </form>

            </div>


            <!-- 功能按钮 -->
            <div class="demoTable">

                <a href="/register" class="layui-btn layui-btn-mini">增加用户</a>
                <button class="layui-btn layui-btn-danger" data-type="delCheckData">删除选中</button>

            </div>

            <script type="text/html" id="barDemo">

                <a href="/editUser/{{d.id}}"
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

                    <th lay-data="{field:'userName', align:'center',sort: true}">用户名</th>
                    <th lay-data="{field:'fullName', align:'center',sort: true}">姓名</th>
                    <th lay-data="{field:'role', align:'center', sort: true}">角色</th>

                    <th lay-data="{fixed: 'right',width:160,  align:'center', toolbar: '#barDemo'}">操作</th>


                </tr>
                </thead>
                <tbody>

                <c:forEach items="${pageInfo.list}" var="user">
                    <tr>


                        <td>


                        </td>

                        <td>
                                ${user.id}
                        </td>

                        <td>
                                ${user.userName}
                        </td>

                        <td>
                                ${user.fullName}
                        </td>

                        <td>

                            <!--  0表示普通用户，1表示管理员用户-->
                            <c:choose>

                                <c:when test="${user.permission==0}">
                                    <b>承包人</b>
                                </c:when>

                                <c:when test="${user.permission==1}">
                                    <b>总监</b>
                                </c:when>


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
