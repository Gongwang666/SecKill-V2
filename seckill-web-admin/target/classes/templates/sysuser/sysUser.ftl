
        <!-- 内容区域 -->
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                    <#--表头标题-->
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">用户列表</div>
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
                                        <th>用户ID</th>
                                        <th>用户名</th>
                                        <th>用户角色</th>
                                        <th>是否锁定</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list pageInfo.list as user>
                                            <tr class="gradeX">
                                                <td>${user.id}</td>
                                                <td>${user.userName}</td>
                                                <td>${user.roleIds}</td>
                                                <td>
                                                    <#if user.locked == 0>
                                                        <p>正常</p>
                                                    <#else>
                                                        <p  style="color: red">被锁定</p>
                                                    </#if>

                                                </td>
                                                <td>
                                                    <div class="tpl-table-black-operation">
                                                        <a href="javascript:;" data-user-id="${user.id}"
                                                           class="blocking-user tpl-table-black-operation-del">
                                                            <i class="am-icon-trash"></i> 停用
                                                        </a>
                                                        <a href="javascript:;" data-user-id="${user.id}"
                                                           class="deblocking-user tpl-table-black-operation-enable">
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
                                            <li><a class="user-page" href="javascript:;" data-user-page="1">首页</a></li>
                                            <li><a class="user-page"  href="javascript:;" data-user-page="${pageInfo.prePage}">«</a></li>
                                        </#if>

                                        <#list pageInfo.navigatepageNums as nav>
                                            <#if nav == pageInfo.pageNum>
                                                <li class="am-active"><a href="javascript:;">${nav}</a></li>
                                            </#if>
                                            <#if nav != pageInfo.pageNum>
                                                <li ><a class="user-page" href="javascript:;" data-user-page="${nav}">${nav}</a></li>
                                            </#if>
                                        </#list>

                                        <#if pageInfo.hasNextPage>
                                            <li><a class="user-page" href="javascript:;" data-user-page="${pageInfo.nextPage}">»</a></li>
                                            <li><a class="user-page" href="javascript:;" data-user-page="${pageInfo.total}">尾页</a></li>
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
    //启用用户
    $(function () {
        $('.deblocking-user').on('click', function () {
            var id = $(this).attr('data-user-id');
            $.ajax({
                url: '/sysuser/deblocking.do',
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
                    AMUI.dialog.alert({
                        title: '提示信息',
                        content: '启用成功!',
                        onConfirm: function() {
                            $('#content').load('/sysuser/view?page=${pageInfo.pageNum}');
                        }
                    });
                    //console.log(textStatus)
                    //console.log(jqXHR)
                }
            });
        })
    });
    //停用用户
    $(function () {
        $('.blocking-user').on('click', function () {
            var id = $(this).attr('data-user-id');
            //$('#message-show').alert();
            var result = null;
            AMUI.dialog.alert({
                title: '停用提示',
                content: '您确定要停用该用户？',
                onConfirm: function() {
                    $.ajax({
                        url: '/sysuser/blocking.do',
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
                                setTimeout("$('#content').load('/sysuser/view?page=${pageInfo.pageNum}')", 1500);
                            }else if(data.status == -1){
                                AMUI.dialog.alert({
                                    title: 'Message',
                                    content: data.msg,
                                    onConfirm: function() {
                                        console.log("停用失败！");
                                    }
                                });
                            }
                            //console.log(textStatus)
                            //console.log(jqXHR)
                        }
                    });
                }
            });



        })
    });

    $(function () {
        $('.user-page').on('click',function () {
            var page = $(this).attr('data-user-page');
            $('#content').load("/sysuser/view?page="+page);
        });
    });

</script>