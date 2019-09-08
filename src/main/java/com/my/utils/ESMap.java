package com.my.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author my
 * @create 2019/9/5
 * @Description:
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ESMap {

    /**
     * 是否忽略
     *
     * @return
     */
    boolean ignore() default false;

    /**
     * 指定其类型，String默认keyword
     *
     * @return
     */
    String type() default "";

    /**
     * 分词器
     *
     * @return
     */
    String analyzer() default "";

    /**
     * 搜索分词器
     *
     * @return
     */
    String analyzerSearch() default "";

    /**
     * 超过该长度不写入索引
     *
     * @return
     */
    int ignoreAbove() default 256;

    /**
     * 日期类型格式化
     *
     * @return
     */
    String dateFormat() default "";

}
