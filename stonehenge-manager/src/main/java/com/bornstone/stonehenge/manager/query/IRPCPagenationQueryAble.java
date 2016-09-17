package com.bornstone.stonehenge.manager.query;

import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.query.PaginationQuery;
import com.bornstone.stonehenge.entity.query.RPCPaginationQuery;
import com.bornstone.stonehenge.manager.IManager;

/**
 * Created by King.Tang on 16-9-17.
 */
public interface IRPCPagenationQueryAble<T extends IEntity, Q extends PaginationQuery> extends IManager {
    RPCPaginationQuery<T> rpcQuery(Q query);
}
