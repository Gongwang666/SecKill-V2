//头部导航栏组件
define(['knockout'], function(ko) {
    function MyComponentViewModel(params) {

    }

    return {
        viewModel: MyComponentViewModel,
        template: '<div class="am-container header">\n' +
        '\t\t<ul class="message-l">\n' +
        '\t\t\t<div class="topMessage">\n' +
        '\t\t\t\t<div class="menu-hd">\n' +
        '\t\t\t\t\t<a href="#" target="_top" class="h">亲，请登录</a>\n' +
        '\t\t\t\t\t<a href="#" target="_top">免费注册</a>\n' +
        '\t\t\t\t</div>\n' +
        '\t\t\t</div>\n' +
        '\t\t</ul>\n' +
        '\t\t<ul class="message-r">\n' +
        '\t\t\t<div class="topMessage home">\n' +
        '\t\t\t\t<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>\n' +
        '\t\t\t</div>\n' +
        '\t\t\t<div class="topMessage my-shangcheng">\n' +
        '\t\t\t\t<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>\n' +
        '\t\t\t</div>\n' +
        '\t\t\t<div class="topMessage mini-cart">\n' +
        '\t\t\t\t<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>\n' +
        '\t\t\t</div>\n' +
        '\t\t\t<div class="topMessage favorite">\n' +
        '\t\t\t\t<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>\n' +
        '\t\t\t</div>\n' +
        '\t\t</ul>\n' +
        '\t</div>'
    };
});