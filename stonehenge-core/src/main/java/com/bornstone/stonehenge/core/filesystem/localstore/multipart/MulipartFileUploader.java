package com.bornstone.stonehenge.core.filesystem.localstore.multipart;

import com.bornstone.stonehenge.core.filesystem.AbstractFileUploader;
import com.bornstone.stonehenge.core.filesystem.IFileDeleteAble;
import com.bornstone.stonehenge.core.filesystem.IFileNameGenerator;
import com.bornstone.stonehenge.core.filesystem.IFileSystemManager;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by King.Tang on 14-6-4.
 */
@Service
public class MulipartFileUploader extends AbstractFileUploader<MultipartFile> implements IFileDeleteAble {
    @Autowired
    private IFileNameGenerator fileNameGenerator;
    @Autowired
    private DefaultFileNameGenerator defaultFileNameGenerator;
    @Autowired
    private MulipartLocalStore fileSystemManager;
    @Autowired
    private MulipartImageFileValidator fileValidator;

    @Override
    public void validate(MultipartFile file) throws ManagerException {
        fileValidator.validate(file);
    }

    @Override
    protected IFileNameGenerator<MultipartFile> getFileNameGenerator() {
        return fileNameGenerator == null ? defaultFileNameGenerator : fileNameGenerator;
    }

    @Override
    protected IFileSystemManager<MultipartFile> getFileSystemManager() {
        return fileSystemManager;
    }

    @Override
    public void delete(String fileName, String signature) throws ManagerException {
        fileSystemManager.removeFile(fileName, signature);
    }
}
