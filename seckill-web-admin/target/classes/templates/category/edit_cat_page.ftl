<div class="row-content am-cf">
    <div class="row">
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div id="add_cat_alert" hidden="hidden" class="am-alert am-alert-success" data-am-alert>
                        <button type="button" class="am-close">&times;</button>
                        <p id="show_message"></p>
                    </div>
                    <div class="widget-title  am-cf">编辑分类信息</div>
                </div>
                <div class="widget-body  am-fr">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <!-- col start -->
                        <div class="am-u-md-6">
                            <div class="card-box">
                                <form id="add_cat_form" enctype="multipart/form-data" method="post" class="tpl-form-border-form tpl-form-border-br">

                                    <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-3 am-form-label">
                                            父级分类:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <select id="my-select" name="catId" data-placeholder="Your Favorite Type of Bear" style="width:350px;" class="chosen-select-deselect" tabindex="9">

                                                <#list catsList as cat>
                                                    <#if cat.dataFlag == 1>
                                                        <#if cat.id == parentCats.id>
                                                            <option selected value="${cat.id}">${parentCats.catName}</option>
                                                        <#else >
                                                            <option value="${cat.id}">${cat.catName}</option>
                                                        </#if>
                                                    <#else >
                                                        <option disabled value="${cat.id}">${cat.catName}</option>
                                                    </#if>
                                                </#list>
                                                <#--<option value=""></option>

                                                <option selected disabled>Sloth Bear</option>
                                                <option disabled>Sun Bear</option>
                                                <option selected disabled>Paddington Bear</option>
                                                <option selected>Polar Bear</option>
                                                <option disabled>Spectacled Bear</option>-->
                                                </select>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            分类名称:
                                        </label>
                                        <div class="am-u-sm-9">
                                            <div class="am-u-sm-9">
                                                <input type="text" value="${goodsCats.catName}" name="catName" class="tpl-form-input" id="cat-name" placeholder="请输入分类名称"/>
                                            </div>
                                            <div class="am-u-sm-3"></div>
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">
                                            是否显示:
                                        </label>
                                        <div class="am-u-sm-9 ">

                                            <div class="am-u-sm-9">
                                                <div class="am-u-sm-6">
                                                    <label class="am-radio-inline">
                                                        <#if goodsCats.isShow == 1>
                                                            <input type="radio" checked="checked" name="isShow" value="1" data-am-ucheck> 是
                                                        <#else >
                                                            <input type="radio" name="isShow" value="1" data-am-ucheck> 是
                                                        </#if>

                                                    </label>
                                                </div>

                                                <div class="am-u-sm-6">
                                                    <label class="am-radio-inline">
                                                        <#if goodsCats.isShow == 0>
                                                            <input type="radio" checked="checked" name="isShow" value="0" data-am-ucheck> 否
                                                        <#else>
                                                            <input type="radio" name="isShow" value="0" data-am-ucheck> 否
                                                        </#if>
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
                                                <button id="update_cat" type="button" class="am-btn am-btn-primary">提交</button>
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
    $('#my-select').chosen({ width: '95%'});

    //$('#add_cat_alert').alert('close');
    //提交表单
    $('#update_cat').on('click',function () {
        var form = $('#add_cat_form');
        var id = "${goodsCats.id}";
        var parentId = $('#my-select').val();
        var catName = $('#cat-name').val();
        var isShow = $("input[name='isShow']:checked").val();

        if(catName == null || catName == ""){
            alert("分类名称不能为空！");
            return;
        }
        if(parentId == null || parentId == ""){
            alert("父级分类不能为空！");
            return;
        }
        if(isShow == null || isShow == ""){
            alert("是否显示不能为空！");
            return;
        }
        var allData = {
            id:id,
            catName:catName,
            parentId:parentId,
            isShow:isShow
        };
        $.ajax({
            url:'/goods/cats/update.do',
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
                if(data.status == 0){
                    $('#add_cat_alert').attr("class","am-alert am-alert-success")
                    $('#add_cat_alert').show();
                    $('#show_message').text(data.msg);
                    setTimeout("$('#content').load('/goods/cats/view?page=1')",1000);
                }else {
                    $('#add_cat_alert').attr("class","am-alert am-alert-danger")
                    $('#add_cat_alert').show();
                    $('#show_message').text(data.msg);
                }
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