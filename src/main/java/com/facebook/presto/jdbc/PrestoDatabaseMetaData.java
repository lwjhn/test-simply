package com.facebook.presto.jdbc;

import com.facebook.presto.jdbc.internal.guava.base.Joiner;
import com.facebook.presto.jdbc.internal.guava.base.Splitter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrestoDatabaseMetaData implements DatabaseMetaData {
    private static final String SEARCH_STRING_ESCAPE = "\\";
    private final PrestoConnection connection;

    PrestoDatabaseMetaData(PrestoConnection connection) {
        this.connection = (PrestoConnection)Objects.requireNonNull(connection, "connection is null");
    }

    public boolean allProceduresAreCallable() throws SQLException {
        return false;
    }

    public boolean allTablesAreSelectable() throws SQLException {
        return false;
    }

    public String getURL() throws SQLException {
        return this.connection.getURI().toString();
    }

    public String getUserName() throws SQLException {
        return this.connection.getUser();
    }

    public boolean isReadOnly() throws SQLException {
        return this.connection.isReadOnly();
    }

    public boolean nullsAreSortedHigh() throws SQLException {
        return false;
    }

    public boolean nullsAreSortedLow() throws SQLException {
        return false;
    }

    public boolean nullsAreSortedAtStart() throws SQLException {
        return false;
    }

    public boolean nullsAreSortedAtEnd() throws SQLException {
        return true;
    }

    public String getDatabaseProductName() throws SQLException {
        return "Presto";
    }

    public String getDatabaseProductVersion() throws SQLException {
        return this.connection.getServerInfo().getNodeVersion().getVersion();
    }

    public String getDriverName() throws SQLException {
        return "Presto JDBC Driver";
    }

    public String getDriverVersion() throws SQLException {
        return PrestoDriver.DRIVER_VERSION;
    }

    public int getDriverMajorVersion() {
        return PrestoDriver.DRIVER_VERSION_MAJOR;
    }

    public int getDriverMinorVersion() {
        return PrestoDriver.DRIVER_VERSION_MINOR;
    }

    public boolean usesLocalFiles() throws SQLException {
        return false;
    }

    public boolean usesLocalFilePerTable() throws SQLException {
        return false;
    }

    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return true;
    }

    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return true;
    }

    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    public String getIdentifierQuoteString() throws SQLException {
        return "\"";
    }

    public String getSQLKeywords() throws SQLException {
        return "BOOLEAN, TINYINT, SMALLINT, INTEGER, BIGINT, REAL, DOUBLE, DECIMAL, VARCHAR, CHAR, VARBINARY, JSON, DATE, TIME, WITH, ZONE, TIMESTAMP, INTERVAL, YEAR, TO, MONTH, DAY, SECOND, ARRAY, MAP, ROW, IPADDRESS, UUID, IPPREFIX, HyperLogLog, P4HyperLogLog, KHyperLogLog, QDigest, TDigest, " +
                "LIMIT, ALTER, AND, AS, BETWEEN, BY, CASE, CAST, CONSTRAINT, CREATE, CROSS, CUBE, CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP, CURRENT_USER, DEALLOCATE, DELETE, DESCRIBE, DISTINCT, DROP, ELSE, END, ESCAPE, EXCEPT, EXECUTE, EXISTS, EXTRACT, FALSE, FOR, FROM, FULL, GROUP, GROUPING, HAVING, IN, INNER, INSERT, INTERSECT, INTO, IS, JOIN, LEFT, LIKE, LOCALTIME, LOCALTIMESTAMP, NATURAL, NORMALIZE, NOT, NULL, ON, OR, ORDER, OUTER, PREPARE, RECURSIVE, RIGHT, ROLLUP, SELECT, TABLE, THEN, TRUE, UESCAPE, UNION, UNNEST, USING, VALUES, WHEN, WHERE, WITH";
    }

    public String getNumericFunctions() throws SQLException {
        return "abs, cbrt, ceil, ceiling, cosine_similarity, degrees, e, exp, floor, from_base, ln, log2, log10, mod, pi, pow, power, radians, rand, random, secure_rand, secure_random, round, sign, sqrt, to_base, truncate, width_bucket, beta_cdf, binomial_cdf, cauchy_cdf, chi_squared_cdf, laplace_cdf, normal_cdf, poisson_cdf, weibull_cdf, inverse_beta_cdf, inverse_binomial_cdf, inverse_cauchy_cdf, inverse_chi_squared_cdf, inverse_laplace_cdf, inverse_normal_cdf, inverse_poisson_cdf, inverse_weibull_cdf, wilson_interval_lower, wilson_interval_upper, acos, asin, atan, atan2, cos, cosh, sin, tan, tanh, infinity, is_finite, is_infinite, is_nan, nan";
    }

    public String getStringFunctions() throws SQLException {
        return "chr, codepoint, concat, hamming_distance, length, levenshtein_distance, lower, lpad, ltrim, replace, reverse, rpad, rtrim, split, split_part, split_to_map, split_to_multimap, strpos, strrpos, position, substr, trim, upper, word_stem, normalize, to_utf8, from_utf8, key_sampling_percent";
    }

    public String getSystemFunctions() throws SQLException {
        return "abs,acos,approx_distinct,approx_percentile,approx_set,arbitrary,array_agg,array_distinct,array_except,array_intersect,array_join,array_max,array_min,array_position,array_remove,array_sort,array_union,arrays_overlap,asin,atan,atan2,avg,bar,bing_tile,bing_tile_at,bing_tile_coordinates,bing_tile_polygon,bing_tile_quadkey,bing_tile_zoom_level,bit_count,bitwise_and,bitwise_and_agg,bitwise_not,bitwise_or,bitwise_or_agg,bitwise_xor,bool_and,bool_or,cardinality,cbrt,ceil,ceiling,char2hexint,checksum,chr,classify,codepoint,color,concat,contains,corr,cos,cosh,cosine_similarity,count,count_if,covar_pop,covar_samp,crc32,cume_dist,current_date,current_time,current_timestamp,current_timezone,date,date_add,date_diff,date_format,date_parse,date_trunc,day,day_of_month,day_of_week,day_of_year,degrees,dense_rank,dow,doy,e,element_at,empty_approx_set,evaluate_classifier_predictions,every,exp,features,filter,first_value,flatten,floor,format_datetime,from_base,from_base64,from_base64url,from_big_endian_64,from_hex,from_iso8601_date,from_iso8601_timestamp,from_unixtime,from_utf8,geometric_mean,geometry_to_bing_tiles,greatest,hamming_distance,hash_counts,histogram,hour,index,infinity,intersection_cardinality,inverse_normal_cdf,is_finite,is_infinite,is_json_scalar,is_nan,jaccard_index,json_array_contains,json_array_get,json_array_length,json_extract,json_extract_scalar,json_format,json_parse,json_size,kurtosis,lag,last_value,lead,learn_classifier,learn_libsvm_classifier,learn_libsvm_regressor,learn_regressor,least,length,levenshtein_distance,like_pattern,ln,localtime,localtimestamp,log,log10,log2,lower,lpad,ltrim,make_set_digest,map,map_agg,map_concat,map_entries,map_filter,map_from_entries,map_keys,map_union,map_values,map_zip_with,max,max_by,md5,merge,merge_set_digest,min,min_by,minute,mod,month,multimap_agg,nan,normal_cdf,normalize,now,nth_value,ntile,numeric_histogram,objectid,parse_datetime,parse_duration,percent_rank,pi,pow,power,quarter,radians,rand,random,rank,reduce,regexp_extract,regexp_extract_all,regexp_like,regexp_replace,regexp_split,regr_intercept,regr_slope,regress,render,repeat,replace,reverse,rgb,round,row_number,rpad,rtrim,second,sequence,sha1,sha256,sha512,shuffle,sign,sin,skewness,slice,split,split_part,split_to_map,sqrt,ST_Area,ST_AsText,ST_Boundary,ST_Buffer,ST_Centroid,ST_Contains,ST_CoordDim,ST_Crosses,ST_Difference,ST_Dimension,ST_Disjoint,ST_Distance,ST_EndPoint,ST_Envelope,ST_Equals,ST_ExteriorRing,ST_GeometryFromText,ST_Intersection,ST_Intersects,ST_IsClosed,ST_IsEmpty,ST_IsRing,ST_Length,ST_LineFromText,ST_NumInteriorRing,ST_NumPoints,ST_Overlaps,ST_Point,ST_Polygon,ST_Relate,ST_StartPoint,ST_SymDifference,ST_Touches,ST_Within,ST_X,ST_XMax,ST_XMin,ST_Y,ST_YMax,ST_YMin,stddev,stddev_pop,stddev_samp,strpos,substr,substring,sum,tan,tanh,timezone_hour,timezone_minute,to_base,to_base64,to_base64url,to_big_endian_64,to_char,to_date,to_hex,to_ieee754_32,to_ieee754_64,to_iso8601,to_milliseconds,to_timestamp,to_unixtime,to_utf8,transform,transform_keys,transform_values,trim,truncate,typeof,upper,url_decode,url_encode,url_extract_fragment,url_extract_host,url_extract_parameter,url_extract_path,url_extract_port,url_extract_protocol,url_extract_query,uuid,var_pop,var_samp,variance,week,week_of_year,width_bucket,word_stem,xxhash64,year,year_of_week,yow,zip,zip_with";
    }

    public String getTimeDateFunctions() throws SQLException {
        return "current_date, current_time, current_timestamp, current_timezone, date, last_day_of_month, from_iso8601_timestamp, from_iso8601_date, from_unixtime, localtime, localtimestamp, now, to_iso8601, to_milliseconds, to_unixtime, date_trunc, date_add, date_diff, parse_duration, date_format, date_parse, format_datetime, parse_datetime, extract, day, day_of_month, day_of_week, day_of_year, dow, doy, hour, millisecond, minute, month, quarter, second, timezone_hour, timezone_minute, week, week_of_year, year, year_of_week, yow";
    }

    public String getSearchStringEscape() throws SQLException {
        return "\\";
    }

    public String getExtraNameCharacters() throws SQLException {
        return "";
    }

    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return false;
    }

    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return false;
    }

    public boolean supportsColumnAliasing() throws SQLException {
        return true;
    }

    public boolean nullPlusNonNullIsNull() throws SQLException {
        return true;
    }

    public boolean supportsConvert() throws SQLException {
        return false;
    }

    public boolean supportsConvert(int fromType, int toType) throws SQLException {
        return false;
    }

    public boolean supportsTableCorrelationNames() throws SQLException {
        return true;
    }

    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return false;
    }

    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return true;
    }

    public boolean supportsOrderByUnrelated() throws SQLException {
        return true;
    }

    public boolean supportsGroupBy() throws SQLException {
        return true;
    }

    public boolean supportsGroupByUnrelated() throws SQLException {
        return true;
    }

    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return true;
    }

    public boolean supportsLikeEscapeClause() throws SQLException {
        return true;
    }

    public boolean supportsMultipleResultSets() throws SQLException {
        return false;
    }

    public boolean supportsMultipleTransactions() throws SQLException {
        return true;
    }

    public boolean supportsNonNullableColumns() throws SQLException {
        return true;
    }

    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return true;
    }

    public boolean supportsCoreSQLGrammar() throws SQLException {
        return false;
    }

    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return false;
    }

    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return true;
    }

    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return false;
    }

    public boolean supportsANSI92FullSQL() throws SQLException {
        return false;
    }

    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return false;
    }

    public boolean supportsOuterJoins() throws SQLException {
        return true;
    }

    public boolean supportsFullOuterJoins() throws SQLException {
        return true;
    }

    public boolean supportsLimitedOuterJoins() throws SQLException {
        return true;
    }

    public String getSchemaTerm() throws SQLException {
        return "schema";
    }

    public String getProcedureTerm() throws SQLException {
        return "procedure";
    }

    public String getCatalogTerm() throws SQLException {
        return "catalog";
    }

    public boolean isCatalogAtStart() throws SQLException {
        return true;
    }

    public String getCatalogSeparator() throws SQLException {
        return ".";
    }

    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return true;
    }

    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return true;
    }

    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return true;
    }

    public boolean supportsPositionedDelete() throws SQLException {
        return false;
    }

    public boolean supportsPositionedUpdate() throws SQLException {
        return false;
    }

    public boolean supportsSelectForUpdate() throws SQLException {
        return false;
    }

    public boolean supportsStoredProcedures() throws SQLException {
        return false;
    }

    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInExists() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInIns() throws SQLException {
        return true;
    }

    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return true;
    }

    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return true;
    }

    public boolean supportsUnion() throws SQLException {
        return true;
    }

    public boolean supportsUnionAll() throws SQLException {
        return true;
    }

    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return false;
    }

    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return false;
    }

    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return false;
    }

    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return false;
    }

    public int getMaxBinaryLiteralLength() throws SQLException {
        return 0;
    }

    public int getMaxCharLiteralLength() throws SQLException {
        return 0;
    }

    public int getMaxColumnNameLength() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInGroupBy() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInIndex() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInOrderBy() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInSelect() throws SQLException {
        return 0;
    }

    public int getMaxColumnsInTable() throws SQLException {
        return 0;
    }

    public int getMaxConnections() throws SQLException {
        return 0;
    }

    public int getMaxCursorNameLength() throws SQLException {
        return 0;
    }

    public int getMaxIndexLength() throws SQLException {
        return 0;
    }

    public int getMaxSchemaNameLength() throws SQLException {
        return 0;
    }

    public int getMaxProcedureNameLength() throws SQLException {
        return 0;
    }

    public int getMaxCatalogNameLength() throws SQLException {
        return 0;
    }

    public int getMaxRowSize() throws SQLException {
        return 0;
    }

    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return true;
    }

    public int getMaxStatementLength() throws SQLException {
        return 0;
    }

    public int getMaxStatements() throws SQLException {
        return 0;
    }

    public int getMaxTableNameLength() throws SQLException {
        return 0;
    }

    public int getMaxTablesInSelect() throws SQLException {
        return 0;
    }

    public int getMaxUserNameLength() throws SQLException {
        return 0;
    }

    public int getDefaultTransactionIsolation() throws SQLException {
        return 1;
    }

    public boolean supportsTransactions() throws SQLException {
        return true;
    }

    public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
        return true;
    }

    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return true;
    }

    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return false;
    }

    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return false;
    }

    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return false;
    }

    public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException {
        return this.selectEmpty("SELECT PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME,\n   null, null, null, REMARKS, PROCEDURE_TYPE, SPECIFIC_NAME\nFROM system.jdbc.procedures\nORDER BY PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME, SPECIFIC_NAME");
    }

    public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException {
        return this.selectEmpty("SELECT PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME,   COLUMN_NAME, COLUMN_TYPE, DATA_TYPE, TYPE_NAME,\n  PRECISION, LENGTH, SCALE, RADIX,\n  NULLABLE, REMARKS, COLUMN_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB,\n  CHAR_OCTET_LENGTH, ORDINAL_POSITION, IS_NULLABLE, SPECIFIC_NAME\nFROM system.jdbc.procedure_columns\nORDER BY PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME, SPECIFIC_NAME, COLUMN_NAME");
    }

    public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, TABLE_TYPE, REMARKS,\n  TYPE_CAT, TYPE_SCHEM, TYPE_NAME,   SELF_REFERENCING_COL_NAME, REF_GENERATION\nFROM system.jdbc.tables");
        List<String> filters = new ArrayList();
        emptyStringEqualsFilter(filters, "TABLE_CAT", catalog);
        emptyStringLikeFilter(filters, "TABLE_SCHEM", schemaPattern);
        optionalStringLikeFilter(filters, "TABLE_NAME", tableNamePattern);
        optionalStringInFilter(filters, "TABLE_TYPE", types);
        buildFilters(query, filters);
        query.append("\nORDER BY TABLE_TYPE, TABLE_CAT, TABLE_SCHEM, TABLE_NAME");
        return this.select(query.toString());
    }

    public ResultSet getSchemas() throws SQLException {
        return this.select("SELECT TABLE_SCHEM, TABLE_CATALOG\nFROM system.jdbc.schemas\nORDER BY TABLE_CATALOG, TABLE_SCHEM");
    }

    public ResultSet getCatalogs() throws SQLException {
        return this.select("SELECT TABLE_CAT\nFROM system.jdbc.catalogs\nORDER BY TABLE_CAT");
    }

    public ResultSet getTableTypes() throws SQLException {
        return this.select("SELECT TABLE_TYPE\nFROM system.jdbc.table_types\nORDER BY TABLE_TYPE");
    }

    public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, DATA_TYPE,\n  TYPE_NAME, COLUMN_SIZE, BUFFER_LENGTH, DECIMAL_DIGITS, NUM_PREC_RADIX,\n  NULLABLE, REMARKS, COLUMN_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB,\n  CHAR_OCTET_LENGTH, ORDINAL_POSITION, IS_NULLABLE,\n  SCOPE_CATALOG, SCOPE_SCHEMA, SCOPE_TABLE,\n  SOURCE_DATA_TYPE, IS_AUTOINCREMENT, IS_GENERATEDCOLUMN\nFROM system.jdbc.columns");
        List<String> filters = new ArrayList();
        emptyStringEqualsFilter(filters, "TABLE_CAT", catalog);
        emptyStringLikeFilter(filters, "TABLE_SCHEM", schemaPattern);
        optionalStringLikeFilter(filters, "TABLE_NAME", tableNamePattern);
        optionalStringLikeFilter(filters, "COLUMN_NAME", columnNamePattern);
        buildFilters(query, filters);
        query.append("\nORDER BY TABLE_CAT, TABLE_SCHEM, TABLE_NAME, ORDINAL_POSITION");
        return this.select(query.toString());
    }

    public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) throws SQLException {
        throw new SQLFeatureNotSupportedException("privileges not supported");
    }

    public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
        throw new SQLFeatureNotSupportedException("privileges not supported");
    }

    public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) throws SQLException {
        throw new SQLFeatureNotSupportedException("row identifiers not supported");
    }

    public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {
        throw new SQLFeatureNotSupportedException("version columns not supported");
    }

    public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
        throw new SQLFeatureNotSupportedException("primary keys not supported");
    }

    public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
        throw new SQLFeatureNotSupportedException("imported keys not supported");
    }

    public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
        throw new SQLFeatureNotSupportedException("exported keys not supported");
    }

    public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {
        throw new SQLFeatureNotSupportedException("cross reference not supported");
    }

    public ResultSet getTypeInfo() throws SQLException {
        return this.select("SELECT TYPE_NAME, DATA_TYPE, PRECISION, LITERAL_PREFIX, LITERAL_SUFFIX,\nCREATE_PARAMS, NULLABLE, CASE_SENSITIVE, SEARCHABLE, UNSIGNED_ATTRIBUTE,\nFIXED_PREC_SCALE, AUTO_INCREMENT, LOCAL_TYPE_NAME, MINIMUM_SCALE, MAXIMUM_SCALE,\nSQL_DATA_TYPE, SQL_DATETIME_SUB, NUM_PREC_RADIX\nFROM system.jdbc.types\nORDER BY DATA_TYPE");
    }

    public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) throws SQLException {
        throw new SQLFeatureNotSupportedException("indexes not supported");
    }

    public boolean supportsResultSetType(int type) throws SQLException {
        return type == 1003;
    }

    public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
        return type == 1003 && concurrency == 1007;
    }

    public boolean ownUpdatesAreVisible(int type) throws SQLException {
        return false;
    }

    public boolean ownDeletesAreVisible(int type) throws SQLException {
        return false;
    }

    public boolean ownInsertsAreVisible(int type) throws SQLException {
        return false;
    }

    public boolean othersUpdatesAreVisible(int type) throws SQLException {
        return false;
    }

    public boolean othersDeletesAreVisible(int type) throws SQLException {
        return false;
    }

    public boolean othersInsertsAreVisible(int type) throws SQLException {
        return false;
    }

    public boolean updatesAreDetected(int type) throws SQLException {
        return false;
    }

    public boolean deletesAreDetected(int type) throws SQLException {
        return false;
    }

    public boolean insertsAreDetected(int type) throws SQLException {
        return false;
    }

    public boolean supportsBatchUpdates() throws SQLException {
        return false;
    }

    public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types) throws SQLException {
        return this.selectEmpty("SELECT TYPE_CAT, TYPE_SCHEM, TYPE_NAME,\n  CLASS_NAME, DATA_TYPE, REMARKS, BASE_TYPE\nFROM system.jdbc.udts\nORDER BY DATA_TYPE, TYPE_CAT, TYPE_SCHEM, TYPE_NAME");
    }

    public Connection getConnection() throws SQLException {
        return this.connection;
    }

    public boolean supportsSavepoints() throws SQLException {
        return false;
    }

    public boolean supportsNamedParameters() throws SQLException {
        return true;
    }

    public boolean supportsMultipleOpenResults() throws SQLException {
        return false;
    }

    public boolean supportsGetGeneratedKeys() throws SQLException {
        return false;
    }

    public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
        return this.selectEmpty("SELECT TYPE_CAT, TYPE_SCHEM, TYPE_NAME,\n  SUPERTYPE_CAT, SUPERTYPE_SCHEM, SUPERTYPE_NAME\nFROM system.jdbc.super_types\nORDER BY TYPE_CAT, TYPE_SCHEM, TYPE_NAME");
    }

    public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
        return this.selectEmpty("SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, SUPERTABLE_NAME\nFROM system.jdbc.super_tables\nORDER BY TABLE_CAT, TABLE_SCHEM, TABLE_NAME");
    }

    public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) throws SQLException {
        return this.selectEmpty("SELECT TYPE_CAT, TYPE_SCHEM, TYPE_NAME, ATTR_NAME, DATA_TYPE,\n  ATTR_TYPE_NAME, ATTR_SIZE, DECIMAL_DIGITS, NUM_PREC_RADIX, NULLABLE,\n  REMARKS, ATTR_DEF, SQL_DATA_TYPE, SQL_DATETIME_SUB, CHAR_OCTET_LENGTH,\n  ORDINAL_POSITION, IS_NULLABLE, SCOPE_CATALOG, SCOPE_SCHEMA, SCOPE_TABLE,\nSOURCE_DATA_TYPE\nFROM system.jdbc.attributes\nORDER BY TYPE_CAT, TYPE_SCHEM, TYPE_NAME, ORDINAL_POSITION");
    }

    public boolean supportsResultSetHoldability(int holdability) throws SQLException {
        return holdability == 1;
    }

    public int getResultSetHoldability() throws SQLException {
        return 1;
    }

    public int getDatabaseMajorVersion() throws SQLException {
        return this.getDatabaseVersionPart(0);
    }

    public int getDatabaseMinorVersion() throws SQLException {
        return this.getDatabaseVersionPart(1);
    }

    private int getDatabaseVersionPart(int part) throws SQLException {
        String version = this.getDatabaseProductVersion();
        List<String> parts = Splitter.on('.').limit(3).splitToList(version);

        try {
            return Integer.parseInt((String)parts.get(part));
        } catch (NumberFormatException | IndexOutOfBoundsException var5) {
            return 0;
        }
    }

    public int getJDBCMajorVersion() throws SQLException {
        return 4;
    }

    public int getJDBCMinorVersion() throws SQLException {
        return 2;
    }

    public int getSQLStateType() throws SQLException {
        return 2;
    }

    public boolean locatorsUpdateCopy() throws SQLException {
        return true;
    }

    public boolean supportsStatementPooling() throws SQLException {
        return false;
    }

    public RowIdLifetime getRowIdLifetime() throws SQLException {
        return RowIdLifetime.ROWID_UNSUPPORTED;
    }

    public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT TABLE_SCHEM, TABLE_CATALOG\nFROM system.jdbc.schemas");
        List<String> filters = new ArrayList();
        emptyStringEqualsFilter(filters, "TABLE_CATALOG", catalog);
        optionalStringLikeFilter(filters, "TABLE_SCHEM", schemaPattern);
        buildFilters(query, filters);
        query.append("\nORDER BY TABLE_CATALOG, TABLE_SCHEM");
        return this.select(query.toString());
    }

    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return false;
    }

    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return false;
    }

    public ResultSet getClientInfoProperties() throws SQLException {
        return this.select(String.format("SELECT * FROM (VALUES%n        ('ApplicationName', %s, 'presto-jdbc', 'Sets the source of the session'),%n        ('ClientInfo', %s, NULL, 'Sets the client info of the session'),        %n        ('ClientTags', %s, NULL, 'Comma-delimited string of tags for the session'),        %n        ('TraceToken', %s, NULL, 'Sets the trace token of the session')        %n) AS t (NAME, MAX_LEN, DEFAULT_VALUE, DESCRIPTION)", 2147483646, 2147483646, 2147483646, 2147483646));
    }

    public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
        //throw new NotImplementedException("DatabaseMetaData", "getFunctions");
        return getProcedures(catalog, schemaPattern, functionNamePattern);
    }

    public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
        //throw new NotImplementedException("DatabaseMetaData", "getFunctionColumns");
        return getPseudoColumns(catalog, schemaPattern, functionNamePattern, columnNamePattern);
    }

    public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        return this.selectEmpty("SELECT TABLE_CAT, TABLE_SCHEM, TABLE_NAME, COLUMN_NAME, DATA_TYPE,\n  COLUMN_SIZE, DECIMAL_DIGITS, NUM_PREC_RADIX, COLUMN_USAGE, REMARKS,\n  CHAR_OCTET_LENGTH, IS_NULLABLE\nFROM system.jdbc.pseudo_columns\nORDER BY TABLE_CAT, table_SCHEM, TABLE_NAME, COLUMN_NAME");
    }

    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return false;
    }

    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (this.isWrapperFor(iface)) {
            return (T) this;
        } else {
            throw new SQLException("No wrapper for " + iface);
        }
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return iface.isInstance(this);
    }

    private ResultSet selectEmpty(String sql) throws SQLException {
        return this.select(sql + " LIMIT 0");
    }

    private ResultSet select(String sql) throws SQLException {
        return this.getConnection().createStatement().executeQuery(sql);
    }

    private static void buildFilters(StringBuilder out, List<String> filters) {
        if (!filters.isEmpty()) {
            out.append("\nWHERE ");
            Joiner.on(" AND ").appendTo(out, filters);
        }

    }

    private static void optionalStringInFilter(List<String> filters, String columnName, String[] values) {
        if (values != null) {
            if (values.length == 0) {
                filters.add("false");
            } else {
                StringBuilder filter = new StringBuilder();
                filter.append(columnName).append(" IN (");

                for(int i = 0; i < values.length; ++i) {
                    if (i > 0) {
                        filter.append(", ");
                    }

                    quoteStringLiteral(filter, values[i]);
                }

                filter.append(")");
                filters.add(filter.toString());
            }
        }
    }

    private static void optionalStringLikeFilter(List<String> filters, String columnName, String value) {
        if (value != null) {
            filters.add(stringColumnLike(columnName, value));
        }

    }

    private static void emptyStringEqualsFilter(List<String> filters, String columnName, String value) {
        if (value != null) {
            if (value.isEmpty()) {
                filters.add(columnName + " IS NULL");
            } else {
                filters.add(stringColumnEquals(columnName, value));
            }
        }

    }

    private static void emptyStringLikeFilter(List<String> filters, String columnName, String value) {
        if (value != null) {
            if (value.isEmpty()) {
                filters.add(columnName + " IS NULL");
            } else {
                filters.add(stringColumnLike(columnName, value));
            }
        }

    }

    private static String stringColumnEquals(String columnName, String value) {
        StringBuilder filter = new StringBuilder();
        filter.append(columnName).append(" = ");
        quoteStringLiteral(filter, value);
        return filter.toString();
    }

    private static String stringColumnLike(String columnName, String pattern) {
        StringBuilder filter = new StringBuilder();
        filter.append(columnName).append(" LIKE ");
        quoteStringLiteral(filter, pattern);
        filter.append(" ESCAPE ");
        quoteStringLiteral(filter, "\\");
        return filter.toString();
    }

    private static void quoteStringLiteral(StringBuilder out, String value) {
        out.append('\'');

        for(int i = 0; i < value.length(); ++i) {
            char c = value.charAt(i);
            out.append(c);
            if (c == '\'') {
                out.append('\'');
            }
        }

        out.append('\'');
    }
}