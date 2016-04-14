package com.bornstone.stonehenge.dao.query;

import com.bornstone.stonehenge.dao.IDAO;
import com.bornstone.stonehenge.entity.IEntity;

import java.util.List;

/**
 * Created by King.Tang on 14-5-25.
 */
public interface IQueryAll<T extends IEntity> extends IDAO {
    List<T> selectAll();
}
