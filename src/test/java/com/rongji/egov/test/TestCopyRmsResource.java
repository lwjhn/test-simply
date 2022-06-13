package com.rongji.egov.test;

import com.rongji.egov.datasource.DataSourceHandler;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.builder.assistant.function.UniFunction;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectListQuerier;
import com.rongji.egov.mybatis.base.querier.SelectOneQuerier;
import com.rongji.egov.mybatis.base.querier.UpdateQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLField;
import com.rongji.egov.mybatis.base.sql.SQLInserter;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.test.model.RmsResource;
import com.rongji.egov.utils.common.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("migration_rms_resource")
public class TestCopyRmsResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCopyRmsResource.class);
    @Resource
    BaseMapper baseMapper;

    @Test
    public void testQuery() {
        //migrationRmsResource();
    }

    public void migrationRmsResource() {
        final String sourceHolder = "SFTOA",
                targetHolder = "ROOT",
                modelID = "%dev%";
        final SQLCriteria sqlCriteria = new SQLCriteria(String.format("%s LIKE ?",
                LambdaHelper.fieldName(RmsResource::getResourceNo)), modelID);

        DataSourceHandler.set(sourceHolder);
        Page<?> page = baseMapper.select(new SelectOneQuerier<Page<?>>().setResultMap(Page.class).setSqlHandler(Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, RmsResource.class)
                .set(SQLSelector::setFields, Collections.singletonList(new SQLField("count(1)", LambdaHelper.fieldName((UniFunction<Page<?>, Object>) Page::getTotal))))
                .set(SQLSelector::setWhere, new SQLCriteria(String.format("%s LIKE ?", LambdaHelper.fieldName(RmsResource::getResourceNo)), "%dev%"))
                .build()));
        final int total = page.getTotal();
        final int row = 5;
        SQLSelector selector = Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, RmsResource.class)
                .set(SQLSelector::setFields, SQLWrapper.getSqlFields(RmsResource.class))
                .set(SQLSelector::setLimit, 0, row)
                .set(SQLSelector::setWhere, sqlCriteria)
                .build();
        SelectListQuerier<RmsResource> querier = (SelectListQuerier<RmsResource>) new SelectListQuerier<RmsResource>().setResultMap(RmsResource.class).setSqlHandler(selector);

        LOGGER.debug("total: {}", page.getTotal());
        int suc = 0;
        for (int i = 0; i < total; i += row) {
            selector.setLimit(i, row);
            DataSourceHandler.set(sourceHolder);
            List<RmsResource> response = baseMapper.select(querier);
            LOGGER.debug("offset: {}, rows: {}", i, response.size());
            DataSourceHandler.set(targetHolder);
            for (RmsResource code : response) {
                code.setId(IdUtil.getUID());
                code.setSystemNo(targetHolder);
                suc += baseMapper.update(new UpdateQuerier().setSqlHandler(new SQLInserter(code)));
            }
        }
        LOGGER.debug("total: {}, success: {}", page.getTotal(), suc);
    }
}
