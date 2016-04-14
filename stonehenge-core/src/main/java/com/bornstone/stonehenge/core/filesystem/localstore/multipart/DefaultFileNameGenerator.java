package com.bornstone.stonehenge.core.filesystem.localstore.multipart;

import com.bornstone.stonehenge.core.filesystem.IFileNameGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by King.Tang on 14-6-4.
 */
@Service
public class DefaultFileNameGenerator implements IFileNameGenerator<MultipartFile> {
    @Override
    public String generate(MultipartFile originalFile) {
        String originalFilename = originalFile.getOriginalFilename();
        return UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
    }
}
