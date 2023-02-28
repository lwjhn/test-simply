package com.rongji.egov.test.model.reference;

import com.rongji.egov.mybatis.dac.proxy.annotation.AnnotationModelAclFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * Author: lwjhn
 * Date: 2022/12/19 15:09
 * Description:
 */
public class TableSettingAclFilter {
    private Set<String> bill;
    private String regexp;

    public Set<String> getBill() {
        return bill;
    }

    public void setBill(Set<String> bill) {
        this.bill = bill;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    public AnnotationModelAclFilter toFilter() {
        return CollectionUtils.isEmpty(bill) && StringUtils.isBlank(regexp)
                ? null : new AnnotationModelAclFilter(regexp, bill);
    }
}
