define(['jquery','knockout','constants','text!' + baseURL + '/assets/appJS/templates/home_goods_list.html'],function ($,ko,co,html) {
    function HomeGoodsListViewModel(parms) {
        this.title = ko.observable(parms.title);
        this.hot = ko.observableArray(parms.hot);
        this.desc = ko.observable(parms.desc);
        this.toInfoPage = function () {
            alert("aaa");
        }
    }

    return{
        viewModel:HomeGoodsListViewModel,
        template:html
    };
});