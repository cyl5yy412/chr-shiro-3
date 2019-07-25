package com.chryl.config;

import com.chryl.cache.MyRedisCacheManager;
import com.chryl.cache.RedisCache;
import com.chryl.realm.MyShiroRealm;
import com.chryl.session.ConsumerSessionManager;
import com.chryl.session.MyRedisSessionDao;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Chr on 2019/7/23.
 */
@Configuration
public class ShiroConfig {

    //添加创建securityManager的工厂类注入bean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //没有授权通过访问的地址
        shiroFilterFactoryBean.setLoginUrl("/login.html");

        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/404.html");

        Map<String, String> perms = new HashMap<String, String>();
        /**
         * 设置权限认证过滤器:路径,过滤器
         * anon : 可以匿名访问
         * authc: 必须通过认证，授权后才能访问
         */
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        perms.put("/logout", "logout");
        perms.put("/login.html", "anon");
        perms.put("/index.html", "anon");
        perms.put("/user/login", "anon");//login不认证
        perms.put("/user/error", "anon");//login不认证

        //权限过滤
//        perms.put("/**", "perms[system]");
//        perms.put("/**", "roles[system]");
//        perms.put("/user/**", "perms[user:manager]");
//        perms.put("/sb/**", "perms[user:manager]");
//        perms.put("/user/**", "perms[sb:manager]");
//        perms.put("/sb/**", "perms[sb:manager]");

        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        perms.put("/**", "authc");


        //把权限过滤map设置shiroFilterFactoryBean
        shiroFilterFactoryBean.setFilterChainDefinitionMap(perms);

        return shiroFilterFactoryBean;
    }

    //创建SecurityManager类的注入bean
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") MyShiroRealm shiroRealm,
                                                                  @Qualifier("sessionManager") ConsumerSessionManager sessionManager,
                                                                  @Qualifier("cacheManager") MyRedisCacheManager cacheManager,
                                                                  @Qualifier("cookieRememberMe") CookieRememberMeManager cookieRememberMe) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        //session
        securityManager.setSessionManager(sessionManager);
        //缓存
        securityManager.setCacheManager(cacheManager);
        //记住我
        securityManager.setRememberMeManager(cookieRememberMe);
        return securityManager;
    }

    //创建自定义realm域类的注入bean
    @Bean(name = "shiroRealm")
    public MyShiroRealm getMyShiroRealm() {
        MyShiroRealm shiroRealm = new MyShiroRealm();
        return shiroRealm;
    }


    /**
     * 开启Shiro注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //////////////////////
//    @Bean(name = "sessionManager")
//    public DefaultWebSessionManager securityManager(@Qualifier("myRedisSessionDao") MyRedisSessionDao myRedisSessionDao) {
//        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
//        defaultWebSessionManager.setSessionDAO(myRedisSessionDao);
//        return defaultWebSessionManager;
//    }

    //session自管理
    //自定义sessionManager
    @Bean(name = "sessionManager")
    public ConsumerSessionManager securityManager(@Qualifier("myRedisSessionDao") MyRedisSessionDao myRedisSessionDao) {
        ConsumerSessionManager consumerSessionManager = new ConsumerSessionManager();
        consumerSessionManager.setSessionDAO(myRedisSessionDao);
        return consumerSessionManager;
    }

    //缓存
    @Bean(name = "cacheManager")
    public MyRedisCacheManager myRedisCacheManager() {
        return new MyRedisCacheManager();
    }


    //记住我登录
    @Bean(name = "cookieRememberMe")
    public CookieRememberMeManager cookieRememberMeManager() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(6000);//存活时间,单位s
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie);
        return cookieRememberMeManager;
    }


}
