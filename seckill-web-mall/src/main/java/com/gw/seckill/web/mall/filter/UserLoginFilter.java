package com.gw.seckill.web.mall.filter;

import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.web.mall.enums.PermissionsEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class UserLoginFilter extends PathMatchingFilter {
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if(user != null){
            HttpServletResponse res = (HttpServletResponse)response;
            res.sendRedirect("/home");
            return false;
        }else{
            return true;
        }

    }
}
