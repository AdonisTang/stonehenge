package com.bornstone.stonehenge.entity.entityenum;

/**
 * Created by King.Tang on 14-6-30.
 */
public enum Order {
    ASC("asc"), DESC("desc");

    private String value;

    private Order(String value) {
        this.value = value;
    }

    ;

    public String getValue() {
        return value;
    }
}
