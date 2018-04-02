//搜索框组件
define(['knockout'], function(ko) {
    function MyComponentViewModel(params) {

    }

    return {
        viewModel: MyComponentViewModel,
        template: '<div class="nav white">\n' +
        '\t\t<div class="logo"><img src="../assets/images/logo.png" /></div>\n' +
        '\t\t<div class="logoBig">\n' +
        '\t\t\t<li><img src="../assets/images/logobig.png" /></li>\n' +
        '\t\t</div>\n' +
        '\n' +
        '\t\t<div class="search-bar pr">\n' +
        '\t\t\t<a name="index_none_header_sysc" href="#"></a>\n' +
        '\t\t\t<form>\n' +
        '\t\t\t\t<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">\n' +
        '\t\t\t\t<input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">\n' +
        '\t\t\t</form>\n' +
        '\t\t</div>\n' +
        '\t</div>'
    };
});