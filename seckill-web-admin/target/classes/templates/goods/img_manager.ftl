
<!-- 内容区域 -->
<div class="row-content am-cf">
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">
            <#--表头标题-->
                <div class="widget-head am-cf">
                    <div class="widget-title  am-cf">商品图片</div>
                <#--信息提示-->
                    <div id="message-show" hidden="hidden" class="am-alert am-alert-danger" data-am-alert>
                        <button type="button" class="am-close">&times;</button>
                        <p id="show-message"></p>
                    </div>
                </div>
                <div class="widget-body  am-fr">

                <#--表头新增保存按钮栏-->
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                        <div class="am-form-group">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button id="doc-prompt-toggle" type="button"
                                            class="am-btn am-btn-default am-btn-success"><span
                                            class="am-icon-plus"></span> 新增
                                    </button>
                                    <button type="button" class="am-btn am-btn-default am-btn-secondary"><span
                                            class="am-icon-save"></span> 保存
                                    </button>
                                    <button type="button" class="am-btn am-btn-default am-btn-warning"><span
                                            class="am-icon-archive"></span> 审核
                                    </button>
                                    <button type="button" class="am-btn am-btn-default am-btn-danger"><span
                                            class="am-icon-trash-o"></span> 删除
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                <#--选择分类-->
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                        <div class="am-form-group tpl-table-list-select">
                            <select data-am-selected="{btnSize: 'sm'}">
                                <option value="option1">所有类别</option>
                                <option value="option2">一级分类</option>
                                <option value="option2">二级分类</option>
                            </select>
                        </div>
                    </div>

                <#--搜索分类-->
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                        <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                            <input type="text" class="am-form-field ">
                            <span class="am-input-group-btn">
                            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
                                    type="button"></button>
                            </span>
                        </div>
                    </div>
                <#--分类展示表格-->
                    <div class="am-u-sm-12">
                        <table width="100%" class="am-table am-table-hover am-table-bordered am-table-striped tpl-table-black "
                               id="example-r">
                            <thead>
                            <tr>
                                <th>商品ID</th>
                                <th>商品名称</th>
                                <th>商品图片</th>
                                <th>上传时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list pageInfo.list as goods>
                                    <tr class="gradeX">
                                        <td>${goods.id}</td>
                                        <td>${goods.goodsName}</td>
                                        <td>
                                            <#if goods.goodsImgList[0].imgUrl??>

                                                <img style="width: 70px;height: 80px" src="${goods.goodsImgList[0].imgUrl}">
                                            <#else >
                                                无图片，请上传!
                                            </#if>

                                        </td>
                                        <td>
                                            <#if goods.goodsImgList[0].uploadDate??>
                                                ${goods.goodsImgList[0].uploadDate?string('yyyy-MM-dd')}
                                            <#else >

                                            </#if>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;" data-goods-id="${goods.id}" class="update-img">
                                                    <i class="am-icon-pencil"></i> 编辑图片
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </#list>

                            <!-- more data -->
                            </tbody>
                        </table>

                    </div>
                <#--分页-->
                    <div class="am-u-lg-12 am-cf">

                        <div class="am-fr">
                            <ul class="am-pagination tpl-pagination">
                                <#if pageInfo.hasPreviousPage>
                                    <li><a class="cat-page" href="javascript:;" data-cat-page="1">首页</a></li>
                                    <li><a class="cat-page"  href="javascript:;" data-cat-page="${pageInfo.prePage}">«</a></li>
                                </#if>

                                <#list pageInfo.navigatepageNums as nav>
                                    <#if nav == pageInfo.pageNum>
                                        <li class="am-active"><a href="javascript:;">${nav}</a></li>
                                    </#if>
                                    <#if nav != pageInfo.pageNum>
                                        <li ><a class="cat-page" href="javascript:;" data-cat-page="${nav}">${nav}</a></li>
                                    </#if>
                                </#list>

                                <#if pageInfo.hasNextPage>
                                    <li><a class="cat-page" href="javascript:;" data-cat-page="${pageInfo.nextPage}">»</a></li>
                                    <li><a class="cat-page" href="javascript:;" data-cat-page="${pageInfo.total}">尾页</a></li>
                                </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    //编辑分类
    $(function () {
        $('.update-img').on('click', function () {
            var id = $(this).attr('data-goods-id');
            $('#content').load('/goods/goodsInfo/imgPage?page=1&id='+id);
        })
    });
</script>