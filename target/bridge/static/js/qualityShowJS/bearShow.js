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




//删除表里面的数据
function deleteData(id) {
    layer.confirm('真的要删除吗？',function (index) {
        window.location.href = "/page/bear/delete/" + id;
    })
}

layui.use('table', function(){
    var table = layui.table;

    //转换静态表格
    table.init('demo', {
        limit: 150,
        page: false
    });
});
layui.use('table', function () {
    var table = layui.table;
    var $ = layui.$, active = {
        reload: function () {
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('tableDate', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    id: demoReload.val()
                }
            });
        }
    };


    var $ = layui.$, active = {
        delCheckData:function () {
            var checkStatus = table.checkStatus('tableDate')
                ,data = checkStatus.data
                ,delList=[];
            data.forEach(function(n){
                delList.push(n.id);
            });


            if(delList!=''){
                layer.confirm('真的删除这'+data.length+'行吗？', function(index){
                    $.ajax({
                        url: '/page/bear/deleteMore',
                        type:'post',
                        dataType:'json',
                        data:"id="+delList,
                        success:function (res) {

                            if(res.length==0){
                                window.location.href = "/page/bear/show/";
                            }else{
                                layer.msg('删除失败');
                            }
                        },
                        'error':function () {
                            layer.msg('系统错误');
                        }
                    })
                })
            }else{
                layer.msg("请选择行");
            };
        }
    };

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});




function getBearSearch(){

    var start = $("#start").val();
    var end = $("#end").val();

    if (start=="" || end=="") {
        alert("起止时间不能为空！");
        return false;
    }
    //结束时间不能比开始时间小。
    var startTime = new Date(start).getTime();
    var endTime = new Date(end).getTime();
    if (startTime>endTime){
        alert("开始时间不能大于结束时间！");
        return false;
    }

    window.location.href = "/page/bear/getSearch?start=" + start + " &end=" + end + "";

}
