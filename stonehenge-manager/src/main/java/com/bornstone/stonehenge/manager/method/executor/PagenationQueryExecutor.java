package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.dao.query.IPaginationQuery;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.query.PaginationQuery;
import com.bornstone.stonehenge.manager.advice.IAfterPagenationQuery;
import com.bornstone.stonehenge.manager.advice.IBeforePagenationQuery;
import com.bornstone.stonehenge.manager.query.IPagenationQueryAble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by King.Tang on 14-5-31.
 */
public class PagenationQueryExecutor<T extends IEntity> implements IManagerMethodExecutor<PaginationQuery, List<T>, IPagenationQueryAble<T, PaginationQuery>> {
    @Override
    public List<T> execute(PaginationQuery query, IPagenationQueryAble<T, PaginationQuery> manager) {
        if (manager instanceof IBeforePagenationQuery) {
            ((IBeforePagenationQuery) manager).beforePagenationQuery(query);
        }

        IPaginationQuery<T, PaginationQuery> dao = manager.getDAO();
        int totalItems = dao.countByQuery(query);
        query.setTotalItem(totalItems);
        if (totalItems <= 0) {
            return new ArrayList<T>();
        }
        List<T> list = dao.selectByQuery(query);

        if (manager instanceof IAfterPagenationQuery && list != null && !list.isEmpty()) {
            ((IAfterPagenationQuery) manager).afterPagenationQuery(list);
        }

        return list;
    }
}
