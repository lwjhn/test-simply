package com.rongji.egov.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.function.UniFunction;
import com.rongji.egov.mybatis.base.pattern.SQLFactory;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.test.model.Bbs;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("cloud")
public class TestEnv {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDatasourceCloud.class);

    @Resource
    ConfigurableEnvironment environment;

    @Test
    public void test12() throws Exception {
        LOGGER.debug("spring.profiles.active: {} , spring.datasource-multi-enable: {}", environment.getProperty("spring.profiles.active"),
                environment.getProperty("spring.datasource-multi-enable"));
    }

    @Test
    public void test33() throws Exception {
        SQLCriteria criteria = SQLWrapper.WRAPPER.and()
                .like(Bbs::getId, "abcd")
                .like(SQLWrapper.field(Bbs::getSubject), "测试")
                .or()
                .eq(SQLWrapper.field(Bbs::getDraftDeptNo), "D000001")
                .likeRight(true, "draftUserNo", "D000")
                .lt(SQLWrapper.field(Bbs::getCreateDate), new Date())
                .ge(Bbs::getCreateDate, "2011-01-01")
                .not()
                .isNotNull(Bbs::getStatus).end();
        System.out.println(SQLFactory.generate(
                SQLWrapper.builder(() -> SQLWrapper.selectors(Bbs.class))
                        .set(SQLSelector::setWhere, criteria)
                        .build()
        ));
    }

    @Test
    public void test1() {
        StandardEnvironment env = new StandardEnvironment();
        // 1. 操作系统的环境变量
        Map<String, Object> systemEnvironment = env.getSystemEnvironment();
        Assert.assertNotNull(systemEnvironment);

        // 2. JVM 属性配置
        Map<String, Object> systemProperties = env.getSystemProperties();
        Assert.assertNotNull(systemProperties);

        // 3. 属性
        Assert.assertEquals("UTF-8", env.getProperty("file.encoding"));
        Assert.assertTrue(env.containsProperty("file.encoding"));

        // 4. 剖面 spring.profiles.default(默认为 default) spring.profiles.active
        //    只要有一个返回 true acceptsProfiles 方法就返回 true，!a 为不包含该 profiles
//        Assert.assertTrue(env.acceptsProfiles("default"));
//        Assert.assertTrue(env.acceptsProfiles("a", "default"));
//        Assert.assertFalse(env.acceptsProfiles("a"));
//        Assert.assertTrue(env.acceptsProfiles("!a", "b"));
    }

    @Test
    public void PropertyResolverTest() {
        PropertySource<?> propertySource = new MapPropertySource("source",
                Collections.singletonMap("name", "test"));
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addFirst(propertySource);
        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

        Assert.assertEquals("test", propertyResolver.getProperty("name"));
        Assert.assertEquals("name is test", propertyResolver.resolvePlaceholders("name is ${name}"));
    }

    @Test
    public void test(){
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("12345678");
        String code = standardPBEStringEncryptor.encrypt("加密密文");
        LOGGER.debug("code: {}", code);
        LOGGER.debug("decrypt: {}", standardPBEStringEncryptor.decrypt(code));
    }
}
