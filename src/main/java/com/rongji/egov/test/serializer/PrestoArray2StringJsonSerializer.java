package com.rongji.egov.test.serializer;

import com.facebook.presto.jdbc.PrestoArray;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PrestoArray2StringJsonSerializer extends JsonSerializer<PrestoArray> {
    final ObjectMapper objectMapper;

    public PrestoArray2StringJsonSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void serialize(PrestoArray value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value == null ? null : objectMapper.writeValueAsString(value.getArray()));
    }
}