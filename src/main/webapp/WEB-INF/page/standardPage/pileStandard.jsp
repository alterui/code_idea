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
                <a ><font color="#228b22">桩质量验收标准设置</font></a>

<%--
                <div style="float: right">
                    其他质量验收标准设置&nbsp;&nbsp;<b></b>&nbsp;&nbsp;
                    <a  class="layui-this" href="/page/beam/beamStandard">梁质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/bear/bearStandard">支座质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pier/pierStandard">墩台质量验收标准</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/tower/towerStandard">锁塔质量验收标准</a>
                </div>--%>
            </blockquote>

            <div class="layui-tab">


                <div class="layui-tab layui-tab-card">
                    <form action="/page/pile/updateStandard" method="post">

                        <table class="layui-table">
                            <colgroup>
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="100">


                            </colgroup>
                            <thead>
                            <tr>

                                <th>桩位偏差</th>
                                <th>沉渣厚度偏差</th>
                                <th>垂直度偏差</th>
                                <th>成孔深度偏差</th>
                                <th>孔径偏差</th>
                                <th>泥浆比重</th>
                                <th>泥浆面标高偏差</th>
                                <th>钢筋笼安装深度偏差</th>
                                <th>混凝土强度</th>
                                <th>混凝土充盈系数</th>
                                <th>桩顶高程偏差</th>


                            </tr>
                            </thead>
                            <tbody>


                            <tr>


                                <td>
                                    <input name="pileDevi" type="textarea" value="${pile.pileDevi}"
                                           style="width: 70px" required>
                                </td>
                                <td>
                                    <input name="sediThiDevi" type="textarea" value="${pile.sediThiDevi}"
                                           style="width: 70px" required>
                                </td>

                                <td>
                                    <input name="vertDevi" type="textarea" value="${pile.vertDevi}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="holeDepthDevi" type="textarea" value="${pile.holeDepthDevi}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="aperDevi" type="textarea" value="${pile.aperDevi}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="mudPropDevi" type="textarea" value="${pile.mudPropDevi}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="mudSurfDevi" type="textarea" value="${pile.mudSurfDevi}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="rebarDevi" type="textarea" value="${pile.rebarDevi}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="conctre" type="textarea" value="${pile.conctre}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="fillingFactor" type="textarea" value="${pile.fillingFactor}"
                                           style="width: 70px" required>

                                </td>

                                <td>
                                    <input name="pileTopDevi" type="textarea" value="${pile.pileTopDevi}"
                                           style="width: 70px" required>

                                </td>



                            </tr>

                            <tr>

                                <td colspan="11">

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