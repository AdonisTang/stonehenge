package com.bornstone.stonehenge.manager;

import com.bornstone.stonehenge.entity.DeleteAbleEntity;
import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-24.
 */
public interface IDeleteAble<T extends DeleteAbleEntity> extends IModifyAble<T> {
    T delete(T instance) throws ManagerException;
}
