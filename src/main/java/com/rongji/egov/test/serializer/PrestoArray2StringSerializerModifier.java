package com.rongji.egov.test.serializer;

import com.facebook.presto.jdbc.PrestoArray;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.rongji.egov.mybatis.base.utils.ModelUtils;

public class PrestoArray2StringSerializerModifier extends BeanSerializerModifier {
    final ObjectMapper objectMapper;

    public PrestoArray2StringSerializerModifier(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (ModelUtils.isSubclass(beanDesc.getBeanClass(), PrestoArray.class)) {
            return new PrestoArray2StringJsonSerializer(objectMapper);
        }
        return serializer;
    }
}
