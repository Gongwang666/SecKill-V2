<div class="row-content am-cf">
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">

                <div class="widget-head am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title  am-cf">商品图片</div>
                    </div>
                    <#--表头新增保存按钮栏-->
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                        <div class="am-form-group">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button id="add-img-btn" type="button"
                                            class="am-btn am-btn-default am-btn-success"><span
                                            class="am-icon-plus"></span> 新增
                                    </button>
                                    <button id="set-img-btn" type="button"
                                            class="am-btn am-btn-default am-btn-warning"><span
                                            class="am-icon-plus"></span> 设为展示图片
                                    </button>
                                    <button id="del-img-btn" type="button" class="am-btn am-btn-default am-btn-danger"><span
                                            class="am-icon-trash-o"></span> 删除
                                    </button>
                                    <button id="back" type="button" class="am-btn am-btn-default am-btn-secondary"><span
                                            class="am-icon-trash-o"></span> 返回
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="widget-body am-fr">
                    <ul data-am-widget="gallery" class="am-gallery am-avg-sm-3 am-avg-md-3 am-avg-lg-4 am-gallery-default" data-am-gallery="{ pureview: true }">
                        <#list pageInfo.list as goodsImg>
                            <li>
                                <div class="am-gallery-item">
                                    <a href="javascript:;" class="">
                                        <input type="checkbox" name="goods-img" value="${goodsImg.id}">
                                        <img style="height: 200px" src="${goodsImg.imgUrl}" alt="${goodsImg.imgDesc}"/>
                                        <h3 class="am-gallery-title">${goodsImg.imgDesc}</h3>
                                        <div class="am-gallery-desc">${goodsImg.uploadDate?string('yyyy-MM-dd')}</div>
                                    </a>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
                <#--分页-->
                <div class="am-u-lg-12 am-cf">

                    <div class="am-fr">
                        <ul class="am-pagination tpl-pagination">
                                        <#if pageInfo.hasPreviousPage>
                                            <li><a class="res-page" href="javascript:;" data-res-page="1">首页</a></li>
                                            <li><a class="res-page" href="javascript:;"
                                                   data-res-page="${pageInfo.prePage}">«</a></li>
                                        </#if>

                                        <#list pageInfo.navigatepageNums as nav>
                                            <#if nav == pageInfo.pageNum>
                                                <li class="am-active"><a href="javascript:;">${nav}</a></li>
                                            </#if>
                                            <#if nav != pageInfo.pageNum>
                                                <li><a class="res-page" href="javascript:;"
                                                       data-res-page="${nav}">${nav}</a></li>
                                            </#if>
                                        </#list>

                                        <#if pageInfo.hasNextPage>
                                            <li><a class="res-page" href="javascript:;"
                                                   data-res-page="${pageInfo.nextPage}">»</a></li>
                                            <li><a class="res-page" href="javascript:;"
                                                   data-res-page="${pageInfo.total}">尾页</a></li>
                                        </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function() {
        //添加图片按钮事件
        $('#add-img-btn').on('click',function () {
            var id = '${goodsID}';
            $('#content').load('/goods/goodsInfo/uploadFile?id='+id);
        });
        //删除图片按钮事件
        $('#del-img-btn').on('click',function () {
            var ids = [];
            $('[name=goods-img]:checkbox:checked').each(function() {
                ids.push($(this).val())
            });
            if(ids.length == 0){
                alert("请选择要删除的图片!")
                return;
            }else {
                console.log(JSON.stringify(ids))
                $.post("/goods/goodsInfo/delFile.do",{idsArray:JSON.stringify(ids)},function (data) {
                    console.log(data)
                    alert("删除成功!");
                    var page = '${pageInfo.pageNum}';
                    var id = '${goodsID}';
                    $('#content').load('/goods/goodsInfo/imgPage?page='+page+'&id='+id);
                });
            }
        });
        //返回按钮事件
        $('#back').on('click',function () {
            $('#content').load('/goods/goodsInfo/imgManage?page=1');
        });

        $('#set-img-btn').on('click',function () {
            var ids = [];
            $('[name=goods-img]:checkbox:checked').each(function() {
                ids.push($(this).val())
            });
            if(ids.length<=0){
                alert("请选择图片!")
            }
            if(ids.length>1){
                alert("只能设置一个展示图片!")
                return ;
            }
            $.post('/goods/goodsInfo/setGoodsImgPath',{id:ids[0]},function (data) {
                alert(data.msg)
            },'json');
        });

    });
</script>