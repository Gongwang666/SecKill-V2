require.config({
    baseUrl: 'assets/js/',
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "quick_links": "quick_links",
        "script":"script",
        "constants":["constants"],
        "text":["https://cdn.bootcss.com/require-text/2.0.12/text.min"]
    }
})

require(['jquery', 'knockout', 'quick_links', 'AmazeUI',"script",'constants'],function ($,ko) {
    var viewModel = {
        register:function () {
            //注册头部导航条组件
            ko.components.register('head-nav-bar', {
                require: '../appJS/modules/head_nav_bar'
            });
            //注册搜索框组件
            ko.components.register('search-bar', {
                require: '../appJS/modules/search_bar'
            });
            //注册分类菜单组件
            ko.components.register('category-bar', {
                require: '../appJS/modules/category_bar'
            });
        },
        pageInit:function () {
            viewModel.register();
        }
    };
    viewModel.pageInit();
    ko.applyBindings();
});