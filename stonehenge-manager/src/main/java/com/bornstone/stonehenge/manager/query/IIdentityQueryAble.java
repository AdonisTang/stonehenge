package com.bornstone.stonehenge.manager.query;

import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.IManager;
import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-9-27.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IIdentityQueryAble<PK extends Number, T extends Identity<PK>> extends IManager {
    T queryById(PK id) throws ManagerException;
}
