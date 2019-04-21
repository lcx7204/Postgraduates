package com.yixuan.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:linchengxin
 * @Date:2019/4/10 16:33
 */
public interface IFileService {

    /**
     * 上传图片
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file,String path);
}
