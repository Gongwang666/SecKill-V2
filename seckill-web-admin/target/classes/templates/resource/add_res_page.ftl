<div class="row-content am-cf">
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div id="add_cat_alert" hidden="hidden" class="am-alert am-alert-success" data-am-alert>
                        <button type="button" class="am-close">&times;</button>
                        <p>添加成功</p>
                    </div>
                    <div class="widget-title  am-cf">添加分类</div>
                </div>
                <div class="widget-body  am-fr">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <!-- col start -->
                        <div class="am-u-md-6">
                            <div class="card-box">
                                <form id="add_res_form" enctype="multipart/form-data" method="post" class="tpl-form-border-form tpl-form-border-br">

                                    <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-3 am-form-label">
                                            父级资源:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <select id="res_parent_select" name="catId" data-placeholder="Your Favorite Type of Bear" style="width:350px;" class="chosen-select-deselect" tabindex="9">

                                                    <#list resList as res>
                                                        <#--<#if cat.dataFlag == 1>
                                                            <option value="${cat.catId}">${cat.catName}</option>
                                                        <#else >
                                                            <option disabled value="${cat.catId}">${cat.catName}</option>
                                                        </#if>-->
                                                        <option value="${res.id}">${res.resName}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            资源名称:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="res_name" type="text" class="tpl-form-input" placeholder="请输入资源名称"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            资源类型:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <select id="res_type_select"  data-placeholder="Your Favorite Type of Bear" style="width:350px;" class="chosen-select-deselect" tabindex="9">
                                                    <option value="folder">菜单</option>
                                                    <option value="item">菜单项</option>
                                                    <option value="doAction">动作</option>
                                                </select>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            资源URL:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="res_url" type="text" class="tpl-form-input" placeholder="请输入资源URL"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            所有父类资源ID:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="all_parents" type="text" class="tpl-form-input" placeholder="请输入所有父类资源ID"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            权限:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="res_permission" type="text" class="tpl-form-input" placeholder="请输入权限"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            是否可用:
                                        </label>
                                        <div class="am-u-sm-9 ">

                                            <div class="am-u-sm-9">
                                                <div class="am-u-sm-6">
                                                    <label class="am-radio-inline">
                                                        <input type="radio" name="isShow" value="1" data-am-ucheck> 是
                                                    </label>
                                                </div>

                                                <div class="am-u-sm-6">
                                                    <label class="am-radio-inline">
                                                        <input type="radio" name="isShow" value="0" data-am-ucheck> 否
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="am-u-sm-3"></div>

                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <div class="am-u-sm-12 ">

                                            <div class="am-u-sm-4">
                                            </div>
                                            <div class="am-u-sm-8">
                                                <button id="add_res" type="button" class="am-btn am-btn-primary">提交</button>
                                            </div>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                        <!-- col end -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    //下拉选项卡js代码
    $('#res_parent_select').chosen({ width: '95%'});
    $('#res_type_select').chosen({ width: '95%'});

    $('#add_res').on('click',function () {
        var form = $('#add_res_form');
        var resParentId = $('#res_parent_select').val();
        var resName = $('#res_name').val();
        var resType = $('#res_type_select').val();
        var resUrl = $('#res_url').val();
        var allParents = $('#all_parents').val();
        var resPermission = $('#res_permission').val();
        var isShow = $("input[name='isShow']:checked").val();
        //var isShow = $("input[name='isShow']:checked").val();
        if(resName == null || resName == ""){
            alert("资源名称不能为空！");
            return;
        }
        if(resUrl == null || resUrl == ""){
            alert("资源不能为空！");
            return;
        }
        if(allParents == null || allParents == ""){
            alert("所有父类资源不能为空！");
            return;
        }
        if(resPermission == null || resPermission == ""){
            alert("权限不能为空！");
            return;
        }

        var allData = {
                        resName:resName,
                        resType:resType,
                        resUrl:resUrl,
                        parentId:resParentId,
                        parentIds:allParents,
                        permission:resPermission,
                        available:isShow
                        };
        $.ajax({
            url:'/resource/create.do',
            contentType:"application/json;charset=utf-8",
            type:form.attr("method"), //GET
            async:true,    //或false,是否异步
            data:JSON.stringify(allData),
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                //console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                console.log(data)
                //$('#add_cat_alert').show();
                setTimeout("$('#content').load('/resource/create')",1500);
                //console.log(textStatus)
                //console.log(jqXHR)
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                //console.log(textStatus)
            },
            complete:function(){
                console.log('结束');
            }
        })
    });

</script>