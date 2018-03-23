<!DOCTYPE html>
<html lang="en">

<head>
   <#include "head_resources.ftl">
</head>

<body data-type="login">
    <script src="../assets/js/theme.js"></script>
    <#if message?exists>
       <div class="am-alert am-alert-danger" data-am-alert>
           <button type="button" class="am-close">&times;</button>
           <p>${message}</p>
       </div>
    </#if>
    <div class="am-g tpl-g">
        <!-- 风格切换 -->
        <#include "change_style.ftl">
        <!-- 登录 -->
        <div class="tpl-login">
            <div class="tpl-login-content">

                <div class="tpl-login-logo">

                </div>

                <form id="login-form" action="/user/login.do" method="post" enctype="multipart/form-data" name="sysUser" class="am-form tpl-form-line-form" >
                    <div class="am-form-group">
                        <input type="text" name="userName" class="tpl-form-input" id="user-name" placeholder="请输入账号">

                    </div>

                    <div class="am-form-group">
                        <input type="password" name="passWord" class="tpl-form-input" id="user-name" placeholder="请输入密码">

                    </div>
                    <div class="am-form-group tpl-login-remember-me">
                        <input id="remember-me" type="checkbox">
                        <label for="remember-me">
       
                        记住密码
                         </label>

                    </div>

                    <div class="am-form-group">

                        <button id="login-submit" type="button" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">提交</button>

                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="../assets/js/amazeui.min.js"></script>
    <script src="../assets/js/app.js"></script>
    <script>
        //登录提交表单
        $('#login-submit').on('click',function () {
            $('#login-form').submit();
        });
    </script>
</body>

</html>