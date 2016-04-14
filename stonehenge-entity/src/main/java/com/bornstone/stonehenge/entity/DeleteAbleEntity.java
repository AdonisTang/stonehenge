package com.bornstone.stonehenge.entity;

/**
 * Created by King.Tang on 14-5-25.
 */
public abstract class DeleteAbleEntity<PK extends Number> extends BaseEntity<PK> {
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
