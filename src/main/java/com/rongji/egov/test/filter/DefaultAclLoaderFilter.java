package com.rongji.egov.test.filter;

import com.rongji.egov.mybatis.base.pattern.verifier.SQLVerifier;
import com.rongji.egov.mybatis.dac.handler.Acl;
import com.rongji.egov.mybatis.web.interceptor.AclLoaderFilter;

import java.util.Collection;
import java.util.regex.Pattern;

public class DefaultAclLoaderFilter implements AclLoaderFilter {
    private final Pattern ROLE_PATTERN = Pattern.compile("^(doc_.+|sys_manager$)", Pattern.CASE_INSENSITIVE);
    private final Pattern GROUP_PATTERN = Pattern.compile(".+_csgly$", Pattern.CASE_INSENSITIVE);

    @Override
    public Acl resolve(Acl acl) {
        return acl == null ? null : process(acl);
    }

    private Acl process(Acl acl) {
        process(acl.getGroupNoList(), GROUP_PATTERN);
        process(acl.getRoleNoList(), ROLE_PATTERN);
        return acl;
    }

    private void process(Collection<String> collection, Pattern pattern) {
        if (SQLVerifier.requireEmpty(collection))
            return;
        collection.removeIf(s -> !pattern.matcher(s).matches());
    }
}
