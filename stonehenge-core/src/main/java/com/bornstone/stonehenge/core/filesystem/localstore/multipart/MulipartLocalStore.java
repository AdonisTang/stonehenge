package com.bornstone.stonehenge.core.filesystem.localstore.multipart;

import com.bornstone.stonehenge.core.filesystem.AbstractFileSystemManager;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-6-4.
 */
@Service
public class MulipartLocalStore extends AbstractFileSystemManager<MultipartFile> {
    private static final Logger logger = Logger.getLogger(MulipartLocalStore.class);

    private String storeUrl;
    private String accessUrl;
    private String salt;

    @Override
    public String saveFile(MultipartFile originalFile, String saveFileName) throws ManagerException {
        assertNotNull(storeUrl, "未指定的存储路径");
        try {
            File saveFile = new File(storeUrl + saveFileName);
            logger.debug("存储路径：" + storeUrl + saveFileName);
            originalFile.transferTo(saveFile);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ManagerException(e);
        }
        return getUrl(saveFileName);
    }

    @Override
    public void removeFileOperate(String fileName) throws ManagerException {
        assertNotNull(storeUrl, "未指定的存储路径");
        String file = storeUrl + fileName;
        File saveFile = new File(file);
        if (!saveFile.exists()) {
            logger.warn("文件" + file + "不存在");
            return;
        }
        if (!saveFile.isFile()) {
            throw new ManagerException("只能删除文件，而" + file + "是文件夹");
        }
        if (!saveFile.delete()) {
            throw new ManagerException("删除文件失败");
        }
    }

    @Override
    public String getUrl(String fileName) throws ManagerException {
        assertNotNull(accessUrl, "未指定的存储路径");
        return accessUrl + fileName;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    @Override
    public String getSignatureSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
