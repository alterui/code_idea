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
    <link rel="stylesheet" href="${ctx}/static/js/public/jquery-2.1.1.js">
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
                <a ><font color="#228b22">梁质量验收标准设置</font></a>


                <div style="float: right">
                    其他质量验收标准设置&nbsp;&nbsp;<b></b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/bear/bearStandard">支座质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pier/pierStandard">墩台质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pile/pileStandard">桩质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/tower/towerStandard">锁塔质量验收标准</a>
                </div>
            </blockquote>

            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">
                    <form action="/page/beam/updateStandard" method="post">

                        <table class="layui-table">
                            <colgroup>
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">
                                <col width="60">

                            </colgroup>
                            <thead>
                            <tr>

                                <th>轴位偏差</th>
                                <th>断面偏差</th>
                                <th>顶面高程偏差</th>
                                <th>节段高差偏差</th>
                                <th>长度偏差</th>
                                <th>横坡偏差</th>
                                <th>预埋件位置偏差</th>
                                <th>平整度偏差</th>
                                <th>索管轴位偏</th>
                                <th>预应力筋轴位偏差</th>
                                <th>拉索索力</th>
                                <th>左右幅</th>


                            </tr>

                            </thead>
                            <tbody>


                            <tr>


                                <td>
                                    <input name="axialDevi" type="textarea" value="${beam.axialDevi}"
                                           style="width: 60px" required>
                                </td>
                                <td>
                                    <input name="sectionDevi" type="textarea" value="${beam.sectionDevi}"
                                           style="width: 60px" required>
                                </td>

                                <td>
                                    <input name="topElevDevi" type="textarea" value="${beam.topElevDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="segmHeightDevi" type="textarea" value="${beam.segmHeightDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="heightDevi" type="textarea" value="${beam.heightDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="crossSlopeDevi" type="textarea" value="${beam.crossSlopeDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="embePartsDevi" type="textarea" value="${beam.embePartsDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="smooDevi" type="textarea" value="${beam.smooDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="cableTubeAxisDevi" type="textarea" value="${beam.cableTubeAxisDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="prestTendDevi" type="textarea" value="${beam.prestTendDevi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="cableTensi" type="textarea" value="${beam.cableTensi}"
                                           style="width: 60px" required>

                                </td>

                                <td>
                                    <input name="bridgeSite" type="textarea" value="${beam.bridgeSite}"
                                           style="width: 60px" required>

                                </td>

                            </tr>

                            <tr>

                                <td colspan="13">

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