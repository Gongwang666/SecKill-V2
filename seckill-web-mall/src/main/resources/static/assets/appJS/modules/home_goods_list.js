define(['jquery','knockout','constants','text!' + baseURL + '/assets/appJS/templates/home_goods_list.html'],function ($,ko,co,html) {
    function HomeGoodsListViewModel(parms) {
        var TYPE_MAP = {
            1:'goodsName',
            2:'shopPrice',
            3:'detailUrl',
            4:'goodsImg'
        };
        this.title = ko.observable(parms.title);
        this.newGoods = ko.observableArray(parms.newGoods);
        this.hot = ko.observableArray(parms.hot);
        this.desc = ko.observable(parms.desc);
        this.goodsInfo = ko.observableArray(parms.goodsInfo)
        this.toInfoPage = function () {

        };

        this.getGoodsInfoByIndex = function(index,type){
            var goodsInfo = this.goodsInfo();
            var info = goodsInfo[index];
            if(typeof info == 'undefined' || info == null){
                return '';
            }
            if(type == 3){
                return URLS.INTRODUCTION+'?goodsId='+info.id;
            }
            return info[TYPE_MAP[type]];
        };
        //获取详情页的url
        this.getDetailUrl = function (goodsId) {

            return URLS.INTRODUCTION+'?goodsId='+goodsId;
        }

    }

    return{
        viewModel:HomeGoodsListViewModel,
        template:html
    };
});