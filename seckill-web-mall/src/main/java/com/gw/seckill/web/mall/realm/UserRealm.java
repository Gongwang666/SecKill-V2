package com.gw.seckill.web.mall.realm;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.entity.SysUser;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.admin.service.UserFacade;
import com.gw.seckill.facade.mall.service.UserInfoFacade;
import com.gw.seckill.web.mall.cache.SpringCacheManagerWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

	@Reference(version = "1.0.0")
	private UserInfoFacade userInfoFacade;
	@Autowired
	private SpringCacheManagerWrapper shiroCacheManager;
	private Cache<String, Set<String>> authorizationCache;

/*	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}*/

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/*authorizationCache = shiroCacheManager.getCache("authorizationCache");
		String username = (String) principals.getPrimaryPrincipal();
		//取缓存
		Set<String> permissions = authorizationCache.get(username);*/
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//如果缓存中没有授权信息，去数据库查寻
		/*if(permissions == null){
			permissions = userFacade.findPermissions(username);
			authorizationCache.put(username,permissions);
			info.setStringPermissions(permissions);
		}else {
			info.setStringPermissions(permissions);
		}*/

		return info;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = upt.getUsername();
		User user = userInfoFacade.queryUserByAccount(userName);

		if (user == null) {
			throw new UnknownAccountException();
		}
		if(user.getDataFlag() == 1) {
			throw new LockedAccountException(); //帐号锁定
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,
				user.getPassWord(),
				ByteSource.Util.bytes(userName+user.getSalt()),
				getName());
		user.setPassWord("");
		user.setSalt("");
		SecurityUtils.getSubject().getSession().setAttribute("user",user);
		return info;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}