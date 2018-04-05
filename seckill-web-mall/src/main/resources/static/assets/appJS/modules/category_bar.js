define(['knockout','constants','text!'+baseURL+'/assets/appJS/templates/category_bar.html'], function(ko,co,html) {
    function CategoryBarViewModel(params) {
        this.toHomePage = function () {
            $(window).attr("location",URLS.HOME);
        }
    }

    return {
        viewModel: CategoryBarViewModel,
        template:html

    };
});