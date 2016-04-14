package com.bornstone.stonehenge.tool.generator.entity;

import com.bornstone.stonehenge.tool.generator.entity.entityenum.FieldType;

/**
 * Created with IntelliJ IDEA.
 * User: king
 * Date: 14-10-29
 * Time: 下午8:26
 * To change this template use File | Settings | File Templates.
 */
public class FieldEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private FieldType fieldType;
    private Integer length;
    private String isAllowNull;
    private String isPK;
    private String isQuery;
    private String updateAble;

    public String getFreemarkerFieldInfo() {
        return "#{" + getFormatName() + ",jdbcType=" + getFieldType() + "}";
    }

    public String getFreemarkerFieldName() {
        return "#{" + getFormatName() + "}";
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getIsAllowNull() {
        return isAllowNull;
    }

    public void setIsAllowNull(String isAllowNull) {
        this.isAllowNull = isAllowNull;
    }

    public String getIsPK() {
        return isPK;
    }

    public void setIsPK(String isPK) {
        this.isPK = isPK;
    }

    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    public String getUpdateAble() {
        return updateAble;
    }

    public void setUpdateAble(String updateAble) {
        this.updateAble = updateAble;
    }
}
