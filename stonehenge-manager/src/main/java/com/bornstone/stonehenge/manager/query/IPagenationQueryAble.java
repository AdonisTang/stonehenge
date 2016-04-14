package com.bornstone.stonehenge.manager.query;

import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.query.PaginationQuery;
import com.bornstone.stonehenge.manager.IManager;

import java.util.List;

/**
 * Created by King.Tang on 14-5-31.
 */
public interface IPagenationQueryAble<T extends IEntity, Q extends PaginationQuery> extends IManager {
    List<T> query(Q query);
}
