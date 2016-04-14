package com.bornstone.stonehenge.tool.generator.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by King.Tang on 14-11-3.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class DatabaseEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String path;
    private String beanNameSpace;

    private Map<String, TableEntity> tableEntities = new HashMap<String, TableEntity>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBeanNameSpace() {
        return beanNameSpace;
    }

    public void setBeanNameSpace(String beanNameSpace) {
        this.beanNameSpace = beanNameSpace;
    }

    public Map<String, TableEntity> getTableEntities() {
        return tableEntities;
    }

    public void setTableEntities(Map<String, TableEntity> tableEntities) {
        this.tableEntities = tableEntities;
    }
}
