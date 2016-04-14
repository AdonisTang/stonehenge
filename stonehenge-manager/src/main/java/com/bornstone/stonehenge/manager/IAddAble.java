package com.bornstone.stonehenge.manager;

import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-9-27.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IAddAble<T extends IEntity> extends IManager {
    T add(T instance) throws ManagerException;
}
