package com.admin.commons.config;


import com.admin.commons.utils.SpringUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * 一些文件路径配置
 */
@Component
@Lazy
public class FileStorage {

    private static String imageStorage;
    private static String uploadImageDir;

    static  {
        Environment environment =SpringUtil.getApplicationContext().getEnvironment();
        FileStorage.imageStorage = environment.getProperty("upload.storage.image");
        FileStorage.uploadImageDir = environment.getProperty("upload.dir.image");
    }

    public static String getImageStorage() {
        return imageStorage;
    }

    public static String getUploadImageDir() {
        return uploadImageDir;
    }
}
