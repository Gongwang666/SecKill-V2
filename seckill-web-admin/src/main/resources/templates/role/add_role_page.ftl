<div class="row-content am-cf">
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div id="add_role_message" hidden="hidden" class="am-alert am-alert-success" data-am-alert>
                        <button type="button" class="am-close">&times;</button>
                        <p id="show_message"></p>
                    </div>
                    <div class="widget-title  am-cf">添加角色</div>
                </div>
                <div class="widget-body  am-fr">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <!-- col start -->
                        <div class="am-u-md-6">
                            <div class="card-box">
                                <form id="add_role_form" enctype="multipart/form-data" method="post" class="tpl-form-border-form tpl-form-border-br">
                                    <div class="am-form-group">
                                        <label for="role_name" class="am-u-sm-3 am-form-label">
                                            角色名称:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="role_name" type="text" class="tpl-form-input" placeholder="请输入角色名称"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="role_des" class="am-u-sm-3 am-form-label">
                                            角色描述:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="role_des" type="text" class="tpl-form-input" placeholder="请输入角色描述"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="res_select" class="am-u-sm-3 am-form-label">
                                            拥有的资源（多选）:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <select id="res_select" name="catId" data-placeholder="请选择资源" style="width:350px;" multiple class="chosen-select-no-results" tabindex="9">

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
                                            是否可用:
                                        </label>
                                        <div class="am-u-sm-9 ">

                                            <div class="am-u-sm-9">
                                                <div class="am-u-sm-6">
                                                    <label class="am-radio-inline">
                                                        <input type="radio" name="isLocked" value="1" data-am-ucheck> 是
                                                    </label>
                                                </div>

                                                <div class="am-u-sm-6">
                                                    <label class="am-radio-inline">
                                                        <input type="radio" name="isLocked" value="0" data-am-ucheck> 否
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
                                                <button id="add_user" type="button" class="am-btn am-btn-primary">提交</button>
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
    $('#res_select').chosen({ width: '95%'});


    $('#add_user').on('click',function () {
        var form = $('#add_role_form');
        var roleName = $('#role_name').val();
        var resource = $('#res_select').val();
        var roleDes = $('#role_des').val();
        var isLocked = $("input[name='isLocked']:checked").val();
        if(roleName == null || roleName == ""){
            alert("角色名不能为空！");
            return;
        }
        if(roleDes == null || roleDes == ""){
            alert("角色描述不能为空！");
            return;
        }
        if(resource == null || resource.length <= 0){
            alert("请至少选择一个资源！");
            return;
        }
        if(isLocked == null || isLocked == ""){
            alert("请选择用户是否锁定！");
            return;
        }
        var resString = "";
        for(var i=0;i<resource.length;i++){
            resString = (i != resource.length-1) ? resString + resource[i] + "," : resString + resource[i];
        }

        //console.log(roleString);

        var allData = {
                        role : roleName,
                        description : roleDes,
                        resourceIds : resString,
                        available :  isLocked
                        };
        $.ajax({
            url:'/role/create.do',
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
                console.log(data);
                if(data.status == 0){
                    $('#add_role_message').attr("class","am-alert am-alert-success")
                    $('#add_role_message').show();
                    $('#show_message').text(data.msg);
                    setTimeout("$('#content').load('/role/create')",1500);
                }else {
                    $('#add_role_message').attr("class","am-alert am-alert-danger")
                    $('#add_role_message').show();
                    $('#show_message').text(data.msg);
                }


                //$('#add_cat_alert').show();
                //setTimeout("$('#content').load('/resource/create')",1500);
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