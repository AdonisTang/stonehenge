package com.bornstone.stonehenge.manager.advice;

import com.bornstone.stonehenge.entity.IEntity;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IBeforeAdd<T extends IEntity> extends IBefore {
    void beforeAdd(T rawData);
}
