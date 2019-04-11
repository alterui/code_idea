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
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    </script>
</head>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <div >
                <style>
                    .div-height{ width:100px; height:35px}


                  .center {
                      text-align: center;



                  }

                </style>
               <%-- <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">所有商品</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;">列表一</a></dd>
                            <dd><a href="javascript:;">列表二</a></dd>
                            <dd><a href="javascript:;">列表三</a></dd>
                            <dd><a href="">超链接</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">解决方案</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;">列表一</a></dd>
                            <dd><a href="javascript:;">列表二</a></dd>
                            <dd><a href="">超链接</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="">云市场</a></li>
                    <li class="layui-nav-item"><a href="">发布商品</a></li>
                </ul>--%>

            </div>
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">质量安全</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${ctx}/page/crudPage/beamCrudPage.jsp">梁质量验收数据</a></dd>
                        <dd><a href="${ctx}/page/bear/show">支座质量验收数据</a></dd>
                        <dd><a href="${ctx}/page/crudPage/pierCrudPage.jsp">墩台质量验收数据</a></dd>
                        <dd><a href="${ctx}/page/crudPage/pileCrudPage.jsp">桩质量验收数据</a></dd>
                        <dd><a href="${ctx}/page/crudPage/towerCrudPage.jsp">索塔质量验收数据</a></dd>
                    </dl>
                </li>


                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">环保安全</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${ctx}/page/apply/show">报审申请表</a></dd>
                        <dd><a href="javascript:;">环境保证体系报审表</a></dd>
                        <dd><a href="javascript:;">环保施工技术方案报审表</a></dd>
                        <dd><a href="javascript:;">环保条件验收申请表</a></dd>
                    </dl>
                </li>



            </ul>
        </div>
    </div>
