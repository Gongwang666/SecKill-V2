require.config({
    baseUrl: 'assets/js/',
    shim: {
        'jquery.session': ['jquery']
    },
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "jquery.session":"jquery.session",
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "constants":["constants"],
        "text":["https://cdn.bootcss.com/require-text/2.0.12/text.min"],
        "css":["https://cdn.bootcss.com/require-css/0.1.10/css"],
        "address":["address"]
    }
})

require(['jquery', 'knockout','jquery.session', 'AmazeUI','constants','address'],function ($,ko) {
    var viewModel = {
        userInfo:ko.observable(),
        orderId:ko.observable(),
        register:function () {
            //注册头部导航条组件
            ko.components.register('head-nav-bar', {
                require: '../appJS/modules/head_nav_bar'
            });
            //注册搜索框组件
            ko.components.register('search-bar', {
                require: '../appJS/modules/search_bar'
            });
        },
        pageInit:function () {
            viewModel.register();
            viewModel.getUserInfo();
            viewModel.orderId($.session.get("orderId"));
        },
        getUserInfo:function(){
            $.ajax({
                url: URLS.GET_SESSION_USER_INFO,
                contentType: "application/json;charset=utf-8",
                type: 'POST', //GET
                async: false,    //或false,是否异步
                data: {},
                timeout: 5000,    //超时时间
                dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success: function (result) {
                    console.log(result);
                    viewModel.userInfo(result);
                    return result;
                },
                error: function (xhr, textStatus) {
                    console.log(xhr)
                },
                complete: function () {
                    console.log('结束');
                }
            });
        },
        getOrderInfo:function () {
            
        }
    };

    viewModel.pageInit();
    ko.applyBindings(viewModel);
    window.viewModel = viewModel;
})