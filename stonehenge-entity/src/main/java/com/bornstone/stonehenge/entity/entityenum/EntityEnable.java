package com.bornstone.stonehenge.entity.entityenum;

/**
 * Created by King.Tang on 14-5-26.
 */
public enum EntityEnable {
    NORMAL(0),
    DELETED(1);

    private Integer enable;

    private EntityEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getEnable() {
        return enable;
    }
}
