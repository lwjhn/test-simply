package com.rongji.egov.test.filter;

import com.rongji.egov.mybatis.dac.handler.AclBaseQueryHandler;
import com.rongji.egov.mybatis.web.WebServiceProperties;
import com.rongji.egov.mybatis.web.interceptor.NormalInterceptor;

public class DefaultNormalInterceptor implements NormalInterceptor {
    @Override
    public AclBaseQueryHandler<?, ?> resolve(AclBaseQueryHandler<?, ?> aclBaseQueryHandler, WebServiceProperties webServiceProperties) {
        return aclBaseQueryHandler;
    }
}
