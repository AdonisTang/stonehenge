package com.bornstone.stonehenge.manager;

import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-24.
 */
public interface IModifyAble<T extends Identity> extends IManager {
    T modify(T instance) throws ManagerException;
}
