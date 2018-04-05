//头部导航栏组件
define(['knockout','constants',
        'text!' + baseURL + '/assets/appJS/templates/head_nav_bar.html'], function(ko,co,html) {
    function HeadNavBarViewModel(params) {
        this.toHomePage = function () {
            $(window).attr("location",URLS.HOME);
        }
    }

    return {
        viewModel: HeadNavBarViewModel,
        template:html
    };
});