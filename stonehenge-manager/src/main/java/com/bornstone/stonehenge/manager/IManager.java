package com.bornstone.stonehenge.manager;

import com.bornstone.stonehenge.dao.IDAO;

/**
 * Created by King.Tang on 14-9-27.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IManager {
    <D extends IDAO> D getDAO();

    <D extends IDAO> void setDAO(D dao);
}
