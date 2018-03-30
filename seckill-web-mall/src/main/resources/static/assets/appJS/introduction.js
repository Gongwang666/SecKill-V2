require.config({
    baseUrl: 'assets/js/',
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "quick_links": "quick_links",
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "jquery.imagezoom":["jquery.imagezoom.min"],
        "jquery.flexslider":["jquery.flexslider"],
        "list":["list"]
    }
})


require(['jquery', 'knockout', 'quick_links', 'AmazeUI','jquery.imagezoom','jquery.flexslider','list'],function ($,ko) {
    var viewModel = {
        pageInit:function () {
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
    ko.applyBindings(viewModel);
    viewModel.pageInit();
});