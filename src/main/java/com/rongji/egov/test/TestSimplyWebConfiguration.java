package com.rongji.egov.test;

import com.rongji.egov.app.support.AppSupportConfiguration;
import com.rongji.egov.mybatis.base.annotation.ModelScan;
import com.rongji.egov.mybatis.web.interceptor.AclLoaderFilter;
import com.rongji.egov.mybatis.web.interceptor.NormalInterceptor;
import com.rongji.egov.security.service.SecurityServiceConfiguration;
import com.rongji.egov.test.filter.DefaultAclLoaderFilter;
import com.rongji.egov.test.filter.DefaultNormalInterceptor;
import com.rongji.egov.test.model.Bbs;
import com.rongji.egov.user.client.UserClientConfiguration;
import com.rongji.egov.utils.spring.configuration.ClientConfiguration;
import com.rongji.egov.utils.spring.configuration.IgnoredPathsConfiguration;
import com.rongji.egov.utils.spring.configuration.WebConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({"com.rongji.egov.test.mapper"})
@ModelScan(basePackageClasses = Bbs.class)
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@Import({WebConfiguration.class,
        SecurityServiceConfiguration.class,
        ClientConfiguration.class,
        UserClientConfiguration.class,
        AppSupportConfiguration.class,
        IgnoredPathsConfiguration.class
})
public class TestSimplyWebConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(TestSimplyWebConfiguration.class, args);
    }

    @Bean
    public AclLoaderFilter aclLoaderFilter() {
        return new DefaultAclLoaderFilter();
    }

    @Bean
    public NormalInterceptor normalInterceptor() {
        return new DefaultNormalInterceptor();
    }
}
