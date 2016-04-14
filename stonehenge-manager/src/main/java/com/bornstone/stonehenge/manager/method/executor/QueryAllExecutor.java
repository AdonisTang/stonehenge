package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.dao.query.IQueryAll;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.manager.advice.IAfterQueryAll;
import com.bornstone.stonehenge.manager.advice.IBeforeQueryAll;
import com.bornstone.stonehenge.manager.query.IQueryAllAble;

import java.util.List;

/**
 * Created by King.Tang on 14-6-1.
 */
public class QueryAllExecutor<T extends IEntity> implements IManagerMethodExecutor<Void, List<T>, IQueryAllAble<T>> {
    @Override
    public List<T> execute(Void input, IQueryAllAble<T> manager) {
        if (manager instanceof IBeforeQueryAll) {
            ((IBeforeQueryAll) manager).beforeQueryAll();
        }

        IQueryAll<T> dao = manager.getDAO();
        List<T> list = dao.selectAll();

        if (manager instanceof IAfterQueryAll) {
            ((IAfterQueryAll) manager).afterQueryAll(list);
        }

        return list;
    }
}
