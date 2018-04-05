require.config({
    baseUrl: 'assets/js/',
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "quick_links": "quick_links",
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "jquery.imagezoom":["jquery.imagezoom.min"],
        "jquery.flexslider":["jquery.flexslider"],
        "list":["list"],
        "magnifier":["amazeui.magnifier.min"],
        "constants":["constants"],
        "text":["https://cdn.bootcss.com/require-text/2.0.12/text.min"]
    }
})


require(['jquery', 'knockout', 'quick_links', 'AmazeUI','jquery.imagezoom','jquery.flexslider','list','constants'],function ($,ko) {

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
            //注册组件
            viewModel.register();
            //图片轮播
            $('.flexslider').flexslider({
                animation: "slide",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });

            //初始化图片放大镜
            $(document).ready(function() {
                $(".jqzoom").imagezoom();
                $("#thumblist li a").click(function() {
                    $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
                    $(".jqzoom").attr('src', $(this).find("img").attr("mid"));
                    $(".jqzoom").attr('rel', $(this).find("img").attr("big"));
                });
            });

        }
    };
    viewModel.pageInit();
    ko.applyBindings(viewModel);

});