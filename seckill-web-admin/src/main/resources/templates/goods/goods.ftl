
        <!-- 内容区域 -->
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                    <#--表头标题-->
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">商品列表</div>
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
                            <div class="am-scrollable-horizontal">
                                <table class="am-table am-table-hover am-table-compact am-table-bordered am-table-striped am-text-nowrap tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>操作</th>
                                        <th>商品ID</th>
                                        <th>商品编号</th>
                                        <th>商品名称</th>
                                        <th>市场价</th>
                                        <th>门店价</th>
                                        <th>预警库存</th>
                                        <th>商品总库存</th>
                                        <th>促销信息</th>
                                        <th>是否上架</th>
                                        <th>是否精品</th>
                                        <th>是否热销产品</th>
                                        <th>是否新品</th>
                                        <th>商品分类ID路径</th>
                                        <th>最后一级商品分类ID</th>
                                        <th>商品描述</th>
                                        <th>总销售量</th>
                                        <th>上架时间</th>
                                        <th>创建时间</th>
                                        <th>是否删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list pageInfo.list as goods>
                                            <tr class="gradeX">
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:;" data-goods-id="${goods.id}"
                                                           class="update-goods">
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
                                                        <a href="javascript:;" data-goods-id="${goods.id}"
                                                           class="del-goods tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                        <a href="javascript:;" data-goods-id="${goods.id}"
                                                           class="enable-goods tpl-table-black-operation-enable">
                                                            <i class="am-icon-deaf"></i> 启用节点
                                                        </a>
                                                    </div>
                                                </td>
                                                <td>${goods.id}</td>
                                                <td>${goods.goodsSn}</td>
                                                <td>${goods.goodsName}</td>
                                                <td>${goods.marketPrice}</td>
                                                <td>${goods.shopPrice}</td>
                                                <td>${goods.warnStock}</td>
                                                <td>${goods.goodsStock}</td>
                                                <td>${goods.goodsTips}</td>
                                                <td>${goods.isSale}</td>
                                                <td>${goods.isBest}</td>
                                                <td>${goods.isHot}</td>
                                                <td>${goods.isNew}</td>
                                                <td>${goods.goodsCatIdPath}</td>
                                                <td>${goods.goodsCatId}</td>
                                                <td>${goods.goodsDesc}</td>
                                                <td>${goods.saleNum}</td>
                                                <td>
                                                    <#if goods.saleTime??>
                                                        ${goods.saleTime?string('yyyy-MM-dd')}
                                                    <#else >
                                                        未上架
                                                    </#if>

                                                </td>
                                                <td>
                                                    ${goods.createTime?string('yyyy-MM-dd')}
                                                </td>
                                                <td>
                                                    <#if goods.dataFlag == 1>
                                                        <p>可用</p>
                                                    <#else >
                                                        <p style="color: red">已删除</p>
                                                    </#if>
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
        </div>
<script>
    //$('#message-show').alert('close');
    //编辑资源
    $(function () {
        $('.update-res').on('click', function () {
            var id = $(this).attr('data-res-id');
            $('#content').load('/resource/update?resID=' + id);
        })
    });

    $(function () {
        $('.enable-res').on('click', function () {
            var id = $(this).attr('data-res-id');
            $.ajax({
                url: '/resource/enable.do',
                contentType: "application/json;charset=utf-8",
                type: 'POST', //GET
                async: false,    //或false,是否异步
                data: id,
                timeout: 5000,    //超时时间
                dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                beforeSend: function (xhr) {
                    //console.log(xhr)
                    console.log('发送前')
                },
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    //result = data;
                    //$('#message-show').show();
                    $('#content').load('/resource/view?page=${pageInfo.pageNum}');
                    //console.log(textStatus)
                    //console.log(jqXHR)
                },
                error: function (xhr, textStatus) {
                    console.log('错误')
                    console.log(xhr)
                    //console.log(textStatus)
                },
                complete: function () {
                    console.log('结束');
                }
            });
        })
    });
    //删除资源
    $(function () {
        $('.del-res').on('click', function () {
            var id = $(this).attr('data-res-id');
            //$('#message-show').alert();
            var result = null;
            AMUI.dialog.alert({
                title: '删除提示',
                content: '您确定要删除该资源？',
                onConfirm: function () {
                    $.ajax({
                        url: '/resource/delete',
                        contentType: "application/json;charset=utf-8",
                        type: 'POST', //GET
                        async: false,    //或false,是否异步
                        data: id,
                        timeout: 5000,    //超时时间
                        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                        beforeSend: function (xhr) {
                            //console.log(xhr)
                            console.log('发送前')
                        },
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            result = data;
                            if (data.status == 0) {
                                $('#message-show').text(data.msg);
                                $('#message-show').show();
                                setTimeout("$('#content').load('/resource/view?page=${pageInfo.pageNum}')", 1500);
                            } else if (data.status == -1) {
                                AMUI.dialog.alert({
                                    title: 'Message',
                                    content: data.msg,
                                    onConfirm: function () {
                                        console.log("删除失败，错误提示：该资源不能被删除！");
                                    }
                                });
                            }
                            //console.log(textStatus)
                            //console.log(jqXHR)
                        },
                        error: function (xhr, textStatus) {
                            console.log('错误')
                            console.log(xhr)
                            //console.log(textStatus)
                        },
                        complete: function () {
                            console.log('结束');
                        }
                    });
                }
            });


        })
    });

    $(function () {
        $('.res-page').on('click', function () {
            var page = $(this).attr('data-res-page');
            $('#content').load("/resource/view?page=" + page);
        });
    });

    $(function () {
        $('.goods-img-manager').on('click', function () {
            var id = $(this).attr('data-goods-id');
            $('#content').load("/goods/goodsInfo/imgManage?id=" + id);
        });
    });

    $(function () {
        $('#doSave').on('click',function () {

        });
    });
</script>