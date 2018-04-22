//头部导航栏组件
define(['jquery','knockout','constants',
        'text!' + baseURL + '/assets/appJS/templates/head_nav_bar.html'], function($,ko,co,html) {
    function HeadNavBarViewModel(params) {
        if(typeof params == 'undefined'){
            this.userName = ko.observable('');
        }else{
            this.userName = ko.observable(params.userName);
        }

        this.toHomePage = function () {
            $(window).attr("location",URLS.HOME);
        };

        this.isLogin = function () {
            if(typeof params == 'undefined'){
                return false;
            }else{
                return true;
            }
        };
        this.toPersonPage = function () {
            if(typeof params == 'undefined'){
                $(window).attr("location",URLS.LOGIN);
            }
        };
        this.toLoginPage = function () {
            $(window).attr("location",URLS.LOGIN_PAGE);
        };
        this.toRegisterPage = function () {
            $(window).attr("location",URLS.REGISTER);
        }
    }

    return {
        viewModel: HeadNavBarViewModel,
        template:html
    };
});