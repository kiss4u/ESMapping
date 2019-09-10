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
     * 指定其类型
     * String默认keyword
     *
     * @return
     */
    String type() default "";

    /**
     * 分析类型及检索方式
     * no - 不被索引
     * not_analyzed - 不分词
     * analyzed - 默认standard分词
     *
     * @return
     */
    String index() default "";

    /**
     * 分词器类型
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

    /**
     * 字段合并输出
     *
     * @return
     */
    String copyTo() default "";

    /**
     * 列式存储是否开启
     * 适用于聚合、排序、脚本等操作，分词字段不能使用，可节约内存
     *
     * @return
     */
    boolean docValues() default true;

    /**
     * 是否对其索引
     * 只可以应用于映射类型和 object 字段
     * 跳过解析只能从_source中获取
     *
     * @return
     */
    boolean enable() default true;

    /**
     * 是否忽略不规则数据
     *
     * @return
     */
    boolean ignoreMalformed() default false;

    /**
     * 权重
     *
     * @return
     */
    int boost() default 1;

    /**
     * 是否脏数据清洗
     * 字符串会被转换为整数、浮点数被转换为整数
     *
     * @return
     */
    boolean coerce() default true;


}
