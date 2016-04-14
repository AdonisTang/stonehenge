package com.bornstone.stonehenge.manager.advice;

import com.bornstone.stonehenge.entity.IEntity;

/**
 * Created by king on 15-5-6.
 */
public interface IBeforeAddSetDefaultProperty<T extends IEntity> extends IBeforeAdd<T> {
    void beforeAddSetDefaultProperty(T rawData);
}
