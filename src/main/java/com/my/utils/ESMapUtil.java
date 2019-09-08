package com.my.utils;

import com.alibaba.fastjson.JSON;
import com.my.DynamicInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author my
 * @create 2019/9/5
 * @Description: 解析注解构建mapping
 */
public class ESMapUtil {

    private static final Logger logger = LoggerFactory.getLogger(ESMapUtil.class);

    /**
     * 转换mapping
     *
     * @param clazz
     * @return
     */
    public static Map<String, Object> analyzeESMapping(Class clazz) {
        return analyzeESMapping(clazz, false);
    }

    /**
     * 转换mapping
     *
     * @param clazz
     * @param containSuper 是否包含父类
     * @return
     */
    public static Map<String, Object> analyzeESMapping(Class clazz, boolean containSuper) {
        Map<String, Object> mapping = new HashMap<String, Object>();
        Map<String, Object> properties = new HashMap<String, Object>();
        Field[] fields = clazz.getDeclaredFields();
        // 添加父类变量
        if (containSuper && !clazz.getSuperclass().equals(Object.class)) {
            fields = (Field[]) ArrayUtils.addAll(clazz.getSuperclass().getDeclaredFields(), fields);
        }
        // 解析参数
        for (Field field : fields) {
            Map<String, Object> para = new HashMap<String, Object>();
            // 转换es type
            String type = esType(field.getType());

            // 获得注解的对象
            ESMap mapInfo = field.getAnnotation(ESMap.class);
            if (mapInfo != null) {
                if (mapInfo.ignore()) {
                    properties.remove(field.getName());
                    continue;
                }
                if (StringUtils.isNotBlank(type)) {
                    para.put("type", type);
                }
                if (StringUtils.isNotBlank(mapInfo.type())) {
                    para.put("type", mapInfo.type());
                }
                if (StringUtils.isNotBlank(mapInfo.analyzer())) {
                    para.put("analyzer", mapInfo.analyzer());
                }
                if (StringUtils.isNotBlank(mapInfo.analyzer())) {
                    para.put("search_analyzer", mapInfo.analyzerSearch());
                }
                // text类型写入索引最大长度
                if (para.get("type").equals("text")) {
                    Map<String, Object> strField = new HashMap<String, Object>();
                    Map<String, Object> keyWord = new HashMap<String, Object>();
                    keyWord.put("ignore_above", mapInfo.ignoreAbove());
                    keyWord.put("type", "keyword");
                    strField.put("keyword", keyWord);
                    para.put("fields", strField);
                }
                if (StringUtils.isNotBlank(mapInfo.dateFormat())) {
                    para.put("type", "date");
                    para.put("format", mapInfo.dateFormat());
                }
                properties.put(field.getName(), para);
            } else {
                if (StringUtils.isBlank(type)) {
                    logger.error("请指定" + field.getName() + "type类型");
                    break;
                }
                para.put("type", type);
                properties.put(field.getName(), para);
            }
        }
        mapping.put("properties", properties);
        return mapping;
    }

    /**
     * 转换ES类型
     *
     * @param clazz
     * @return
     */
    public static String esType(Class clazz) {
        if (clazz.getName().equals("java.lang.String")
                || clazz.getName().equals("char")
                || clazz.getName().equals("java.lang.Character")
        ) {
            return "keyword";
        } else if (clazz.getName().equals("int")
                || clazz.getName().equals("java.lang.Integer")
        ) {
            return "integer";
        } else if (clazz.getName().equals("byte")
                || clazz.getName().equals("java.lang.Byte")
        ) {
            return "byte";
        } else if (clazz.getName().equals("long")
                || clazz.getName().equals("java.lang.Long")
        ) {
            return "long";
        } else if (clazz.getName().equals("short")
                || clazz.getName().equals("java.lang.Short")
        ) {
            return "short";
        } else if (clazz.getName().equals("double")
                || clazz.getName().equals("java.lang.Double")
        ) {
            return "double";
        } else if (clazz.getName().equals("float")
                || clazz.getName().equals("java.lang.Float")
        ) {
            return "float";
        } else if (clazz.getName().equals("java.util.Date")) {
            return "date";
        } else if (clazz.getName().equals("java.util.List")) {
            return "array";
        } else if (clazz.getName().equals("java.lang.Object")) {
            return "object";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        logger.info(JSON.toJSONString(analyzeESMapping(DynamicInfo.class)));
    }
}
