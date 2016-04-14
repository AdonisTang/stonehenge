package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.common.security.MD5Encrypt;
import com.bornstone.stonehenge.manager.exception.ManagerException;

import java.util.Map;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-6-21.
 */
public class UploadedFile<F> {
    private String realFileName;
    private String url;
    private F originalFile;
    private String signature;

    private Map<String, UploadedFile> uploadedFileMap;

    public String getRealFileName() {
        return realFileName;
    }

    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, UploadedFile> getUploadedFileMap() {
        return uploadedFileMap;
    }

    public void setUploadedFileMap(Map<String, UploadedFile> uploadedFileMap) {
        this.uploadedFileMap = uploadedFileMap;
    }

    public F getOriginalFile() {
        return originalFile;
    }

    public void setOriginalFile(F originalFile) {
        this.originalFile = originalFile;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String buildSignature(String salt) throws ManagerException {
        assertNotNull(salt, "必须指定一个签名SALT");
        assertNotNull(getRealFileName(), "文件名为空，无法构建签名");
        return MD5Encrypt.encryptWithSalt(getRealFileName(), salt);
    }
}
