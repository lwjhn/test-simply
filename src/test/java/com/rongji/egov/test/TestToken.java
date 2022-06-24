package com.rongji.egov.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.security.SecurityUser;
import com.rongji.egov.security.SimpleGrantedAuthoritySerializer;
import com.rongji.egov.utils.common.GZIPUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Author: lwjhn
 * Date: 2022/6/17 15:41
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestToken {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestToken.class);

    @Resource
    ObjectMapper objectMapper;


    @Test
    public void gen() throws IOException {
        //this.generate("U000000", "ROOT", "D00000", Collections.singletonList(new SimpleGrantedAuthority("ROLE_sys_manager")));
        this.generate("U003564", "TZBOA", "D03192", Collections.singletonList(new SimpleGrantedAuthority("ROLE_sys_manager")));
    }

    public void generate(String user, String systemNo, String orgNo, Collection<? extends GrantedAuthority> authorities) throws IOException {
        SecurityUser securityUser = Builder.register(SecurityUser::new)
                .set(SecurityUser::setUsername, user)
                .set(SecurityUser::setSystemNo, systemNo)
                .set(SecurityUser::setOrgNo, orgNo)
                .set(SecurityUser::setAuthorities, authorities)
                .set(SecurityUser::setAccountNonExpired, true)
                .set(SecurityUser::setAccountNonLocked, true)
                .set(SecurityUser::setCredentialsNonExpired, true)
                .set(SecurityUser::setEnabled, true)
                .build();
        LOGGER.info("X-Principal: Density {}", Base64.encodeBase64String(GZIPUtils.compress(objectMapper.writeValueAsString(securityUser))));
    }

    @Test
    public void serialize() throws JsonProcessingException {
        String target = "X-Principal: Density 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";

        LOGGER.info("X-Principal: Density {}", target = target.replaceAll("(?i)^(X-Principal:\\s*)*(Density\\s+)*", ""));
        LOGGER.info("User: {}", target=GZIPUtils.uncompress(Base64.decodeBase64(target)));

        SecurityUser securityUser = objectMapper.readValue(target, SecurityUser.class);
        LOGGER.info("User: {}", securityUser.getUsername());
    }
}
