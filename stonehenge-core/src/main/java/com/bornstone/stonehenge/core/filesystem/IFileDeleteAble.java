package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-21.
 */
public interface IFileDeleteAble {
    void delete(String fileName, String signature) throws ManagerException;
}
