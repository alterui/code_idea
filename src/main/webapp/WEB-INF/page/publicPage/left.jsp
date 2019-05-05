<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/3/25
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />

    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" >
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/layui/layui.js"></script>

    <script type="text/javascript">
       /* //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });*/
    </script>
</head>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
           <%-- <div >
                <style>
                    .div-height{ width:100px; height:35px}


                  .center {
                      text-align: center;



                  }

                </style>


            </div>--%>

            <c:if test="${permission==0}">
                <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">质量安全</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/page/beam/show">梁质量验收数据</a></dd>
                            <dd><a href="${ctx}/page/bear/show">支座质量验收数据</a></dd>
                            <dd><a href="${ctx}/page/pier/show">墩台质量验收数据</a></dd>
                            <dd><a href="${ctx}/page/pile/show">桩质量验收数据</a></dd>
                            <dd><a href="${ctx}/page/tower/show">索塔质量验收数据</a></dd>
                        </dl>
                    </li>


                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">环保安全</a>
                        <dl class="layui-nav-child">
                            <dd><a href="${ctx}/page/apply/show">环保检查报告</a></dd>

                        </dl>
                    </li>


                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">质量验收标准</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/page/beam/beamStandard">梁质量验收标准</a></dd>
                            <dd><a href="/page/bear/bearStandard">支座质量验收标准</a></dd>
                            <dd><a href="/page/pier/pierStandard">墩台质量验收标准</a></dd>
                            <dd><a href="/page/pile/pileStandard">桩质量验收标准</a></dd>
                            <dd><a href="/page/tower/towerStandard">索塔质量验收标准</a></dd>

                        </dl>
                    </li>
                </ul>
            </c:if>


            <c:if test="${permission==1}">
                <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">质量安全管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/page/beam">梁质量数据审核</a></dd>
                            <dd><a href="/page/bear">支座质量数据审核</a></dd>
                            <dd><a href="/page/pier">墩台质量数据审核</a></dd>
                            <dd><a href="/page/pile">桩质量数据审核</a></dd>
                            <dd><a href="/page/tower">索塔质量数据审核</a></dd>
                        </dl>
                    </li>


                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">环保安全管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/page/apply/showCheck">环保检查报告审核</a></dd>

                        </dl>
                    </li>

                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">质量验收标准</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/page/beam/beamStandard">梁质量验收标准</a></dd>
                            <dd><a href="/page/bear/bearStandard">支座质量验收标准</a></dd>
                            <dd><a href="/page/pier/pierStandard">墩台质量验收标准</a></dd>
                            <dd><a href="/page/pile/pileStandard">桩质量验收标准</a></dd>
                            <dd><a href="/page/tower/towerStandard">索塔质量验收标准</a></dd>

                        </dl>
                    </li>




                </ul>
            </c:if>


        </div>
    </div>
