<%--
  Created by IntelliJ IDEA.
  User: ALTERUI
  Date: 2019/4/8
  Time: 9:34
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
    <link href="${ctx}/static/css/lhgcalendar.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">

    <script src="${ctx}/static/js/public/jquery-2.1.1.js"></script>
    <script src="${ctx}/static/js/public/echarts.min.js"></script>
    <script src="${ctx}/static/layui/layui.all.js"></script>
    <script src="${ctx}/static/js/public/lhgcalendar.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/layui/layui.js"></script>
    <script src="${ctx}/static/js/back.bak.js"></script>


    <script type="text/javascript">
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });
        layui.use('laydate', function(){
            var laydate = layui.laydate;



            //墨绿主题
            laydate.render({
                elem: '#start'
                ,theme: 'molv'
            });

            //墨绿主题
            laydate.render({
                elem: '#end'
                ,theme: 'molv'
            });


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
                <a >墩台验收合格折线图</a>


                <div style="float: right">
                    位置跳转&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a  class="layui-this" href="/page/beam/showChart">梁验收合格折线图</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/bear/showChart">支座验收合格折线图</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/pile/showChart">桩验收合格折线图</a>&nbsp;&nbsp;<b>|</b>&nbsp;&nbsp;
                    <a class="layui-this" href="/page/tower/showChart">锁塔验收合格折线图</a>
                </div>

            </blockquote>




            <div align="center">
                开始时间&nbsp;&nbsp;<input  type="text" id="start" name="start">&nbsp;&nbsp;&nbsp;&nbsp;
                结束时间&nbsp;&nbsp;<input   type="text" id="end" name="end">&nbsp;&nbsp;&nbsp;&nbsp;
                <button  onclick="return getChart()"  class="layui-btn layui-btn-xs" type="submit">生成折线图</button>
            </div>
            <br><br><br>




            <!-- 开始绘制图表-->


            <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
            <div align="center">
            <div  id="main" style="width: 900px;height:450px;"></div>
            <script type="text/javascript">


                function getAjax() {

                    var myChart = echarts.init(document.getElementById('main'));
                    // 显示标题，图例和空的坐标轴
                    myChart.setOption({
                        title : {
                            text : '墩台质量验收合格率折线图'
                        },
                        tooltip : {},
                        legend : {
                            data : [ '合格率' ]
                        },
                        xAxis : {
                            data : []
                        },
                        yAxis : {},
                        series : [ {
                            name : '合格率',
                            type : 'line',
                            data : []
                        } ]
                    });

                    myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

                    var names = []; //X数组（实际用来盛放X轴坐标值）
                    var nums = []; //Y数组（实际用来盛放Y坐标值）

                    var start = $("#start").val();
                    var end = $("#end").val();



                    $.ajax({
                        type : "post",
                        async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                        url : "${ctx}/page/pier/getChart", //请求发送的路径
                        data : {"start": start, "end": end},
                        dataType : "json", //返回数据形式为json
                        success : function(result) {
                            //请求成功时执行该函数内容，result即为服务器返回的json对象


                            if(result.length==0){
                                //没有数据
                                alert("所选日期没有数据，请查询后再试");
                            }
                            if (result) {

                                for (var i = 0; i < result.length; i++) {

                                    names.push(result[i].checkTime); //挨个取出类别并填入类别数组
                                }
                                for (var i = 0; i < result.length; i++) {
                                    nums.push(result[i].passRate); //挨个取出销量并填入销量数组
                                }


                                myChart.hideLoading(); //隐藏加载动画
                                myChart.setOption({ //加载数据图表
                                    xAxis: {
                                        data: names
                                    },
                                    series: [{
                                        // 根据名字对应到相应的系列
                                        name: '合格率',
                                        data: nums
                                    }]
                                });

                            }

                        },
                        error : function(errorMsg) {
                            //请求失败时执行该函数
                            alert("图表请求数据失败!");
                            myChart.hideLoading();
                        }
                    });

                }


                function getChart(){



                    var start = $("#start").val();
                    var end = $("#end").val();

                    if (start=="" || end=="") {
                        alert("起止时间不能为空！");
                        return false;
                    }
                    //结束时间不能比开始时间小。
                    var startTime = new Date(start).getTime();
                    var endTime = new Date(end).getTime()

                    if (startTime>endTime){
                        alert("开始时间不能大于结束时间！");
                        return false;
                    }

                    getAjax();



                }

            </script>


            </div>
        </div>
    </div>
</div>


</body>
</html>