define(['jquery','knockout','constants','text!' + baseURL + '/assets/appJS/templates/home_goods_list.html'],function ($,ko,co,html) {
    function HomeGoodsListViewModel(parms) {
        var TYPE_MAP = {
            1:'name',
            2:'price',
            3:'detailUrl',
            4:'imgUrl'
        };
        this.title = ko.observable(parms.title);
        this.newGoods = ko.observableArray(parms.newGoods);
        this.hot = ko.observableArray(parms.hot);
        this.desc = ko.observable(parms.desc);

        this.toInfoPage = function () {

        };

        this.getGoodsInfoByIndex = function(index,type){
            var goodsInfo = [
                {
                name:'雪之恋和风大福',
                price:'13.5',
                detailUrl:'aa',
                imgUrl:'../assets/images/2.jpg'
                },
                {
                    name:'雪之恋和风大福',
                    price:'13.5',
                    detailUrl:'aa',
                    imgUrl:'../assets/images/2.jpg'
                },
                {
                    name:'雪之恋和风大福',
                    price:'13.5',
                    detailUrl:'aa',
                    imgUrl:'../assets/images/2.jpg'
                },
                {
                    name:'雪之恋和风大福',
                    price:'13.5',
                    detailUrl:'aa',
                    imgUrl:'../assets/images/2.jpg'
                },
                {
                    name:'雪之恋和风大福',
                    price:'13.5',
                    detailUrl:'aa',
                    imgUrl:'../assets/images/2.jpg'
                },
                {
                    name:'雪之恋和风大福',
                    price:'13.5',
                    detailUrl:'aa',
                    imgUrl:'../assets/images/2.jpg'
                },
            ];
            var info = goodsInfo[index];
            return info[TYPE_MAP[type]];
        };

    }

    return{
        viewModel:HomeGoodsListViewModel,
        template:html
    };
});