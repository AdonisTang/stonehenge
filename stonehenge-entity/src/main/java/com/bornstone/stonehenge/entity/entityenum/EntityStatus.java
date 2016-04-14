package com.bornstone.stonehenge.entity.entityenum;

/**
 * Created by King.Tang on 14-5-26.
 */
public enum EntityStatus {
    NORMAL(0),
    DELETED(1);

    private Integer status;

    private EntityStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
