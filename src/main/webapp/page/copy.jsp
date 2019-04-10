
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="adminPage/top.jsp"%>
<%@include file="adminPage/left.jsp"%>
<%@include file="adminPage/bottom.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <c:set var="ctx" value="${pageContext.request.contextPath}" />
        <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" >
        <script src="${ctx}/static/layui/layui.all.js"></script>
        <script src="${ctx}/static/layui/layui.js"></script>
        <script type="text/javascript">
            //JavaScript代码区域
            layui.use('element', function(){
                var element = layui.element;

            });
        </script>
    </head>
    <body class="layui-layout-body">
        <div class="layui-layout layui-layout-admin">

            <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                
            </div>
        </div>
        </div>


    </body>



</html>