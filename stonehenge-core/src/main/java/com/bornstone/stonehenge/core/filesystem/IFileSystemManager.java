package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-3.
 */
public interface IFileSystemManager<F> {
    /**
     * 保存文件
     *
     * @param originalFile
     * @param saveFileName
     * @return
     * @throws ManagerException
     */
    String saveFile(F originalFile, String saveFileName) throws ManagerException;

    /**
     * 删除文件
     *
     * @param fileName
     * @param signature
     * @throws ManagerException
     */
    void removeFile(String fileName, String signature) throws ManagerException;

    /**
     * 获取文件访问地址
     *
     * @param fileName
     * @return
     * @throws ManagerException
     */
    String getUrl(String fileName) throws ManagerException;

    /**
     * 签名加密salt
     *
     * @return
     */
    String getSignatureSalt();

    /**
     * 生成签名
     *
     * @param fileName
     * @return
     */
    String buildSignature(String fileName) throws ManagerException;
}
