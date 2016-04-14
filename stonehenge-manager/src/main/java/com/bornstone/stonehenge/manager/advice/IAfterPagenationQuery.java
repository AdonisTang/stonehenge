package com.bornstone.stonehenge.manager.advice;

import com.bornstone.stonehenge.entity.IEntity;

import java.util.List;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IAfterPagenationQuery<T extends IEntity> extends IAfter {
    void afterPagenationQuery(List<T> rawData);
}
