package com.bornstone.stonehenge.manager.method.executor.advice;

import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.IModifyAble;
import com.bornstone.stonehenge.manager.method.executor.IManagerMethodExecutor;
import org.apache.log4j.Logger;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class BeforeModifyExecutor<T extends Identity> implements IManagerMethodExecutor<T, Void, IModifyAble<T>> {
    private static final Logger logger = Logger.getLogger(BeforeModifyExecutor.class);

    @Override
    public Void execute(T instance, IModifyAble<T> manager) {
        return null;
    }
}
