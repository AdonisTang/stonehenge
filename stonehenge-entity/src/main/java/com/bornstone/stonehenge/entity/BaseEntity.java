package com.bornstone.stonehenge.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by King.Tang on 14-5-25.
 */
public abstract class BaseEntity<PK extends Number> implements Serializable, Identity<PK>, IValidateAble {
    private Date createdTime;
    private Date updatedTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
