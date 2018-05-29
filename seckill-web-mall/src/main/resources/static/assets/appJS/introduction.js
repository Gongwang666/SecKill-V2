require.config({
    baseUrl: 'assets/js/',
    paths: {
        "jquery": ["https://cdn.bootcss.com/jquery/3.3.1/jquery.min", "jquery.min"],
        "knockout": ["https://cdn.bootcss.com/knockout/3.4.2/knockout-min"],
        "quick_links": "quick_links",
        "AmazeUI": ["https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min", "amazeui.min"],
        "list":["list"],
        "magnifier":["amazeui.magnifier.min"],
        "constants":["constants"],
        "text":["https://cdn.bootcss.com/require-text/2.0.12/text.min"],
        "css":["https://cdn.bootcss.com/require-css/0.1.10/css"],
    }
})


require(['jquery', 'knockout', 'quick_links', 'AmazeUI','list','constants'],function ($,ko) {

    var viewModel = {
        selectIndex:1,
        goodsId:ko.observable(''),
        goodsName:ko.observable(''),
        goodsTips:ko.observable(''),
        shopPrice:ko.observable(''),
        marketPrice:ko.observable(''),
        goodsImg:ko.observable(''),
        goodsSpecName:ko.observable(''),
        specItems:ko.observableArray(),
        goodsDetailImgs:ko.observableArray(),
        userInfo:ko.observable(),
        render:{
            isSelect:function (element, index, data) {
                if(viewModel.selectIndex == 1){
                    $(element).addClass('selected');
                    viewModel.selectIndex++;
                }
            }
        },
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
            var urlStr = window.location.search;
            viewModel.goodsId(urlStr.substring(urlStr.indexOf('=')+1));
            //查询商品信息
            viewModel.queryGoodsInfo();
            //查询规格信息
            viewModel.querySpecInfo();
            //查询商品详情图片
            viewModel.queryDetailImgs();
            viewModel.getUserInfo();
            //图片轮播
            $('.flexslider').flexslider({
                animation: "slide",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });

            //初始化图片放大镜
           /* $(document).ready(function() {
                $(".jqzoom").imagezoom();
                $("#thumblist li a").click(function() {
                    $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
                    $(".jqzoom").attr('src', $(this).find("img").attr("mid"));
                    $(".jqzoom").attr('rel', $(this).find("img").attr("big"));
                });
            });*/

        },
        queryGoodsInfo:function () {
            var id = viewModel.goodsId();
            $.post('/introduction/getGoodsInfo',{id:id},function (result) {
                viewModel.goodsName(result.goodsName);
                viewModel.goodsTips(result.goodsTips);
                viewModel.marketPrice(result.marketPrice);
                viewModel.shopPrice(result.shopPrice);
                viewModel.goodsImg(result.goodsImg);
            },'json');
        },
        querySpecInfo:function () {
            var id = viewModel.goodsId();
            $.post('/introduction/getSpecInfo',{id:id},function (result) {
                viewModel.goodsSpecName(result.specName);
                viewModel.specItems(result.specItems);
            },'json');
        },
        queryDetailImgs:function () {
            var id = viewModel.goodsId();
            $.post('/introduction/getDetailImgs',{id:id},function (result) {
                viewModel.goodsDetailImgs(result);
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
            addGoodsToCart:function () {
                if(typeof viewModel.userInfo() =='undefined'){
                    $(window).attr("location",URLS.LOGIN_PAGE);
                    return ;
                }
                var num = $('#text_box').val();
                var postData = {
                    goodsId:viewModel.goodsId,
                    goodsNum:num
                };

                $.post(URLS.ADD_GOODS_TO_CART,postData,function () {
                    alert("添加成功!");
                },'json');
            }
        }
    };
    viewModel.pageInit();
    ko.applyBindings(viewModel);

    window.viewModel = viewModel;

});