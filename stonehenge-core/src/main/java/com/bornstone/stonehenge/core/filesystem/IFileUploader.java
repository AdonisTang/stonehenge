package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-3.
 */
public interface IFileUploader<F> {
    /**
     * 文件上传，返回文件url
     *
     * @param file
     * @return
     */
    UploadedFile upload(F file) throws ManagerException;
}
