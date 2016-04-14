package com.bornstone.stonehenge.tool.generator.entity.entityenum;

import java.util.Date;

/**
 * Created by King.Tang on 14-11-3.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public enum FieldType {
    INT(Integer.class, 11),
    BIGINT(Long.class, 20),
    VARCHAR(String.class, 50),
    TEXT(String.class, null),
    DATETIME(Date.class, null),;

    private FieldType(Class javaClass, Integer length) {
        this.javaClass = javaClass;
        this.length = length;
    }

    private Class javaClass;
    private Integer length;

    public Class getJavaClass() {
        return javaClass;
    }

    public Integer getLength() {
        return length;
    }
}
