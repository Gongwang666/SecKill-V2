require.config({
    baseUrl: 'assets/js/',
    shim: {
        'jquery.session': ['jquery']
    },
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
        event:{
            login:function () {
                $.post(URLS.LOGIN,{userName:'gw',passWord:'123'},function (result) {
                    if(result.status == 0){
                        $( location ).attr("href", URLS.HOME);
                    }else{
                        alert(result.msg);
                    }
                },'json');

            }
        },
        pageInit: function () {

        },
    };

    viewModel.pageInit();
    ko.applyBindings(viewModel);
    window.viewModel = viewModel;
});