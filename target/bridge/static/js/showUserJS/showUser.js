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
        window.location.href = "/deleteUser/" + id;
    })
}

layui.use('table', function(){
    var table = layui.table;

    //转换静态表格
    table.init('demo', {

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
                        url: '/deleteUserMore',
                        type:'post',
                        dataType:'json',
                        data:"id="+delList,
                        success:function (res) {

                            if(res.length==0){
                                window.location.href = "/showUser";
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
