//头部导航栏组件
define(['jquery','knockout','constants',
        'text!' + baseURL + '/assets/appJS/templates/head_nav_bar.html','css!https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min'], function($,ko,co,html) {
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
                $(window).attr("location",URLS.LOGIN_PAGE);
                return ;
            }
            $(window).attr("location",URLS.PERSON_PAGE);
        };
        this.toCartPage = function () {
            if(typeof params == 'undefined'){
                $(window).attr("location",URLS.LOGIN_PAGE);
                return ;
            }
            $(window).attr("location",URLS.CART_PAGE);
        }
        this.toLoginPage = function () {
            $(window).attr("location",URLS.LOGIN_PAGE);
        };
        this.toRegisterPage = function () {
            $(window).attr("location",URLS.REGISTER);
        };
        this.logOut = function () {
            //alert('确认退出登录？');
            $('#dialog').dialog({
                buttons:{
                    "确定":function(){
                        $.ajax({
                            url:URLS.LOGOUT,
                            async:false,
                            success:function () {
                                $(window).attr("location",URLS.HOME);
                            }
                        });
                        //$(this).dialog('close');
                    },
                    "取消":function(){
                        $(this).dialog('close');
                    }
                }
            });
        }
    }

    return {
        viewModel: HeadNavBarViewModel,
        template:html
    };
});