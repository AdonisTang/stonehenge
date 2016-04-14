package com.bornstone.stonehenge.core.filesystem;

import com.bornstone.stonehenge.manager.exception.ManagerException;

/**
 * Created by King.Tang on 14-6-4.
 */
public abstract class AbstractFileUploader<F> implements IFileUploader<F>, IFileValidator<F> {
    protected abstract IFileNameGenerator<F> getFileNameGenerator();

    protected abstract IFileSystemManager<F> getFileSystemManager();

    public UploadedFile upload(F file) throws ManagerException {
        validate(file);
        String saveFileName = getFileNameGenerator().generate(file);
        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setRealFileName(saveFileName);
        uploadedFile.setOriginalFile(file);
        uploadedFile.setUrl(getFileSystemManager().saveFile(file, saveFileName));
        uploadedFile.setSignature(uploadedFile.buildSignature(getFileSystemManager().getSignatureSalt()));
        return uploadedFile;
    }
}
