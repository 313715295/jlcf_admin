package com.admin.module.service;


import com.admin.module.entity.UploadInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文件上传配置 服务类
 * </p>
 *
 * @author wangl
 * @since 2018-07-06
 */
public interface UploadInfoService extends IService<UploadInfo> {

    public UploadInfo getOneInfo();

    public void updateInfo(UploadInfo uploadInfo);

}
