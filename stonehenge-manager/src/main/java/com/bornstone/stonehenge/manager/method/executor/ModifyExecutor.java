package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.IModifyAble;
import com.bornstone.stonehenge.manager.advice.IAfterModify;
import com.bornstone.stonehenge.manager.advice.IBeforeModify;

/**
 * Created by King.Tang on 14-10-13.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class ModifyExecutor<T extends Identity> extends BaseModifyExecutor implements IManagerMethodExecutor<T, T, IModifyAble<T>> {
    @Override
    public T execute(T instance, IModifyAble<T> manager) {
        return super.executeModify(instance, manager);
    }

    @Override
    protected <T extends Identity> void executeBefore(T instance, IModifyAble<T> manager) {
        if (manager instanceof IBeforeModify) {
            ((IBeforeModify) manager).beforeModify(instance);
        }
    }

    @Override
    protected <T extends Identity> void executeAfter(T instance, IModifyAble<T> manager) {
        if (manager instanceof IAfterModify) {
            ((IAfterModify) manager).afterModify(instance);
        }
    }
}
