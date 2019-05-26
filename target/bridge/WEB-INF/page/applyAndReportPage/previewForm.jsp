<%--
  Created by IntelliJ IDEA.预览页面
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

            <%--<blockquote class="layui-elem-quote">
                当前位置&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;<a href="/page/beam/show"><font color="#228b22">梁质量数据</font></a>
            </blockquote>--%>

            <div class="layui-tab">


             <div class="layui-tab layui-tab-card">

                <span id="print">
                    <div align="center" >
                     <table  class="layui-table" style="width: 600px;" >
                         <tr>
                             <th colspan="4">
                                 <center><b><font size="6">${apply.formName}</font></b></center>
                             </th>

                         </tr>

                         <tr style="text-align: center">
                             <th style="text-align: center">

                                 <b>承包单位</b>
                             </th>
                             <td>

                                 ${apply.contractorUnit}

                             </td>

                             <th style="text-align: center">
                                 <b>标段号</b>
                             </th>

                             <td>
                                 ${apply.bidNum}


                             </td>

                         </tr>


                         <tr style="text-align: center">
                             <th style="text-align: center">

                                 <b>监理单位</b>
                             </th>
                             <td>

                                 ${apply.supervision}

                             </td>

                             <th style="text-align: center">
                                 <b>编&nbsp;&nbsp;号</b>
                             </th>

                             <td>
                                 ${apply.serialNum}


                             </td>

                         </tr>

                         <tr style="height: 200px;width: 580px;" >
                             <td colspan="4" style="word-break:break-all">
                                 致&nbsp;&nbsp;${apply.director}&nbsp;&nbsp;：<br>
                                 &nbsp;&nbsp;现报上&nbsp;&nbsp;${apply.projectName}&nbsp;&nbsp;环境应急预案，详细说明如下，请予审查和批准。
                                 <br>
                                 <br>

                                    <p style="width: 580px">
                                     &nbsp;&nbsp;&nbsp;&nbsp;   ${apply.directorView}

                                    </p>





                                 <br>
                                 <br>
                                 <br>
                                 <br>
                                 <br>
                                 <div align="right">
                                     承包人：${apply.contractorName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：&nbsp;&nbsp; <fmt:formatDate value="${apply.applicationTime}" pattern="yyyy-MM-dd "/>

                                 </div>

                             </td>

                         </tr>


                         <tr style="height: 200px;width: 580px;">
                             <td colspan="4" style="word-break:break-all">
                                 总监意见：<br>
                                 <br>
                                  <p style="width: 580px">
                                      &nbsp;&nbsp;&nbsp;&nbsp;${apply.centerView}

                                  </p>
                                 <br>
                                 <br>
                                 <div align="right">
                                        签字：${apply.centerName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：&nbsp;&nbsp; <fmt:formatDate value="${apply.centerReplyTime}" pattern="yyyy-MM-dd "/>

                                 </div>

                             </td>


                         </tr>


                         </tr>
                         <br>






                     </table>
                    </div>

            </span>

                 <div align="center">

                     <a href="javascript:printme()"  class="layui-btn layui-btn-mini">打印</a>
                     <a href="/page/apply/show"  class="layui-btn layui-btn-danger layui-btn-mini">关闭</a>

                     <script language="javascript">
                         function printme() {
                             document.body.innerHTML=document.getElementById('print').innerHTML;
                             window.print();
                         }
                     </script>
                 </div>
             </div>
            </div>
          </div>
        </div>
    </div>
</div>

</body>
</html>