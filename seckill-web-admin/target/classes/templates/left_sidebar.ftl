<!-- 侧边导航栏 -->
<div class="left-sidebar">
    <!-- 用户信息 -->
    <div class="tpl-sidebar-user-panel">
        <div class="tpl-user-panel-slide-toggleable">
            <div class="tpl-user-panel-profile-picture">
                <img src="../assets/img/user04.png" alt="">
            </div>
            <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
            ${user.userName}
          </span>
            <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
        </div>
    </div>

    <!-- 菜单 -->
    <ul class="sidebar-nav">
        <#--<li class="sidebar-nav-heading">Components <span class="sidebar-nav-heading-info"> 附加组件</span></li>-->
        <li class="sidebar-nav-link">
            <a href="/index.do" class="active">
                <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
            </a>
        </li>
        <#--<li class="sidebar-nav-link">
            <a href="tables.html">
                <i class="am-icon-table sidebar-nav-link-logo"></i> 表格
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="calendar.html">
                <i class="am-icon-calendar sidebar-nav-link-logo"></i> 日历
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="/admin/form">
                <i class="am-icon-wpforms sidebar-nav-link-logo"></i> 表单

            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="chart.html">
                <i class="am-icon-bar-chart sidebar-nav-link-logo"></i> 图表

            </a>
        </li>-->

        <#--<li class="sidebar-nav-heading">Page<span class="sidebar-nav-heading-info"> 常用页面</span></li>-->
        <li class="sidebar-nav-link">
            <a href="javascript:;" class="sidebar-nav-sub-title">
                <i class="am-icon-table sidebar-nav-link-logo"></i> 资源
                <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
            </a>
            <ul class="am-tree sidebar-nav sidebar-nav-sub" id="firstTree">
                <li class="am-tree-branch am-hide sidebar-tree" data-template="treebranch">
                    <div class="am-tree-branch-header">
                        <button class="am-tree-branch-name">
                            <span class="am-tree-icon am-tree-icon-folder"></span>
                            <span class="am-tree-label"></span>
                        </button>
                    </div>
                    <ul class="am-tree-branch-children"></ul>
                    <div class="am-tree-loader"><span class="am-icon-spin am-icon-spinner"></span></div>
                </li>
                <li class="am-tree-item am-hide sidebar-tree" data-template="treeitem">
                    <button class="am-tree-item-name">
                        <span class="am-tree-icon am-tree-icon-item"></span>
                        <span class="am-tree-label"></span>
                    </button>
                </li>
            </ul>
            <#--<ul class="sidebar-nav sidebar-nav-sub">
                <li class="sidebar-nav-link">
                    <a href="/category.do">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 品类管理
                    </a>
                </li>

                <li class="sidebar-nav-link">
                    <a href="table-list-img.html">
                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图文列表
                    </a>
                </li>
            </ul>-->
        </li>
        <li class="sidebar-nav-link">
            <a href="sign-up.html">
                <i class="am-icon-clone sidebar-nav-link-logo"></i> 注册
                <span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="login.html">
                <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
            </a>
        </li>
        <li class="sidebar-nav-link">
            <a href="404.html">
                <i class="am-icon-tv sidebar-nav-link-logo"></i> 404错误
            </a>
        </li>

    </ul>
    <ul class="am-tree sidebar-nav sidebar-nav-sub" id="firstTree">
        <li class="am-tree-branch am-hide sidebar-tree" data-template="treebranch">
            <div class="am-tree-branch-header">
                <button class="am-tree-branch-name">
                    <span class="am-tree-icon am-tree-icon-folder"></span>
                    <span class="am-tree-label"></span>
                </button>
            </div>
            <ul class="am-tree-branch-children"></ul>
            <div class="am-tree-loader"><span class="am-icon-spin am-icon-spinner"></span></div>
        </li>
        <li class="am-tree-item am-hide sidebar-tree" data-template="treeitem">
            <button class="am-tree-item-name">
                <span class="am-tree-icon am-tree-icon-item"></span>
                <span class="am-tree-label"></span>
            </button>
        </li>
    </ul>
</div>
