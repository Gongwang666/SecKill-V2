define(['knockout'], function(ko) {
    function CategoryBarViewModel(params) {

    }

    return {
        viewModel: CategoryBarViewModel,
        template:
        '\t\t\t<div class="long-title"><span class="all-goods">全部分类</span></div>\n' +
        '\t\t\t\t<div class="nav-cont">\n' +
        '\t\t\t\t\t<ul>\n' +
        '\t\t\t\t\t\t<li class="index"><a href="#">首页</a></li>\n' +
        '\t\t\t\t\t\t<li class="qc"><a href="#">闪购</a></li>\n' +
        '\t\t\t\t\t\t<li class="qc"><a href="#">限时抢</a></li>\n' +
        '\t\t\t\t\t\t<li class="qc"><a href="#">团购</a></li>\n' +
        '\t\t\t\t\t\t<li class="qc last"><a href="#">大包装</a></li>\n' +
        '\t\t\t\t\t</ul>\n' +
        '\t\t\t\t\t<div class="nav-extra">\n' +
        '\t\t\t\t\t\t<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利\n' +
        '\t\t\t\t\t\t<i class="am-icon-angle-right" style="padding-left: 10px;"></i>\n' +
        '\t\t\t\t\t</div>\n' +
        '\t\t\t\t</div>\n'
    };
});