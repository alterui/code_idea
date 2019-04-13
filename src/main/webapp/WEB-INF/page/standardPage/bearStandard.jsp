<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/4/7
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="../adminPage/top.jsp"%>
<%@include file="../adminPage/left.jsp"%>
<%@include file="../adminPage/bottom.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/css/back.css">
    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/static/js/jquery-2.1.1.js">
    <link rel="stylesheet" href="${ctx}/static/js/back.bak.js">
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
                    width: 15% !important;
                }




            </style>

            <blockquote class="layui-elem-quote">
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                <a ><font color="#228b22">支座质量验收标准设置</font></a>


                <div style="float: right">
                    其他质量验收标准设置&nbsp;&nbsp;<b></b>&nbsp;&nbsp;
                    <a  class="layui-this" href="/page/beam/beamStandard">梁质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/bear/bearStandard">支座质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pier/pierStandard">墩台质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="">桩质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="">锁塔质量验收标准</a>
                </div>
            </blockquote>

            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">
                    <form action="/page/bear/updateStandard" method="post">

                        <table class="layui-table">
                            <colgroup>

                                <col width="200">
                                <col width="200">
                                <col width="200">
                                <col width="200">
                                <col width="200">
                                <col width="200">
                                <col width="200">
                            </colgroup>
                            <thead>
                            <tr>

                                <th>上座板中心纵向错动量</th>
                                <th>下座板中心横向错动量</th>
                                <th>同端支座中心横向距离</th>
                                <th>同一梁端亮支座相对高差</th>
                                <th>每一支座的边缘高差</th>
                                <th>上下座板十字线扭转</th>
                                <th>活动支座的纵向错动量</th>


                            </tr>
                            </thead>
                            <tbody>


                            <tr>

                                <td>
                                    <input name="upCentVert" type="textarea" value="${bear.upCentVert}"
                                           style="width: 120px" required>
                                </td>
                                <td>
                                    <input name="downCentTran" type="textarea" value="${bear.downCentTran}"
                                           style="width: 120px" required>
                                </td>

                                <td>
                                    <input name="sameCentVert" type="textarea" value="${bear.sameCentVert}"
                                           style="width: 120px" required>

                                </td>

                                <td>
                                    <input name="sameRela" type="textarea" value="${bear.sameRela}"
                                           style="width: 120px" required>

                                </td>

                                <td>
                                    <input name="edgeHeig" type="textarea" value="${bear.edgeHeig}"
                                           style="width: 120px" required>

                                </td>

                                <td>
                                    <input name="crossLineTors" type="textarea" value=" ${bear.crossLineTors}"
                                           style="width: 120px" required>

                                </td>

                                <td>
                                    <input name="actiVert" type="textarea" value="${ bear.actiVert}"
                                           style="width: 120px" required>

                                </td>


                            </tr>

                            <tr>

                                <td colspan="7">

                                    <div style="width: 216px; margin: 0; text-align:right; float:right" ;>


                                        <button  class="layui-btn layui-btn-mini" type="submit">保存
                                        </button>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>