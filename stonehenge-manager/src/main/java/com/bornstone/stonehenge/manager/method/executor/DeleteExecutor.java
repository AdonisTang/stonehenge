package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.entity.DeleteAbleEntity;
import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.entity.entityenum.EntityEnable;
import com.bornstone.stonehenge.manager.IDeleteAble;
import com.bornstone.stonehenge.manager.IModifyAble;
import com.bornstone.stonehenge.manager.advice.IAfterDelete;
import com.bornstone.stonehenge.manager.advice.IBeforeDelete;

/**
 * Created by King.Tang on 14-6-24.
 */
public class DeleteExecutor<T extends DeleteAbleEntity> extends BaseModifyExecutor implements IManagerMethodExecutor<T, T, IDeleteAble<T>> {
    @Override
    public T execute(T instance, IDeleteAble<T> manager) {
        instance.setEnable(EntityEnable.DELETED.getEnable());
        return super.executeModify(instance, manager);
    }

    @Override
    protected <T extends Identity> void executeBefore(T instance, IModifyAble<T> manager) {
        if (manager instanceof IBeforeDelete) {
            ((IBeforeDelete) manager).beforeDelete((DeleteAbleEntity) instance);
        }
    }

    @Override
    protected <T extends Identity> void executeAfter(T instance, IModifyAble<T> manager) {
        if (manager instanceof IAfterDelete) {
            ((IAfterDelete) manager).afterDelete((DeleteAbleEntity) instance);
        }
    }
}
