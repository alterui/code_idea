//JavaScript代码区域
layui.use('element', function () {
    var element = layui.element;

});

layui.use('form', function(){
    var form = layui.form;


});

function addUser() {
    var $ = layui.jquery;

    $.ajax({
        type: "POST",   //提交的方法
        url:"/reg", //提交的地址
        data:$('#userForm').serialize(),// 序列化表单值
        dataType: "json",
        async: false,

        success: function(data) {  //成功


            if (data.code==0) {//不存在
                alert("保存成功");
                window.location.href = "/showUser";
            }
            if(data.code==1) {
                alert("用户名已经存在，请重新输入");
            }

        },
        error : function(errorMsg) {
            //请求失败时执行该函数
            alert("请求失败");

        }
    });

}
