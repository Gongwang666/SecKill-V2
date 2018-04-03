//头部导航栏组件
define(['knockout',
        'text!' + baseURL + '/assets/templates/head_nav_bar.html'], function(ko,html) {
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