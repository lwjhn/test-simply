package com.rongji.egov.test;

import com.rongji.egov.datasource.DataSourceHandler;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import com.rongji.egov.mybatis.base.wrapper.HashCamelMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author: lwjhn
 * Date: 2022/9/20 15:02
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("migration_rms_resource")
public class TestDbMetaData {
    @Resource
    BaseMapper baseMapper;
    @Resource
    DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestDbMetaData.class);

    @Test
    public void query() {
        LOGGER.debug("======holders : {} =======", DataSourceHandler.targetDataSourceHolders().stream().map(String::valueOf).collect(Collectors.joining(", ")));
        DataSourceHandler.set("NPSOA");
        ResultSet rs = null;
        ResultSetMetaData rsMetaData;
        try {
            Connection connection = dataSource.getConnection();

            DatabaseMetaData metaData = connection.getMetaData();
            LOGGER.debug("数据库已知的用户: {}", metaData.getUserName());
            LOGGER.debug("数据库的系统函数的逗号分隔列表: {}", metaData.getSystemFunctions());
            LOGGER.debug("数据库的时间和日期函数的逗号分隔列表: {}", metaData.getTimeDateFunctions());
            LOGGER.debug("数据库的字符串函数的逗号分隔列表: {} ", metaData.getStringFunctions());
            LOGGER.debug("数据库供应商用于 'schema' 的首选术语: {}", metaData.getSchemaTerm());
            LOGGER.debug("数据库URL: {}", metaData.getURL());
            LOGGER.debug("是否允许只读: {}", metaData.isReadOnly());
            LOGGER.debug("数据库的产品名称: {}", metaData.getDatabaseProductName());
            LOGGER.debug("数据库的版本: {}", metaData.getDatabaseProductVersion());
            LOGGER.debug("驱动程序的名称: {}", metaData.getDriverName());
            LOGGER.debug("驱动程序的版本: {}", metaData.getDriverVersion());
            //LOGGER.debug("数据库中");
            // 目录
            ArrayList<HashCamelMap> catalogs = wrapResultSet(metaData.getCatalogs());
            // 模式
            ArrayList<HashCamelMap> schemas = wrapResultSet(metaData.getSchemas());
            // 表类型
            ArrayList<HashCamelMap> getTableTypes = wrapResultSet(metaData.getTableTypes());
            // 表
            ArrayList<HashCamelMap> tables = wrapResultSet(metaData.getTables(null, null, null, new String[]{"TABLE"}));
            // 按权限
            // ArrayList<HashCamelMap> getTablePrivileges = wrapResultSet(metaData.getTablePrivileges(null, null, null));
            ArrayList<HashCamelMap> getVersionColumns = wrapResultSet(metaData.getVersionColumns(null, null, null));
            // 主键
            // ArrayList<HashCamelMap> getPrimaryKeys = wrapResultSet(metaData.getPrimaryKeys(null, null, null));
            // ArrayList<HashCamelMap> getImportedKeys = wrapResultSet(metaData.getImportedKeys(null, null, null));
            // ArrayList<HashCamelMap> getExportedKeys = wrapResultSet(metaData.getImportedKeys(null, null, null));
            // 关联建
            // ArrayList<HashCamelMap> getCrossReference = wrapResultSet(metaData.getCrossReference(null, null, null,null, null, null));
            // 数据类型
            ArrayList<HashCamelMap> getTypeInfo = wrapResultSet(metaData.getTypeInfo());
            // 索引
            // ArrayList<HashCamelMap> getIndexInfo = wrapResultSet(metaData.getIndexInfo(null, null, "EGOV_BBS", true, true));
            // ArrayList<HashCamelMap> getSuperTypes = wrapResultSet(metaData.getSuperTypes(null, "%", "%"));
            // ArrayList<HashCamelMap> getSuperTables = wrapResultSet(metaData.getSuperTables(null, "%", "%"));
            // ArrayList<HashCamelMap> getAttributes = wrapResultSet(metaData.getAttributes(null, "%", "%", "%"));
            ArrayList<HashCamelMap> getClientInfoProperties = wrapResultSet(metaData.getClientInfoProperties());
            ArrayList<HashCamelMap> functions = wrapResultSet(metaData.getFunctions(null, null, "%REGEXP%"));
            ArrayList<HashCamelMap> getFunctionColumns = wrapResultSet(metaData.getFunctionColumns(null, null, "%REGEXP%", null));

            ArrayList<HashCamelMap> getProcedures = wrapResultSet(metaData.getProcedures(null, null, null));
            ArrayList<HashCamelMap> getProcedureColumns = wrapResultSet(metaData.getProcedureColumns(null, null, null, null));
            

            HashCamelMap table = tables.get(tables.size()-1);
            ArrayList<HashCamelMap> columns = wrapResultSet(metaData.getColumns((String) table.get("tableCat"), (String) table.get("tableSchem"), (String) table.get("tableName"), null));
            LOGGER.debug("schemas: {}, catalogs: {}, tables: {}", schemas.size(), catalogs.size(), tables.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceHandler.auto();
        }
    }

    ArrayList<HashCamelMap> wrapResultSet(ResultSet rs) {
        if (rs == null) {
            return null;
        }
        ArrayList<HashCamelMap> results = new ArrayList<>();
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            HashCamelMap result;
            while (rs.next()) {
                results.add(result = new HashCamelMap());
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    result.put(metaData.getColumnName(i), rs.getObject(i));
                    //LOGGER.debug("{}, {}, {} , {}", rsMetaData.getColumnName(i), JDBCType.valueOf(rsMetaData.getColumnType(i)), rsMetaData.getColumnTypeName(i), rs.getObject(i));
                }
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            AutoCloseableBase.close(rs);
        }
    }
}
