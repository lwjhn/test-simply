package com.rongji.egov.test;

import com.alibaba.fastjson.JSON;
import com.rongji.egov.datasource.DataSourceHolder;
import com.rongji.egov.datasource.MultiDataSourceAspect;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.security.SecurityUser;
import com.rongji.egov.security.SecurityUtils;
import com.rongji.egov.test.model.BbsCommon;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDatasource {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void test2(){

    }

    @Test
    public void test1() {
        SQLSelector selector = Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, BbsCommon.class)
                .set(SQLSelector::setFields, SQLWrapper.getSqlFields(BbsCommon.class))
                .set(SQLSelector::setWhere, new SQLCriteria("subject LIKE ?", "%7881596096100CA5482586FB000BBFD8%"))
                .set(SQLSelector::setLimit, 0, 5)
                .build();

        Arrays.asList("szf","test","sft", "none").forEach(type -> {
            for (int i = 0; i < 100; i++)
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (2000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    MultiDataSourceAspect.setDataSourceType(Thread.currentThread().getName().replaceAll("\\d+$",""));
                    //DataSourceHolder.setDataSourceType(Thread.currentThread().getName().replaceAll("\\d+$",""));
                    Page<BbsCommon> result = baseMapper.select(new SelectPageQuerier<BbsCommon>().setResultMap(BbsCommon.class).setSqlHandler(SerializationUtils.clone(selector)));
                    System.out.println(Thread.currentThread().getName() + ": " + JSON.toJSONString(result));
                    if(result!=null && result.getList().size()>0){
                        Assert.assertTrue("不匹配！", result.getList().get(0).getSubject().startsWith("none".equals(DataSourceHolder.getDataSourceType()) ? "szf" : DataSourceHolder.getDataSourceType()));
                    }
                }, type + i).start();
        });
    }
}
