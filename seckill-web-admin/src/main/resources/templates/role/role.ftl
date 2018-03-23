
        <!-- 内容区域 -->
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                    <#--表头标题-->
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">角色列表</div>
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
                                <table width="100%" class="am-table am-table-compact am-table-hover am-table-bordered am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>角色ID</th>
                                        <th>角色名称</th>
                                        <th>角色描述</th>
                                        <th>拥有的资源</th>
                                        <th>是否可用</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list pageInfo.list as role>
                                            <tr class="gradeX">
                                                <td>${role.id}</td>
                                                <td>${role.role}</td>
                                                <td>${role.description}</td>
                                                <td>${role.resourceIds}</td>
                                                <td>
                                                    <#if role.available == 0>
                                                        <p style="color: red">不可使用</p>
                                                    <#else>
                                                        可以使用
                                                    </#if>

                                                </td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:;" data-role-id="${role.id}"
                                                           class="update-role">
                                                            <i class="am-icon-pencil"></i> 编辑
                                                        </a>
                                                        <a href="javascript:;" data-role-id="${role.id}"
                                                           class="del-role tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 删除
                                                        </a>
                                                        <a href="javascript:;" data-role-id="${role.id}"
                                                           class="enable-role tpl-table-black-operation-enable">
                                                            <i class="am-icon-deaf"></i> 启用节点
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
                                            <li><a class="role-page" href="javascript:;" data-role-page="1">首页</a></li>
                                            <li><a class="role-page"  href="javascript:;" data-role-page="${pageInfo.prePage}">«</a></li>
                                        </#if>

                                        <#list pageInfo.navigatepageNums as nav>
                                            <#if nav == pageInfo.pageNum>
                                                <li class="am-active"><a href="javascript:;">${nav}</a></li>
                                            </#if>
                                            <#if nav != pageInfo.pageNum>
                                                <li ><a class="role-page" href="javascript:;" data-role-page="${nav}">${nav}</a></li>
                                            </#if>
                                        </#list>

                                        <#if pageInfo.hasNextPage>
                                            <li><a class="role-page" href="javascript:;" data-role-page="${pageInfo.nextPage}">»</a></li>
                                            <li><a class="role-page" href="javascript:;" data-role-page="${pageInfo.total}">尾页</a></li>
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
        $('.update-role').on('click', function () {
            var id = $(this).attr('data-role-id');
            $('#content').load('/role/update?id='+id);
        })
    });
    //启用角色
    $(function () {
        $('.enable-role').on('click', function () {
            var id = $(this).attr('data-role-id');
            $.ajax({
                url: '/role/enable.do',
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
                    $('#content').load('/role/view?page=${pageInfo.pageNum}');
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
    //删除角色
    $(function () {
        $('.del-role').on('click', function () {
            var id = $(this).attr('data-role-id');
            //$('#message-show').alert();
            var result = null;
            AMUI.dialog.alert({
                title: '删除提示',
                content: '您确定要删除该角色？',
                onConfirm: function() {
                    $.ajax({
                        url: '/role/delete',
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
                            if(data.status == 0){
                                $('#message-show').text(data.msg);
                                $('#message-show').show();
                                setTimeout("$('#content').load('/role/view?page=${pageInfo.pageNum}')", 1500);
                            }else if(data.status == -1){
                                AMUI.dialog.alert({
                                    title: 'Message',
                                    content: data.msg,
                                    onConfirm: function() {
                                        console.log("删除失败！");
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
        $('.role-page').on('click',function () {
            var page = $(this).attr('data-role-page');
            $('#content').load("/role/view?page="+page);
        });
    });
</script>