package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.common.security.MD5Encrypt;
import com.bornstone.stonehenge.manager.exception.ManagerException;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-6-22.
 */
public abstract class AbstractFileSystemManager<F> implements IFileSystemManager<F> {
    public void removeFile(String fileName, String signature) throws ManagerException {
        validateSignature(fileName, signature, getSignatureSalt());
        removeFileOperate(fileName);
    }

    private void validateSignature(String fileName, String signature, String salt) throws ManagerException {
        assertNotNull(salt, "必须指定一个签名SALT");
        assertNotNull(signature, "签名不能为空");
        assertNotNull(fileName, "文件名不能为空");
        if (!signature.equals(MD5Encrypt.encryptWithSalt(fileName, salt))) {
            throw new ManagerException("签名验证失败");
        }
    }

    protected abstract void removeFileOperate(String fileName) throws ManagerException;

    public String buildSignature(String fileName) throws ManagerException {
        String salt = getSignatureSalt();
        assertNotNull(salt, "必须指定一个签名SALT");
        assertNotNull(fileName, "文件名为空，无法构建签名");
        return MD5Encrypt.encryptWithSalt(fileName, salt);
    }
}
