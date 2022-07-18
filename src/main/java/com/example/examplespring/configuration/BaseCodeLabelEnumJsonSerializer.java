package com.example.examplespring.configuration;

import com.example.examplespring.mvc.domain.BaseCodeLabelEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JSON 변환시 BaseCodeLabelEnum 클래스에 대한 변환을 통일하게 처리
 */
public class BaseCodeLabelEnumJsonSerializer extends JsonSerializer<BaseCodeLabelEnum> {
    @Override
    public void serialize(BaseCodeLabelEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", value.code());
        map.put("label", value.label());
        gen.writeObject(map);
    }
}
