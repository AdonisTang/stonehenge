package com.bornstone.stonehenge.core.filesystem.localstore.multipart;

import com.bornstone.stonehenge.core.filesystem.IFileValidator;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-6-4.
 */
@Service
public class MulipartImageFileValidator implements IFileValidator<MultipartFile> {
    private static final Logger logger = Logger.getLogger(MulipartImageFileValidator.class);

    @Override
    public void validate(MultipartFile file) throws ManagerException {
        // 判断文件大小，限制文件的上传
        if (file.getSize() > 2 * 1024 * 1024 || file.getSize() <= 0) {
            throw new ManagerException("上传文件大小只能为2M以内，指定的文件大小为：" + file.getSize());
        }

        logger.debug("文件大小为：" + file.getSize());

        assertNotNull(file.getOriginalFilename(), "原始文件名为空");

        String uploadFile = file.getOriginalFilename();
        Pattern reg = Pattern.compile("[.]jpg|JPG|png|PNG|jpeg|JPEG|gif|GIF$");
        Matcher matcher = reg.matcher(uploadFile);
        if (!matcher.find()) {
            logger.error("上传的文件：" + uploadFile + "文件类型不允许，只能为jpg|JPG|png|PNG|jpeg|JPEG|gif|GIF图片类型");
            throw new ManagerException("文件类型不允许，只能为图片类型");
        }
    }
}
