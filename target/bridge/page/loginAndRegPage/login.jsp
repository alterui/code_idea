<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/3/25
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户登录</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" >
    <link rel="stylesheet" href="${ctx}/static/layui/layui.all.js" >
    <link rel="stylesheet" href="${ctx}/static/layui/layui.js" >
    <link rel="stylesheet" href="${ctx}/static/css/style.css" >
    <style type="text/css">
        body{
            font-family: "Microsoft YaHei", Helvetica, Arial, Lucida Grande, Tahoma, sans-serif;
            background-image: url('${ctx}/static/img/bg.jpg');
            background-size:cover
        }
    </style>
</head>

<body>

<div class="login-main">
    <header class="layui-elip">

        <c:choose>
            <c:when test="${msg!=null}">
                <font size="3" color="red">${msg}</font>
            </c:when>
            <c:otherwise>
                用户登录
            </c:otherwise>
        </c:choose>


    </header>
    <form class="layui-form" method="post" action="/login">
        <div class="layui-input-inline">
            <input type="text" name="userName" required lay-verify="required" placeholder="用户名"  placeholder="请输入用户名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="密码" placeholder="请输入密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button lay-submit lay-filter="login" class="layui-btn">登录</button>
        </div>
        <hr/>
        <!--<div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-primary">QQ登录</button>
        </div>
        <div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-normal">微信登录</button>
        </div>-->
        <p><a href="${ctx}/page/loginAndRegPage/register.jsp" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form>
</div>

<%--<script src="${ctx}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form','layer','jquery'], function () {

        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
        form.on('submit(login)',function (data) {
            // console.log(data.field);
            $.ajax({
                url:'login',
                data:data.field,
                dataType:'text',
                type:'post',
                success:function (data) {
                    if (data == '1'){
                        location.href = "${ctx}/page/index.jsp";
                    }else{
                        layer.msg('登录名或密码错误');
                    }
                }
            })
            return false;
        })

    });
</script>--%>
</body>
</html>