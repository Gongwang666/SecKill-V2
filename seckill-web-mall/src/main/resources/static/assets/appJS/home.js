require.config({
    baseUrl: 'assets/js/',
    shim: {
        'jquery.session': ['jquery']
    },
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "jquery.session":"jquery.session",
        "quick_links": "quick_links",
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "constants":["constants"],
        "text":["https://cdn.bootcss.com/require-text/2.0.12/text.min"]
    }
})

require(['jquery', 'knockout', 'jquery.session','quick_links', 'AmazeUI','constants'], function ($, ko) {
    var URL = {
        QUERY_CAT_LIST: "/getCatList"
    };

    var viewModel = {
        goodsInfo:ko.observable(),
        userInfo:ko.observable(),
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
            //注册分类菜单组件
            ko.components.register('goods-list', {
                require: '../appJS/modules/home_goods_list'
            });
        },
        pageInit: function () {
            viewModel.register();

            //图片轮播
            $('.am-slider').flexslider();
            viewModel.catMenuInit();
            viewModel.getGoodsInfo();
            viewModel.getUserInfo();
        },
        //分类菜单初始化
        catMenuInit: function () {
            //viewModel.goodsInfo = {title:"甜品"}
            $.post(URL.QUERY_CAT_LIST, function (data) {
                console.log(data)
                var cats = data[0].products;
                if (cats != null) {
                    $.each(cats, function (index, value) {
                        var catName = value.goodsCats.catName;
                        var html = viewModel.getCatLiHtml(value);

                        $('#js_climit_li').append(html);
                        viewModel.event.showOrHideCats();
                    });
                }

            });
        },
        getCatLiHtml: function (value) {
            var dl = '';
            if(value.products!=null && value.products.length > 0){
                $.each(value.products,function (index,val) {
                    var dd = '';

                    if(val.products!=null && val.products.length >0){
                        $.each(val.products,function (index,va) {
                            dd += '<dd><a title="" href="'+URLS.GOODS_LIST+'?catId='+va.goodsCats.id+'"><span>'+va.goodsCats.catName+'</span></a></dd>';
                        });
                    }
                    dl += '<dl class="dl-sort">' +
                        '<dt><span title="蛋糕">'+val.goodsCats.catName+'</span></dt>' +
                         dd +
                        '</dl>';
                });

            }
            var html = '<li class="appliance js_toggle relative" data-bind="event: { mouseover: enableDetails, mouseout: disableDetails }">' +
                            '<div class="category-info">' +
                                '<h3 class="category-name b-category-name"><i><img src="../assets/images/cake.png"></i><a ' +
                                    'class="ml-22" title="点心">'+value.goodsCats.catName+'</a></h3>' +
                                    '<em>&gt;</em>' +
                            '</div>' +
                            '<div class="menu-item menu-in top">' +
                                '<div class="area-in">' +
                                    '<div class="area-bg">' +
                                        '<div class="menu-srot">' +
                                            '<div class="sort-side">' +
                                                dl +
                                            '</div>' +
                                            '<div class="brand-side">' +
                                                '<dl class="dl-sort">' +
                                                    '<dt><span>实力商家</span></dt>' +
                                                    '<dd><a rel="nofollow" title="呵官方旗舰店" target="_blank" href="#"' +
                                                        'rel="nofollow"><span class="red">呵官方旗舰店</span></a></dd>' +
                                                '</dl>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>' +
                            '</div>' +
                            '<b class="arrow"></b>' +
                        '</li>';
            return html;
        },
        getGoodsInfo:function () {
            $.post('/home/getHomePageGoodsList',function (result) {
                viewModel.goodsInfo(result);
            },'json');
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
        event:{
            //显示隐藏菜单
            showOrHideCats:function () {
                $("li").hover(function () {
                    $(".category-content .category-list li.first .menu-in").css("display", "none");
                    $(".category-content .category-list li.first").removeClass("hover");
                    $(this).addClass("hover");
                    $(this).children("div.menu-in").css("display", "block")
                }, function () {
                    $(this).removeClass("hover")
                    $(this).children("div.menu-in").css("display", "none")
                });
            },
            //跳转到商品列表页
            toGoodsList:function (catId) {
                $(window).attr('location',URLS.GOODS_LIST+'?catId='+catId);
            }
        }
    };
    viewModel.pageInit();
    ko.applyBindings(viewModel);
    window.viewModel = viewModel;
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
    return{
        viewModel:viewModel
    }
});