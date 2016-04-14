package com.bornstone.stonehenge.manager;

import com.bornstone.stonehenge.entity.BaseEntity;
import com.bornstone.stonehenge.manager.advice.IBeforeAdd;
import com.bornstone.stonehenge.manager.advice.IBeforeModify;
import com.bornstone.stonehenge.manager.query.IIdentityQueryAble;

/**
 * Created by King.Tang on 14-9-27.
 * <p/>
 * 提供一些常用的操作，如数据的增加、修改、根据ID查询
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IBaseManager<PK extends Number, T extends BaseEntity<PK>> extends IAddAble<T>, IModifyAble<T>, IIdentityQueryAble<PK, T>, IBeforeAdd<T>, IBeforeModify<T> {
}
