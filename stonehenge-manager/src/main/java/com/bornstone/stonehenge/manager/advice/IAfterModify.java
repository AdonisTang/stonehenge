package com.bornstone.stonehenge.manager.advice;

import com.bornstone.stonehenge.entity.Identity;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IAfterModify<T extends Identity> extends IAfter {
    void afterModify(T rawData);
}
