package com.gw.seckill.web.mall.filter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.service.UserFacade;
//import com.gw.seckill.web.admin.enums.EnumWithOutPermissionUrls;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component("urlPermissionsFilter")
public class URLPermissionsFilter extends PermissionsAuthorizationFilter{
	@Reference(version = "1.0.0")
	private UserFacade userFacade;

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		if(SecurityUtils.getSubject().getPrincipal()!=null){
			return true;
		}
		return super.onAccessDenied(request, response, mappedValue);
	}

	/**
	 * 获取当前URL+Parameter
	 * @author lance
	 * @since  2014年12月18日 下午3:09:26
	 * @param request	拦截请求request
	 * @return			返回完整URL
	 */
	private String getRequestUrl(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest)request;
		String queryString = req.getQueryString();

		queryString = StringUtils.isBlank(queryString)?"": "?"+queryString;
		return req.getRequestURI()+queryString;
	}
}
