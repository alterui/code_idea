<%--
  Created by IntelliJ IDEA.承包人回执单填写
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



    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

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
                    width: 100% !important;
                }

                .layui-input1 {
                    display: inline-block;
                    width: 30% !important;
                }
            </style>

            <blockquote class="layui-elem-quote">
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;<a><font color="#228b22">表单填写</font></a>
            </blockquote>

            <div class="layui-tab">
                <form action="/page/apply/add" method="post"  >

                <div class="layui-tab layui-tab-card">

                <span id="print">
                    <div align="center" >
                     <table  class="layui-table" style="width: 700px;" >
                         <tr>
                             <th colspan="4">
                                 <center>
                                     请选择表名：
                                     <div class="layui-input-inline">
                                        <select name="formName" required >

                                                <option value="环境保证体系报审表" selected="">环境保证体系报审表</option>
                                                <option value="环境风险应急预案报审表">环境风险应急预案报审表</option>
                                                <option value="环保施工技术方案报审表">环保施工技术方案报审表</option>
                                                <option value="环保条件验收申请表">环保条件验收申请表</option>
                                        </select>
                                    </div>


                                 </center>
                             </th>

                         </tr>

                         <tr style="text-align: center">
                             <th style="text-align: center">

                                 <b>承包单位</b>
                             </th>
                             <td>
                                 <input name="contractorUnit" type="textarea"  required class="layui-input">

                             </td>

                             <th style="text-align: center">

                                 <b>标段号</b>
                             </th>

                             <td>
                                 <input name="bidNum" type="textarea" required class="layui-input">


                             </td>

                         </tr>



                         <tr style="text-align: center">
                             <th style="text-align: center">

                                 <b>监理单位</b>
                             </th>
                             <td>

                                 <input name="supervision" type="textarea" required  class="layui-input">

                             </td>

                             <th style="text-align: center">
                                 <b>编&nbsp;&nbsp;号</b>
                             </th>

                             <td>
                                <input name="serialNum" type="textarea" required  class="layui-input">


                             </td>

                         </tr>

                         <tr style="height: 200px">
                             <td colspan="4">
                                 致
                                  <input name="director" type="textarea" required placeholder="此处填写总监办名称"  class="layui-input1">

                                 ：<br>
                                 现报上
                                 <input name="projectName" type="textarea" required placeholder="此处填写工程名称" class="layui-input1">
                                 环境应急预案，详细说明如下，请予审查和批准。
                                 <br>
                                 <br>
                                 <textarea name="directorView" required lay-verify="required" placeholder="请输入详细说明" class="layui-textarea"></textarea>

                                 <br>


                             </td>

                         </tr>



                         <br>






                     </table>
                    </div>

            </span>

                 <div align="center">

                     <button class="layui-btn layui-btn-mini" type="submit">保存</button>
                     <a href="/page/apply/show"  class="layui-btn layui-btn-danger layui-btn-mini">关闭</a>

                 </div>
             </div>
                </form>
            </div>
          </div>
        </div>
    </div>
</div>

</body>
</html>