package com.bornstone.stonehenge.manager.advice;

import com.bornstone.stonehenge.entity.query.PaginationQuery;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IBeforePagenationQuery<T extends PaginationQuery> extends IBefore {
    void beforePagenationQuery(T rawData);
}
