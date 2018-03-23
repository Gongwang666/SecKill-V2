<div class="row-content am-cf">
    <div class="widget am-cf">
        <div class="widget-body">
            <div class="tpl-page-state">
                <div class="tpl-page-state-title am-text-center tpl-error-title">404</div>
                <div class="tpl-error-title-info">Page Not Found</div>
                <div class="tpl-page-state-content tpl-error-content">
                    <p>${message}</p>
                    <#--<button type="button" class="am-btn am-btn-secondary am-radius tpl-error-btn">Back Home</button></div>-->
                    <#if url?exists>
                        <a href="${url}">转</a>
                    </#if>
            </div>
        </div>
    </div>
</div>