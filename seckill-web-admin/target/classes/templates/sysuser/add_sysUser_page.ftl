<div class="row-content am-cf">
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div id="add_sysuser_message" hidden="hidden" class="am-alert am-alert-success" data-am-alert>
                        <button type="button" class="am-close">&times;</button>
                        <p id="show_message"></p>
                    </div>
                    <div class="widget-title  am-cf">添加用户</div>
                </div>
                <div class="widget-body  am-fr">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <!-- col start -->
                        <div class="am-u-md-6">
                            <div class="card-box">
                                <form id="add_user_form" enctype="multipart/form-data" method="post" class="tpl-form-border-form tpl-form-border-br">

                                    <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-3 am-form-label">
                                            用户角色:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <select id="role_select" name="catId" data-placeholder="请选择角色" style="width:350px;" multiple class="chosen-select-no-results" tabindex="9">

                                                    <#list roleList as role>
                                                        <#--<#if cat.dataFlag == 1>
                                                            <option value="${cat.catId}">${cat.catName}</option>
                                                        <#else >
                                                            <option disabled value="${cat.catId}">${cat.catName}</option>
                                                        </#if>-->
                                                        <option value="${role.id}">${role.description}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            用户名:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input id="user_name" type="text" class="tpl-form-input" placeholder="请输入用户名称"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>


                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            是否锁定:
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
    $('#role_select').chosen({ width: '95%'});


    $('#add_user').on('click',function () {
        var form = $('#add_user_form');
        var userName = $('#user_name').val();
        var role = $('#role_select').val();
        var isLocked = $("input[name='isLocked']:checked").val();
        if(userName == null || userName == ""){
            alert("用户名不能为空！");
            return;
        }
        if(role == null || role.length <= 0){
            alert("请至少选择一个角色！");
            return;
        }
        if(isLocked == null || isLocked == ""){
            alert("请选择用户是否锁定！");
            return;
        }
        var roleString = "";
        for(var i=0;i<role.length;i++){
            roleString = (i != role.length-1) ? roleString + role[i] + "," : roleString + role[i];
        }

        //console.log(roleString);

        var allData = {
                        userName : userName,
                        roleIds : roleString,
                        locked :  isLocked
                        };
        $.ajax({
            url:'/sysuser/create.do',
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
                    $('#add_sysuser_message').attr("class","am-alert am-alert-success")
                    $('#add_sysuser_message').show();
                    $('#show_message').text(data.msg);
                }else {
                    $('#add_sysuser_message').attr("class","am-alert am-alert-danger")
                    $('#add_sysuser_message').show();
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