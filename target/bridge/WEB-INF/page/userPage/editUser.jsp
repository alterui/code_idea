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


   <%-- <script src="${ctx}/static/js/public/jquery-2.1.1.js"></script>--%>
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>


    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });

        layui.use('form', function(){
            var form = layui.form;


        });


        function editUser() {
            var $ = layui.jquery;

            $.ajax({
                type: "POST",   //提交的方法
                url:"${ctx}/updateUser", //提交的地址
                data:$('#userForm').serialize(),// 序列化表单值
                dataType: "json",
                async: false,

                success: function(data) {  //成功


                    if (data.code==0) {//不存在
                        alert("修改成功");
                        window.location.href = "/showUser";
                    }
                    if(data.code==1) {
                        alert("用户名已经存在，请重新输入");
                    }

                },
                error : function(errorMsg) {
                //请求失败时执行该函数
                alert("请求失败");

            }
            });

        }




    </script>


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">




            <blockquote class="layui-elem-quote">
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a >修改用户</a>

            </blockquote>
            <br>




            <form class="layui-form"   id="userForm">

                   <div class="layui-form-item">
                    <label class="layui-form-label">用户名 <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-inline">
                        <input type="hidden" name="id" value="${user.id}">
                        <input value="${user.userName}" type="text" name="userName" id="userName" required
                               lay-verify="userName"
                               autocomplete="off" class="layui-input" >
                    </div>


                </div>






                <div class="layui-form-item">
                    <label class="layui-form-label">姓名 <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-inline">
                        <input  value="${user.fullName}" type="text" name="fullName"  required
                               placeholder="" autocomplete="off" min="2" max="10"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>




                <div class="layui-form-item">
                    <label class="layui-form-label">密码 <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-inline">
                        <input value="${user.password}" type="password" name="password"  id="userPass" required
                               lay-verify="userPass"
                               autocomplete="off" class="layui-input" min="3" max="20">
                    </div>
                    <%--<div class="layui-form-mid layui-word-aux"></div>--%>
                </div>



                <div class="layui-form-item">
                    <label class="layui-form-label">角色 <span style="color: #FF5722; ">*</span></label>
                    <div class="layui-input-block">
                        <input type="radio" name="role" value="承包人" title="承包人" <c:if test="${user.permission eq 0}"> checked</c:if>>
                        <input type="radio" name="role" value="总监" title="总监" <c:if test="${user.permission eq 1}"> checked</c:if>>
                    </div>
                </div>






                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn"  type="button" onclick="editUser()" id="submit-btn">保存</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>

                    </div>
                </div>


            </form>

        </div>







        </div></div></div>
</body>
</html>