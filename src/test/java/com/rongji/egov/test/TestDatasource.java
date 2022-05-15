package com.rongji.egov.test;

import com.alibaba.fastjson.JSON;
import com.rongji.egov.datasource.DataSourceHandler;
import com.rongji.egov.datasource.DataSourceHolder;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.security.SecurityUser;
import com.rongji.egov.security.ServiceSecurityUser;
import com.rongji.egov.test.model.BbsCommon;
import com.rongji.egov.test.service.TestBbsService;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDatasource {
    @Resource
    BaseMapper baseMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDatasource.class);

    public SQLSelector selector(){
        return Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, BbsCommon.class)
                .set(SQLSelector::setFields, SQLWrapper.getSqlFields(BbsCommon.class))
                .set(SQLSelector::setWhere, new SQLCriteria(LambdaHelper.fieldName(BbsCommon::getSubject) + " LIKE ?", "%7881596096100CA5482586FB000BBFD8%"))
                .set(SQLSelector::setLimit, 0, 5)
                .build();
    }

    @Resource
    TestBbsService testBbsService;

    @Test
    public void testTransaction() {
        setTestingAuthenticationToken("U" + Math.round(Math.random() * 100000),
                "sft");
        LOGGER.debug("===== 1. testTransaction: {} => {} =====", DataSourceHolder.getDataSourceType(), DataSourceHandler.handler());
        testBbsService.updateBbs("13d86041688b3000", bbsCommon -> {
            DataSourceHandler.set("test");
            LOGGER.debug("===== 2. testTransaction: {} => {} =====", DataSourceHolder.getDataSourceType(), DataSourceHandler.handler());
            testBbsService.updateBbs("MM3d8604168b3000", bbsCommon1 -> {
                LOGGER.debug("===== 3. testTransaction: {} => {} =====", DataSourceHolder.getDataSourceType(), DataSourceHandler.handler());
                return null;
            });
            LOGGER.debug("===== 4. testTransaction: {} => {} =====", DataSourceHolder.getDataSourceType(), DataSourceHandler.handler());
            return bbsCommon;
        });
        LOGGER.debug("===== 5. testTransaction: {} => {} =====", DataSourceHolder.getDataSourceType(), DataSourceHandler.handler());
    }

    @Test
    public void test1() {
        SQLSelector selector = selector();
        Arrays.asList("szf","test","sft", "none").forEach(type -> {
            for (int i = 0; i < 100; i++)
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (2000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //DataSourceHandler.set(Thread.currentThread().getName().replaceAll("\\d+$",""));
                    setTestingAuthenticationToken("U" + Math.round(Math.random() * 100000),
                            Thread.currentThread().getName().replaceAll("\\d+$",""));

                    Page<BbsCommon> result = baseMapper.select(new SelectPageQuerier<BbsCommon>().setResultMap(BbsCommon.class).setSqlHandler(SerializationUtils.clone(selector)));
                    System.out.println(Thread.currentThread().getName() + ": " + JSON.toJSONString(result));
                    if(result!=null && result.getList().size()>0){
                        Assert.assertTrue("不匹配！", result.getList().get(0).getSubject().startsWith("none".equals(DataSourceHolder.getDataSourceType()) ? "szf" : DataSourceHolder.getDataSourceType()));
                    }
                }, type + i).start();
        });
    }

    public static void setTestingAuthenticationToken(String name, String systemNo){
        LOGGER.debug("=============thread name : {}=============", Thread.currentThread().getName());
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(new ServiceSecurityUser(
                Builder.register(SecurityUser::new)
                        .set(SecurityUser::setUsername, name)
                        .set(SecurityUser::setSystemNo, systemNo)
                        .set(SecurityUser::setAuthorities, new HashSet<GrantedAuthority>(){{add(ServiceSecurityUser.ROLE_service);}})
                        .build()), null));
    }

    @Test
    public void test2(){
        Set<Object> holders = DataSourceHandler.targetDataSourceHolders();
        System.out.println(JSON.toJSONString(holders));
    }
}
