package com.rongji.egov.test;

import com.alibaba.fastjson.JSON;
import com.rongji.egov.datasource.DataSourceHandler;
import com.rongji.egov.datasource.DataSourceHolder;
import com.rongji.egov.datasource.cloud.DataSourceInjector;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import com.rongji.egov.test.model.BbsCommon;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("cloud")
public class TestDatasourceCloud {
    @Resource
    BaseMapper baseMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDatasourceCloud.class);

    public SQLSelector selector() {
        return Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, BbsCommon.class)
                .set(SQLSelector::setFields, SQLWrapper.getSqlFields(BbsCommon.class))
                .set(SQLSelector::setWhere, new SQLCriteria(LambdaHelper.fieldName(BbsCommon::getSubject) + " LIKE ?", "%7881596096100CA5482586FB000BBFD8%"))
                .set(SQLSelector::setLimit, 0, 5)
                .build();
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(20000);

        SQLSelector selector = selector();
        LOGGER.debug("======holders : {} =======", DataSourceHandler.targetDataSourceHolders().stream().map(String::valueOf).collect(Collectors.joining(", ")));
        DataSourceHandler.targetDataSourceHolders().forEach(type -> {
            LOGGER.debug("=== NEW THEAD FOR DATASOURCE {} ===", type);
            for (int i = 0; i < 100; i++)
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (2000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    DataSourceHandler.set(Thread.currentThread().getName().replaceAll("\\d+$",""));
                    /*setTestingAuthenticationToken("U" + Math.round(Math.random() * 100000),
                            Thread.currentThread().getName().replaceAll("\\d+$", ""));*/

                    Page<BbsCommon> result = baseMapper.select(new SelectPageQuerier<BbsCommon>().setResultMap(BbsCommon.class).setSqlHandler(SerializationUtils.clone(selector)));
                    System.out.println(Thread.currentThread().getName() + ": " + JSON.toJSONString(result));
                    if (result != null && result.getList().size() > 0) {
                        Assert.assertTrue("不匹配！", result.getList().get(0).getSubject().startsWith("none".equals(DataSourceHolder.getDataSourceType()) ? "szf" : DataSourceHolder.getDataSourceType()));
                    }
                }, type.toString() + i).start();
        });
    }

    @Resource
    DataSourceInjector dataSourceInjector;
    @Test
    public void test2() {
        InputStream is = null;
        try {
            is = TestDatasourceCloud.class.getClassLoader().getResourceAsStream("test111.yml");
            Yaml yaml= new Yaml();
            Object o = yaml.load(is);

            dataSourceInjector.formYaml(new HashMap<String, String>(){{
                put("szf1", yaml.dump(o));
            }});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AutoCloseableBase.close(is);
        }

    }
}
