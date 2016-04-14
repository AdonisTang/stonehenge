package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.manager.IManager;
import com.bornstone.stonehenge.manager.advice.IBefore;

/**
 * Created by King.Tang on 14-10-18.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class AbstractManagerMethodExecutor {
    protected <B extends IBefore> B getBeforeAdvice(IManager manager) {
        return null;
    }
}
