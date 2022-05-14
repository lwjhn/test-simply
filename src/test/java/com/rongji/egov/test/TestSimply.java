package com.rongji.egov.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.pattern.SQLFactory;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import com.rongji.egov.mybatis.base.wrapper.HashCamelMap;
import com.rongji.egov.test.model.Bbs;
import com.rongji.egov.test.result.TestJoin;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSimply {
    @Resource
    BaseMapper baseMapper;

    @Resource
    ObjectMapper objectMapper;

    @Test
    public void testSolr() throws Exception {
        /*
        solr:
            DefaultCollection: fjszf
            ZkHost: 192.168.210.134:2166
            ZkClientTimeout: 15000
            ZkConnectTimeout: 50000
        */

        final String zkHost = "http://localhost:8983/solr";
        SolrClient solrClient = new HttpSolrClient.Builder(zkHost).build();
        System.out.println(solrClient);

        SolrQuery query = new SolrQuery();
        query.set("q", "*:*");
        QueryResponse response = solrClient.query("home", query);
        long total = response.getResults().getNumFound();
        System.out.println(total);
    }

    @Test
    public void testQuery() throws JsonProcessingException {
        SQLSelector selector;
        Page<HashCamelMap> result = baseMapper.select(new SelectPageQuerier<HashCamelMap>().setResultMap(HashCamelMap.class).setSqlHandler(
                selector = Builder.register(SQLSelector::new)
                        .set(SQLSelector::setModel, Bbs.class)
                        .set(SQLSelector::setFields, SQLWrapper.getSqlFields(Bbs.class))
                        .set(SQLSelector::setWhere, new SQLCriteria("createDate >= ? AND createDate<=? AND subject LIKE ?", "2021-03-01 20:38:11", new Date(), "%通知%"))
                        .set(SQLSelector::setLimit, 0, 5)
                        .build()
        ));

        Page<Bbs> response = baseMapper.select(new SelectPageQuerier<Bbs>().setResultMap(Bbs.class).setSqlHandler(
                selector
        ));

        //OscarClob oscarClob = (OscarClob) result.getList().get(0).get(LambdaHelper.fieldName(Bbs::getContent));


        System.out.println(JSON.toJSONString(result));
        System.out.println(objectMapper.writeValueAsString(result));
    }

    /*

SELECT DRAFT_USER_NO AS A111, DRAFT_DEPT_NO AS D111, USER_NAME, ORG_NAME, B.USER_NO FROM EGOV_BBS
JOIN (UMS_USER
	JOIN UMS_USER_ORG_RELATE AS B ON b.USER_NO = UMS_USER.USER_NO
) ON EGOV_BBS.DRAFT_USER_NO = UMS_USER.USER_NO
LEFT JOIN UMS_ORG AS C ON b.ORG_NO = C.ORG_NO
     */

    @Test
    public void testJoin() {
        InputStream is = null;
        try {
            is = TestSimply.class.getClassLoader().getResourceAsStream("example-join-1.json");
            assert is != null;
            SQLSelector selector = JSONObject.parseObject(is, SQLSelector.class);
            System.out.println(JSON.toJSONString(selector));
            System.out.println(SQLFactory.generate(selector, (o, o1) -> "?"));

            Page<TestJoin> result = baseMapper.select(
                    new SelectPageQuerier<TestJoin>().setResultMap(TestJoin.class).setSqlHandler(selector)
            );

            System.out.println(JSON.toJSONString(result, true));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AutoCloseableBase.close(is);
        }
    }


    @Test
    public void test1() {
//        SubmitReport submitReport = new SubmitReport();
//        submitReport.setId("T3-" + (new Date()).getTime());
//        submitReport.setCreateTime(new Date());
//        submitReport.setEventTime(new Date());
//        submitReport.setDeathPNumber(1);
//        submitReport.setMissingPNumber(3);
//        submitReport.setSubject("测试-common-insert-" + new Date().getTime());
//        submitReport.setEventType("案件");
//        submitReport.setSubEventType("刑事案件");
//        submitReport.setDraftUserName("系统管理员");
//        submitReport.setDraftDeptNo("U000001");
//        SQLInserter inserter = new SQLInserter(submitReport);
//        System.out.println(JSON.toJSONString(inserter, true));
//
//        System.out.println(baseMapper.update((new UpdateQuerier()).setSqlHandler(inserter)));
    }

    @Test
    public void test4() {
//        String id = "T3-1628649863157";
//        SubmitReport submitReport = new SubmitReport();
//        submitReport.setId(id);
//        submitReport.setCreateTime(new Date());
//        submitReport.setEventTime(new Date());
//        submitReport.setDeathPNumber(1);
//        submitReport.setMissingPNumber(3);
//        submitReport.setSubject("修改-2-测试-common-update-" + new Date().getTime());
//        submitReport.setEventType("案件");
//        submitReport.setSubEventType("刑事案件");
//        submitReport.setDraftUserName("系统管理员");
//        submitReport.setDraftDeptNo("U000001");
//        SQLUpdater updater = new SQLUpdater(submitReport, new SQLCriteria("id = ?", new ArrayList<Object>() {{
//            add(id);
//        }}));
//        System.out.println(JSON.toJSONString(updater, true));
//
//        System.out.println(baseMapper.update(new UpdateQuerier().setSqlHandler(updater)));
    }

    @Test
    public void testDelete() {
//        String id = "T3-%";
//        SQLDeleter handle = new SQLDeleter(SubmitReport.class, new SQLCriteria("id LIKE ?", new ArrayList<Object>() {{
//            add(id);
//        }}));
//        System.out.println(JSON.toJSONString(handle, true));
//        System.out.println(baseMapper.update(new UpdateQuerier().setSqlHandler(handle)));
    }

    @Test
    public void test3() {
//        SQLSelector selector = new SQLSelector(
//                new SQLCriteria("subject LIKE ?", "%测试%"), SubmitReport.class);
//        selector.setLimit(new ArrayList<Integer>() {{
//            add(0);
//            add(6);
//        }});
//        selector.setFields(SQLWrapper.getSqlFields(SubmitReport.class, true));
//
//        Page<HashCamelMap> test = baseMapper.select(new SelectSimpleQuerier<Page<HashCamelMap>>() {
//        }.setSqlHandler(selector));
//
//        Page<HashCamelMap> reportHashCamelMap = baseMapper.select(
//                new SelectPageQuerier<HashCamelMap>().setResultMap(HashCamelMap.class).setSqlHandler(selector));
//
//        selector.setFields(SQLWrapper.getSqlFields(SubmitReport.class));
//        Page<SubmitReport> reportPage = baseMapper.select(
//                new SelectPageQuerier<SubmitReport>()
//                        .setResultMap(SubmitReport.class).setSqlHandler(selector));
//
//        List<SubmitReport> reports = baseMapper.select(
//                new SelectListQuerier<SubmitReport>()
//                        .setResultMap(SubmitReport.class).setSqlHandler(selector));
//        FlowReaderList flowReaderList = reports.get(0).getTodoReader();
//
//        selector.setWhere(new SQLCriteria("id=?", new ArrayList<Object>() {{
//            add("abcdefg");
//        }}));
//        SubmitReport report = baseMapper.select(
//                new SelectOneQuerier<SubmitReport>()
//                        .setResultMap(SubmitReport.class).setSqlHandler(selector));
//        System.out.println(JSON.toJSONString(test));
    }
}
