package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.manager.IManager;

/**
 * Created by King.Tang on 14-10-20.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class DoNothingExecutor implements IManagerMethodExecutor<Void, Void, IManager> {
    @Override
    public Void execute(Void input, IManager manager) {
        return null;
    }
}
