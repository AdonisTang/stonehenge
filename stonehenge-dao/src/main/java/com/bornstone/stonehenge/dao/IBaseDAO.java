package com.bornstone.stonehenge.dao;

import com.bornstone.stonehenge.dao.query.IIdentityQuery;
import com.bornstone.stonehenge.entity.Identity;

/**
 * Created by King.Tang on 14-10-9.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IBaseDAO<PK extends Number, T extends Identity<PK>> extends IInsert<T>, IUpdate<T>, IIdentityQuery<PK, T> {
}
