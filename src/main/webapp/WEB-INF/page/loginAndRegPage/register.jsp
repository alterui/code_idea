<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/3/25
  Time: 10:06
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
    <title>注册页</title>
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

<div class="login-main" >
    <header class="layui-elip" style="width: 82%">
        <c:choose>
            <c:when test="${msg!=null}">
                <font size="3" color="red">${msg}</font>
            </c:when>
            <c:otherwise>
                用户注册
            </c:otherwise>
        </c:choose>


    </header>

    <!-- 表单选项 -->
    <form class="layui-form" action="/reg" method="post">
        <div class="layui-input-inline">
            <!-- 用户名 -->
            <div class="layui-inline" style="width: 85%">
                <input type="text"  name="userName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="ri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="wr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>

        <div class="layui-input-inline">
            <!-- 用户名 -->
            <div class="layui-inline" style="width: 85%">
                <input type="text"  name="fullName" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>

        </div>


        <!-- 密码 -->
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="password" id="pwd" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="pri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="pwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>
        <!-- 确认密码 -->
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="password" id="rpwd" name="repassword" required  lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="rpri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="rpwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>


        <div class="layui-input-inline login-btn" style="width: 85%">
            <button type="submit" lay-submit lay-filter="sub" class="layui-btn">注册</button>
        </div>
        <hr style="width: 85%" />
        <p style="width: 85%"><a href="/" class="fl">已有账号？立即登录</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form>
</div>


<%--<script src="${ctx}/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form','jquery','layer'], function () {
        var form   = layui.form;
        var $      = layui.jquery;
        var layer  = layui.layer;
        //添加表单失焦事件
        //验证表单
        $('#user').blur(function() {
            var user = $(this).val();
            $.ajax({
                url:'checkUser',
                type:'post',
                dataType:'text',
                data:{user:user},
                //验证用户名是否可用
                success:function(data){
                    if (data == 1) {
                        $('#ri').removeAttr('hidden');
                        $('#wr').attr('hidden','hidden');
                    } else {
                        $('#wr').removeAttr('hidden');
                        $('#ri').attr('hidden','hidden');
                        layer.msg('当前用户名已被占用! ')

                    }

                }
            })

        });

        // you code ...
        // 为密码添加正则验证
        $('#pwd').blur(function() {
            var reg = /^[\w]{6,12}$/;
            if(!($('#pwd').val().match(reg))){
                //layer.msg('请输入合法密码');
                $('#pwr').removeAttr('hidden');
                $('#pri').attr('hidden','hidden');
                layer.msg('密码长度至少为6位');
            }else {
                $('#pri').removeAttr('hidden');
                $('#pwr').attr('hidden','hidden');
            }
        });

        //验证两次密码是否一致
        $('#rpwd').blur(function() {
            if($('#pwd').val() != $('#rpwd').val()){
                $('#rpwr').removeAttr('hidden');
                $('#rpri').attr('hidden','hidden');
                layer.msg('两次输入密码不一致!');
            }else {
                $('#rpri').removeAttr('hidden');
                $('#rpwr').attr('hidden','hidden');
            };
        });

        //
        //添加表单监听事件,提交注册信息
        form.on('submit(sub)', function() {
            $.ajax({
                url:'reg',
                type:'post',
                dataType:'text',
                data:{
                    user:$('#user').val(),
                    pwd:$('#pwd').val(),
                },
                success:function(data){
                    if (data == 1) {
                        layer.msg('注册成功');
                        ///location.href = "login.html";
                    }else {
                        layer.msg('注册失败');
                    }
                }
            })
            //防止页面跳转
            return false;
        });

    });
</script>--%>
</body>
</html>