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



//更改为合格
function qualityData(id) {

    layer.confirm('您确定要修改吗？', function (index) {
        window.location.href = "/page/tower/updateQualified/" + id;

    });


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


    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});



function getTowerSearch(){

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

    window.location.href = "/page/tower/getHasQualitySearch?start=" + start + " &end=" + end + "";

}