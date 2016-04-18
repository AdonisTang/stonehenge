package com.bornstone.stonehenge.tool.generator.entity;

import com.bornstone.stonehenge.tool.generator.entity.entityenum.ExtendedFrom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by King.Tang on 14-11-3.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class TableEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private ExtendedFrom extendedFrom;

    private Map<String, FieldEntity> fieldEntities = new HashMap<String, FieldEntity>();
    private List<FieldEntity> fieldEntityList = new LinkedList<FieldEntity>();

    public ExtendedFrom getExtendedFrom() {
        return extendedFrom;
    }

    public void setExtendedFrom(ExtendedFrom extendedFrom) {
        this.extendedFrom = extendedFrom;
    }

    public Map<String, FieldEntity> getFieldEntities() {
        return fieldEntities;
    }

    public void setFieldEntities(Map<String, FieldEntity> fieldEntities) {
        this.fieldEntities = fieldEntities;
    }

    public List<FieldEntity> getFieldEntityList() {
        return fieldEntityList;
    }

    public void setFieldEntityList(List<FieldEntity> fieldEntityList) {
        this.fieldEntityList = fieldEntityList;
    }
}
