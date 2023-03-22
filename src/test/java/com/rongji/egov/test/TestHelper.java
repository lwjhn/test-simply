package com.rongji.egov.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rongji.egov.datasource.DataSourceHandler;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.dac.handler.Acl;
import com.rongji.egov.mybatis.web.help.DacQuerySample;
import com.rongji.egov.mybatis.web.help.DefaultQuerySample;
import com.rongji.egov.mybatis.web.help.Helper;
import com.rongji.egov.mybatis.web.help.QuerySampleHelper;
import com.rongji.egov.security.SecurityUser;
import com.rongji.egov.security.ServiceSecurityUser;
import com.rongji.egov.test.model.BbsCommon;
import com.rongji.egov.utils.common.IdUtil;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("migration_rms_resource")
public class TestHelper {
    @Resource
    QuerySampleHelper helper;
    @Resource
    ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestHelper.class);

    public SQLSelector selector() {
        return Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, BbsCommon.class)
                .set(SQLSelector::setFields, SQLWrapper.getSqlFields(BbsCommon.class))
                .set(SQLSelector::setWhere, new SQLCriteria(LambdaHelper.fieldName(BbsCommon::getSubject) + " LIKE ?", "%7881596096100CA5482586FB000BBFD8%"))
                .set(SQLSelector::setLimit, 0, 5)
                .build();
    }

    @Test
    public void testDac() throws JsonProcessingException {
        DataSourceHandler.set("default");

        setTestingAuthenticationToken("U000032", "BIGDATA");

        DacQuerySample<BbsCommon> querySample = helper.dac(BbsCommon.class).reset();
        Acl acl = querySample.getAcl();

        test(querySample);
    }

    @Test
    public void testQuery() throws JsonProcessingException {
        DataSourceHandler.set("default");
        test(helper.nac(BbsCommon.class));
    }

    public void test(DefaultQuerySample<BbsCommon> querySample) throws JsonProcessingException {
        BbsCommon bbsCommon = querySample.selectByPrimaryKey("154c74b4194a0000");
        LOGGER.info("{}", objectMapper.writeValueAsString(bbsCommon));

        bbsCommon.setSubject("测试通知-" + new Date().getTime());
        LOGGER.info("update count: {}", querySample.updateByPrimaryKey(bbsCommon));

        bbsCommon = querySample.selectByPrimaryKey(bbsCommon.getId());
        LOGGER.info("{}", objectMapper.writeValueAsString(bbsCommon));

        bbsCommon.setSubject(bbsCommon.getSubject() + "-" + new Date().getTime());
        bbsCommon.setContent(null);
        LOGGER.info("update count: {}", querySample.updateByPrimaryKey(Helper.toMapNonNull(bbsCommon)));

        // insert
        bbsCommon = SerializationUtils.clone(bbsCommon);
        bbsCommon.setId(IdUtil.getUID());
        LOGGER.info("insert id : {}", bbsCommon.getId());
        querySample.insert(bbsCommon);

        // list
        List<BbsCommon> list = querySample.selectList(Helper.WRAPPER.or()
                .like(BbsCommon::getSubject, "%测试%")
                .like(BbsCommon::getSubject, "%通知%").end());
        LOGGER.info("{}", objectMapper.writeValueAsString(list));

        // list => limit 0, 20
        list = querySample.selectList(Helper.WRAPPER.or()
                .like(BbsCommon::getSubject, "%测试%")
                .like(BbsCommon::getSubject, "%通知%").end(), handle -> {
            handle.getSqlHandler().setLimit(0, 20);
        });
        LOGGER.info("{}", objectMapper.writeValueAsString(list));

        // page
        Page<BbsCommon> page = querySample.selectPage(new SQLCriteria(
                "subject like ? or subject like ?", Arrays.asList("%测试%", "%通知%")));
        LOGGER.info("{}", objectMapper.writeValueAsString(page));

        // page
        page = querySample.selectPage(Helper.WRAPPER.or()
                .like(BbsCommon::getSubject, "%测试%")
                .like(BbsCommon::getSubject, "%通知%").end());
        LOGGER.info("{}", objectMapper.writeValueAsString(page));

        // list => limit 10, 15
        page = querySample.selectPage(Helper.WRAPPER.or()
                .like(BbsCommon::getSubject, "%测试%")
                .like(BbsCommon::getSubject, "%通知%").end(), handle -> {
            SQLSelector selector = handle.getSqlHandler();
            selector.setLimit(10, 15);
            //[ORDER BY字段1 [ASC | DESC ][, expression [ASC | DESC ]][, ...]]]  String, List<String> or Set<String> or SQLCriteria
            selector.setOrder("subject DESC");
        });
        LOGGER.info("{}", objectMapper.writeValueAsString(page));
    }

    public static void setTestingAuthenticationToken(String name, String systemNo) {
        LOGGER.debug("=============thread name : {}=============", Thread.currentThread().getName());
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(new ServiceSecurityUser(
                Builder.register(SecurityUser::new)
                        .set(SecurityUser::setUsername, name)
                        .set(SecurityUser::setSystemNo, systemNo)
                        .set(SecurityUser::setAuthorities, new HashSet<GrantedAuthority>() {{
                            add(ServiceSecurityUser.ROLE_service);
                        }})
                        .set(SecurityUser::setEnabled, true)
                        .set(SecurityUser::setCredentialsNonExpired, true)
                        .set(SecurityUser::setAccountNonExpired, true)
                        .set(SecurityUser::setAccountNonLocked, true)
                        .build()), null));
    }
}
