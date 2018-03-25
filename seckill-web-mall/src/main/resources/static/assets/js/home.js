require.config({
    baseUrl:'assets/js/',
    paths : {
        "jquery" : ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min","jquery.min"],
        "knockout" : ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "quick_links":"quick_links",
        "AmazeUI" :["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min","amazeui.min"]
    }
})

require(['jquery','knockout','quick_links','AmazeUI'],function($,ko){
    //图片轮播
    $(function () {
        $('.am-slider').flexslider();

    });

    $(function () {
        $("li").hover(function () {
            $(".category-content .category-list li.first .menu-in").css("display", "none");
            $(".category-content .category-list li.first").removeClass("hover");
            $(this).addClass("hover");
            $(this).children("div.menu-in").css("display", "block")
        }, function () {
            $(this).removeClass("hover")
            $(this).children("div.menu-in").css("display", "none")
        });
    })
    
    
    $(function () {
        if ($(window).width() < 640) {
            function autoScroll(obj) {
                $(obj).find("ul").animate({
                    marginTop: "-39px"
                }, 500, function () {
                    $(this).css({
                        marginTop: "0px"
                    }).find("li:first").appendTo(this);
                })
            }

            $(function () {
                setInterval('autoScroll(".demo")', 3000);
            })
        }
    })

});