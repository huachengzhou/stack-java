package com.gold.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang3.StringUtils;

public abstract class JsonUtils {
    private static ObjectMapper defaultMapper = new ObjectMapper();
    private static ObjectMapper prettyMapper;

    public JsonUtils() {
    }

    public static <T> String json(T obj) {
        return json(obj, false);
    }

    public static <T> String json(T obj, boolean pretty) {
        try {
            return obj == null ? null : (pretty ? prettyMapper : defaultMapper).writeValueAsString(obj);
        } catch (JsonProcessingException var3) {
            throw new NestableRuntimeException("JSON解析异常", var3);
        }
    }

    public static <T> void json(T obj, OutputStream out) throws IOException {
        try {
            if (obj != null) {
                JsonGenerator jgen = defaultMapper.getFactory().createGenerator(out, JsonEncoding.UTF8);
                defaultMapper.writeValue(jgen, obj);
            }
        } catch (JsonProcessingException var3) {
            throw new NestableRuntimeException("JSON解析异常", var3);
        }
    }

    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return StringUtils.isBlank(json) ? null : defaultMapper.readValue(json, clazz);
        } catch (IOException var3) {
            throw new NestableRuntimeException("JSON解析异常", var3);
        }
    }

    public static JsonNode parse(String json) {
        try {
            return StringUtils.isBlank(json) ? null : defaultMapper.readTree(json);
        } catch (IOException var2) {
            throw new NestableRuntimeException("JSON解析异常", var2);
        }
    }

    public static <T> List<T> parse2list(String json, Class<T> clazz) {
        try {
            return StringUtils.isBlank(json) ? null : (List)defaultMapper.readValue(json, getCollectionType(List.class, clazz));
        } catch (IOException var3) {
            throw new NestableRuntimeException("JSON解析异常", var3);
        }
    }

    public static <T> T bean(JsonNode node, Class<T> clazz) {
        try {
            return node.isMissingNode() ? null : defaultMapper.treeToValue(node, clazz);
        } catch (JsonProcessingException var3) {
            throw new NestableRuntimeException("JSON解析异常", var3);
        }
    }

    public static <T> T pointer(String json, String expr, Class<T> clazz) {
        try {
            if (!StringUtils.isBlank(json) && !StringUtils.isBlank(expr)) {
                JsonNode node = defaultMapper.readTree(json).at(expr);
                return bean(node, clazz);
            } else {
                return null;
            }
        } catch (IOException var4) {
            throw new NestableRuntimeException("JSON解析异常", var4);
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class... elementClasses) {
        return defaultMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    static {
        defaultMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        defaultMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        defaultMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        defaultMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        prettyMapper = new ObjectMapper();
        prettyMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        prettyMapper.setSerializationInclusion(Include.NON_NULL);
        prettyMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
}