package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.dao.query.IPaginationQuery;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.query.PaginationQuery;
import com.bornstone.stonehenge.entity.query.RPCPaginationQuery;
import com.bornstone.stonehenge.manager.advice.IAfterPagenationQuery;
import com.bornstone.stonehenge.manager.advice.IBeforePagenationQuery;
import com.bornstone.stonehenge.manager.query.IRPCPagenationQueryAble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by King.Tang on 16-9-17.
 */
public class RPCPagenationQueryExecutor<T extends IEntity> implements IManagerMethodExecutor<PaginationQuery, RPCPaginationQuery<T>, IRPCPagenationQueryAble<T, PaginationQuery>> {
    @Override
    public RPCPaginationQuery<T> execute(PaginationQuery query, IRPCPagenationQueryAble<T, PaginationQuery> manager) {
        if (manager instanceof IBeforePagenationQuery) {
            ((IBeforePagenationQuery) manager).beforePagenationQuery(query);
        }

        RPCPaginationQuery<T> rpc = new RPCPaginationQuery<T>();
        rpc.setQuery(query);

        IPaginationQuery<T, PaginationQuery> dao = manager.getDAO();
        int totalItems = dao.countByQuery(query);
        query.setTotalItem(totalItems);
        query.afterTotalItemSet();
        if (totalItems <= 0) {
            rpc.setResult(new ArrayList<T>());
            return rpc;
        }
        List<T> list = dao.selectByQuery(query);

        if (manager instanceof IAfterPagenationQuery && list != null && !list.isEmpty()) {
            ((IAfterPagenationQuery) manager).afterPagenationQuery(list);
        }

        rpc.setResult(list);
        return rpc;
    }
}
