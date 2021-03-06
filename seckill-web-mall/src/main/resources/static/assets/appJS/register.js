require.config({
    baseUrl: 'assets/js/',
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "constants":["constants"],
        "text":["https://cdn.bootcss.com/require-text/2.0.12/text.min"]
    }
})

require(['jquery', 'knockout','AmazeUI','constants'],function ($,ko) {
    var viewModel = {
        pageInit:function () {
            $(function () {
                $('#doc-my-tabs').tabs();
            })
        },
        event:{
            doRegister:function () {
                var email = $('#email').val();
                var pw = $('#pw').val();
                var sure = $('#sure').val();
                if(email==""||pw==""||sure==""){
                    alert("信息输入不完整!");
                    return ;
                }
                if(!pw==sure){
                    alert("两次输入的密码不同");
                    return ;
                }
                $.post(URLS.DO_REGISTER,{userName:email,passWord:pw},function (result) {
                    alert(result.msg);
                },'json');
            }
        }
    };

    viewModel.pageInit();
    ko.applyBindings(viewModel);
    window.viewModel = viewModel;
})