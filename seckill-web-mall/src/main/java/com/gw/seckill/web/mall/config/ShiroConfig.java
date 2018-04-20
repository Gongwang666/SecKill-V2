package com.gw.seckill.web.mall.config;

import com.google.common.collect.Maps;
import com.gw.seckill.constants.ConstantClassFunction;
import com.gw.seckill.web.mall.cache.SpringCacheManagerWrapper;
import com.gw.seckill.web.mall.credentials.RetryLimitHashedCredentialsMatcher;
import com.gw.seckill.web.mall.filter.KickoutSessionControlFilter;
import com.gw.seckill.web.mall.filter.URLPermissionsFilter;
import com.gw.seckill.web.mall.realm.UserRealm;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.Map;

@Configuration
@Import({SpringCacheConfig.class})
public class ShiroConfig {
	
	/**
	 * FilterRegistrationBean
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter")); 
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*"); 
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
	}
	
	/**
	 * @see ShiroFilterFactoryBean
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager,
											  KickoutSessionControlFilter kickoutSessionControlFilter){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl("/user/login");
		bean.setUnauthorizedUrl("/404");
		
		Map<String, Filter>filters = Maps.newHashMap();
		filters.put("kickout",kickoutSessionControlFilter);
		filters.put("anon", new AnonymousFilter());
		filters.put("perms", urlPermissionsFilter());
		bean.setFilters(filters);
		
		Map<String, String> chains = Maps.newHashMap();
		chains.put("/**", "perms,kickout");
		bean.setFilterChainDefinitionMap(chains);
		return bean;
	}
	
	/**
	 * @see org.apache.shiro.mgt.SecurityManager
	 * @return
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager(SpringCacheManagerWrapper shiroCacheManager,
													 UserRealm userRealm,
													 DefaultWebSessionManager defaultWebSessionManager) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(userRealm);
		manager.setCacheManager(shiroCacheManager);
		manager.setSessionManager(defaultWebSessionManager);
		return manager;
	}
	
	/**
	 * 会话管理器设置
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager(SpringCacheManagerWrapper shiroCacheManager) {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setCacheManager(shiroCacheManager);
		sessionManager.setGlobalSessionTimeout(1800000);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setDeleteInvalidSessions(true);
		return sessionManager;
	}
	
	/**
	 * 自定义域
	 * @see UserRealm--->AuthorizingRealm
	 * @return
	 */
	@Bean
	@DependsOn(value="lifecycleBeanPostProcessor")
	public UserRealm userRealm(SpringCacheManagerWrapper shiroCacheManager,RetryLimitHashedCredentialsMatcher credentialsMatcher) {
		UserRealm userRealm = new UserRealm();
		//启用缓存
		userRealm.setCachingEnabled(true);
		//注入缓存管理器
		userRealm.setCacheManager(shiroCacheManager);
		//容许授权使用缓存
		userRealm.setAuthorizationCachingEnabled(true);
		//容许认证使用缓存
		userRealm.setAuthenticationCachingEnabled(true);
		//设置使用哪个缓存，name对应ecache.xml配置文件中的定义
		userRealm.setAuthorizationCacheName("authorizationCache");
		//不加这句会报空指针异常
		userRealm.setAuthorizationCache(shiroCacheManager.<Object, AuthorizationInfo>getCache("authorizationCache"));
		userRealm.setAuthenticationCacheName("authenticationCache");
		userRealm.setCredentialsMatcher(credentialsMatcher);
		return userRealm;
	}
	/**
	　* @描述:     自定义URL过滤器
	　* @参数描述: 
	　* @返回值:
	　* @异常:     
	　* @作者:     gongwang
	　* @创建时间: 2018/1/17 21:11
	  */
	@Bean
	public URLPermissionsFilter urlPermissionsFilter() {
		return new URLPermissionsFilter();
	}
	/**
	　* @描述:     将缓存管理器添加到bean容器
	　* @参数描述: 
	　* @返回值:
	　* @异常:     
	　* @作者:     gongwang
	　* @创建时间: 2018/1/17 21:11
	  */
	@Bean
	public SpringCacheManagerWrapper shiroCacheManager(EhCacheCacheManager springCacheManager) {
		SpringCacheManagerWrapper springCacheManagerWrapper = new SpringCacheManagerWrapper();
		springCacheManagerWrapper.setCacheManager(springCacheManager);
		return springCacheManagerWrapper;
	}
	
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean(name = "sessionIdGenerator")
	public JavaUuidSessionIdGenerator javaUuidSessionIdGenerator(){
		return new JavaUuidSessionIdGenerator();
	}
	/**
	　* @描述:     自定义认证匹配器
	　* @参数描述: 缓存管理器
	　* @返回值:
	　* @异常:     
	　* @作者:     gongwang
	　* @创建时间: 2018/1/17 21:12
	  */
	@Bean
	public RetryLimitHashedCredentialsMatcher credentialsMatcher(SpringCacheManagerWrapper shiroCacheManager){
		RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(shiroCacheManager);
		credentialsMatcher.setHashAlgorithmName(ConstantClassFunction.getALGORITHM_NAME());
		credentialsMatcher.setHashIterations(ConstantClassFunction.getHASH_ITERATIONS());
		credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}
	@Bean
	public KickoutSessionControlFilter kickoutSessionControlFilter(DefaultWebSessionManager sessionManager,
																   SpringCacheManagerWrapper shiroCacheManager){
		KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
		//kickoutAfter：是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；
		kickoutSessionControlFilter.setKickoutAfter(false);
		kickoutSessionControlFilter.setMaxSession(1);
		kickoutSessionControlFilter.setSessionManager(sessionManager);
		kickoutSessionControlFilter.setCacheManager(shiroCacheManager);
		kickoutSessionControlFilter.setKickoutUrl("/user/login");
		return kickoutSessionControlFilter;
	}
	//会话ID生成器
	@Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator(){
	    return new JavaUuidSessionIdGenerator();
    }
    @Bean
    public SimpleCookie sessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        simpleCookie.setHttpOnly(true);
        //30天
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }
    //会话DAO
	@Bean
    public EnterpriseCacheSessionDAO sessionDAO(JavaUuidSessionIdGenerator sessionIdGenerator){
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        sessionDAO.setSessionIdGenerator(sessionIdGenerator);
        return sessionDAO;
    }
	//会话验证调度器
	@Bean
	public QuartzSessionValidationScheduler quartzSessionValidationScheduler(DefaultWebSessionManager sessionManager){
        QuartzSessionValidationScheduler quartzSessionValidationScheduler = new QuartzSessionValidationScheduler();
        quartzSessionValidationScheduler.setSessionManager(sessionManager);
        quartzSessionValidationScheduler.setSessionValidationInterval(1800000);
        return quartzSessionValidationScheduler;
    }

	//会话管理器
	@Bean
	public DefaultWebSessionManager sessionManager(
			QuartzSessionValidationScheduler quartzSessionValidationScheduler,
			EnterpriseCacheSessionDAO sessionDAO,
			SimpleCookie sessionIdCookie){
		DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
		defaultWebSessionManager.setGlobalSessionTimeout(1800000);
		defaultWebSessionManager.setDeleteInvalidSessions(true);
		defaultWebSessionManager.setSessionValidationSchedulerEnabled(true);
		defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
		defaultWebSessionManager.setSessionValidationScheduler(quartzSessionValidationScheduler);
		defaultWebSessionManager.setSessionDAO(sessionDAO);
		defaultWebSessionManager.setSessionIdCookieEnabled(true);
		defaultWebSessionManager.setSessionIdCookie(sessionIdCookie);
		return defaultWebSessionManager;
	}
}