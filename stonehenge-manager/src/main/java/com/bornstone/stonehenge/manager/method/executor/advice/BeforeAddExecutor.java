package com.bornstone.stonehenge.manager.method.executor.advice;

import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.manager.IAddAble;
import com.bornstone.stonehenge.manager.method.executor.IManagerMethodExecutor;
import org.apache.log4j.Logger;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class BeforeAddExecutor<T extends IEntity> implements IManagerMethodExecutor<T, Void, IAddAble<T>> {
    private static final Logger logger = Logger.getLogger(BeforeAddExecutor.class);

    @Override
    public Void execute(T instance, IAddAble<T> manager) {
        return null;
    }
}
