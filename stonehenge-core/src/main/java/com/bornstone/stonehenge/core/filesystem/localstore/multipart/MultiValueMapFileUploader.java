package com.bornstone.stonehenge.core.filesystem.localstore.multipart;

import com.bornstone.stonehenge.core.filesystem.IFileUploader;
import com.bornstone.stonehenge.core.filesystem.UploadedFile;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-6-4.
 */
@Service
public class MultiValueMapFileUploader implements IFileUploader<MultiValueMap<String, MultipartFile>> {
    @Autowired
    private MulipartFileUploader mulipartFileUploader;

    @Override
    public UploadedFile upload(MultiValueMap<String, MultipartFile> fileMap) throws ManagerException {
        assertNotNull(fileMap, "源文件列表不能为空");
        UploadedFile uploadedFile = new UploadedFile();
        Map<String, UploadedFile> uploadedFileMap = new HashMap<String, UploadedFile>();
        for (String key : fileMap.keySet()) {
            List<MultipartFile> fileList = fileMap.get(key);
            if (fileList == null || fileList.isEmpty()) {
                continue;
            }
            for (MultipartFile file : fileList) {
                if (file != null) {
                    String originalFilename = file.getOriginalFilename();
                    UploadedFile uploadedFileItem = mulipartFileUploader.upload(file);
                    uploadedFileMap.put(originalFilename, uploadedFileItem);
                }
            }
        }
        uploadedFile.setUploadedFileMap(uploadedFileMap);
        return uploadedFile;
    }
}
