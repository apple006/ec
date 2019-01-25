package com.eryansky.configure.web;

import com.eryansky.core.web.filter.MySiteMeshFilter;
import com.eryansky.filters.ChinesePathFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Filter注册配置
 * @author : 尔演&Eryan eryanwcp@gmail.com
 * @date : 2019-01-23
 */
@Configuration
public class FilterConfiguration {

    /**
     * 中文
     * @return
     */
    @Bean
    public FilterRegistrationBean<ChinesePathFilter> getChinesePathFilter() {
        ChinesePathFilter filter = new ChinesePathFilter();
        FilterRegistrationBean<ChinesePathFilter> bean = new FilterRegistrationBean<>(filter);
        bean.setFilter(filter);
        return bean;
    }


    /**
     * SiteMesh自定义Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<MySiteMeshFilter> getMySiteMeshFilter() {
        MySiteMeshFilter filter = new MySiteMeshFilter();
        FilterRegistrationBean<MySiteMeshFilter> bean = new FilterRegistrationBean<>(filter);
//        bean.addInitParameter("sitemesh.configfile", "classpath:/WEB-INF/decorators.xml");
        bean.addInitParameter("sitemesh.configfile", "classpath:/META-INF/resources/WEB-INF/decorators.xml");
        bean.addInitParameter("blackListURL","/static/**");
        bean.addInitParameter("whiteListURL","/**");
        return bean;
    }
}
