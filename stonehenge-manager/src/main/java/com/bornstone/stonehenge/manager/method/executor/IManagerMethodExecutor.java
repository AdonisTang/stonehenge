package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.manager.IManager;

/**
 * Created by King.Tang on 14-10-18.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IManagerMethodExecutor<I, O, M extends IManager> {
    O execute(I input, M manager);
}
