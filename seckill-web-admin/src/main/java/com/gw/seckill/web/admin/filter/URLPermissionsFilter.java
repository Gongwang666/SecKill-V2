package com.gw.seckill.web.admin.filter;

import java.io.IOException;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.service.UserFacade;
import com.gw.seckill.web.admin.enums.EnumWithOutPermissionUrls;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.springframework.stereotype.Component;


@Component("urlPermissionsFilter")
public class URLPermissionsFilter extends PermissionsAuthorizationFilter{
	@Reference(version = "1.0.0")
	private UserFacade userFacade;

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		String curUrl = getRequestUrl(request);
		String url = StringUtils.substringBefore(curUrl,";");
		Subject subject = SecurityUtils.getSubject();
		//属于不需要权限的URL放行
		for(EnumWithOutPermissionUrls e :EnumWithOutPermissionUrls.values()){
			if(e.getUrl().equals(url)){
				return true;
			}
		}
		//访问静态资源不需要权限，放行
		if(StringUtils.endsWithAny(curUrl, ".js",".css",".html")
				||StringUtils.endsWithAny(curUrl, ".jpg",".png",".gif", ".jpeg")
				||StringUtils.startsWith(curUrl,"/assets")) {
			return true;
		}
		//如果用户登录了且访问的是主页，放行
		if(subject.getPrincipal()!=null&&url.equals("/index.do")){
			return true;
		}
		//获得用户的可访问URL列表
		//Set<String> urlSet = userFacade.findPermissionUrl((String)subject.getPrincipal());
		//如果没有权限，返回false
		//return urlSet.contains(url);
		return false;
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
