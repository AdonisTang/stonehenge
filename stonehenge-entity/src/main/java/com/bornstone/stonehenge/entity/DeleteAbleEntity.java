package com.bornstone.stonehenge.entity;

/**
 * Created by King.Tang on 14-5-25.
 */
public abstract class DeleteAbleEntity<PK extends Number> extends BaseEntity<PK> {
    private Integer enable;

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
