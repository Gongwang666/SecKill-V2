//搜索框组件
define(['jquery','knockout','constants',
        'text!' + baseURL + '/assets/appJS/templates/search_bar.html'], function($,ko,con,html) {
    function SearchBarViewModel(params) {
        //点击logo跳转到主页面
        this.toHomePage = function () {
            $(window).attr("location",URLS.HOME);
        }
    }


    return {
        viewModel: SearchBarViewModel,
        template:html
    };
});