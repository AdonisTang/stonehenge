package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-4.
 */
public interface IFileValidator<F> {
    /**
     * 文件校验
     *
     * @param file
     */
    void validate(F file) throws ManagerException;
}
