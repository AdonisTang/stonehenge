package com.bornstone.stonehenge.manager.query;

import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.manager.IManager;

import java.util.List;

/**
 * Created by King.Tang on 14-5-28.
 */
public interface IQueryAllAble<T extends IEntity> extends IManager {
    List<T> queryAll();
}
