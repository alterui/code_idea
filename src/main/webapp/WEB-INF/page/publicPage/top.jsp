<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/3/25
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>南京浦仪大桥质量环保子系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui.js">

   <%-- <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>--%>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">浦仪大桥信息协同平台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">

            <%--<li class="layui-nav-item">
                <a href="/page/beam/beamStandard">质量验收标准</a>
                <dl class="layui-nav-child">
                    <dd><a href="/page/beam/beamStandard">梁质量验收标准</a></dd>
                    <dd><a href="/page/bear/bearStandard">支座质量验收标准</a></dd>
                    <dd><a href="/page/pier/pierStandard">墩台质量验收标准</a></dd>
                    <dd><a href="/page/pile/pileStandard">桩质量验收标准</a></dd>
                    <dd><a href="/page/tower/towerStandard">索塔质量验收标准</a></dd>

                </dl>
            </li>
--%>

            <li class="layui-nav-item">
                <a href="javascript:;">质量可视化管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/page/beam/showChart">梁验收合格折线图</a></dd>
                    <dd><a href="/page/bear/showChart">支座验收合格折线图</a></dd>
                    <dd><a href="/page/pier/showChart">墩台验收合格折线图</a></dd>
                    <dd><a href="/page/pile/showChart">桩验收合格折线图</a></dd>
                    <dd><a href="/page/tower/showChart">索塔验收合格折线图</a></dd>

                </dl>

            </li>

          <%--  <li class="layui-nav-item">
                <a href="javascript:;">环保管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="/page/apply/showCheck">检查报告审核</a></dd>
                </dl>
            </li>--%>


            <c:if test="${permission==1}">
                <li class="layui-nav-item">
                    <a href="/showUser">用户管理</a>

                </li>
            </c:if>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/static/img/tx.jpg" class="layui-nav-img">
                    ${userName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/logout">退出</a></li>
        </ul>
    </div>
