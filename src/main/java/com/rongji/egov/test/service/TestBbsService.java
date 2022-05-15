package com.rongji.egov.test.service;

import com.rongji.egov.datasource.DataSourceHandler;
import com.rongji.egov.datasource.DataSourceHolder;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.querier.SelectOneQuerier;
import com.rongji.egov.mybatis.base.querier.UpdateQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.sql.SQLUpdater;
import com.rongji.egov.test.model.BbsCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.function.Function;

@Service
public class TestBbsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBbsService.class);

    @Resource
    BaseMapper baseMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void updateBbs(String id, Function<BbsCommon, BbsCommon> caller) {
        SQLSelector selector = Builder.register(SQLSelector::new)
                .set(SQLSelector::setModel, BbsCommon.class)
                .set(SQLSelector::setFields, SQLWrapper.getSqlFields(BbsCommon.class))
                .set(SQLSelector::setWhere, new SQLCriteria(LambdaHelper.fieldName(BbsCommon::getId) + "=?", id))
                .set(SQLSelector::setLimit, 0, 5)
                .build();
        BbsCommon bbsCommon = baseMapper.select(new SelectOneQuerier<BbsCommon>().setResultMap(BbsCommon.class).setSqlHandler(selector));

        bbsCommon.setSubject(DataSourceHolder.getDataSourceType() + "===test transaction===" + new Date());
        baseMapper.update(new UpdateQuerier().setSqlHandler(new SQLUpdater(BbsCommon.class, bbsCommon, new SQLCriteria("id = ?", bbsCommon.getId()))));
        bbsCommon = caller==null ? null : caller.apply(bbsCommon);

        System.out.println("update doc : " + bbsCommon.getId());
    }
}
