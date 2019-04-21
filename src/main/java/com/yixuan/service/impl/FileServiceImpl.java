package com.yixuan.service.impl;

import com.yixuan.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author:linchengxin
 * @Date:2019/4/10 16:33
 */
@Service
public class FileServiceImpl implements IFileService {

    /**
     * 上传文件
     * @param file
     * @param path
     * @return
     */
    @Override
    public String upload(MultipartFile file, String path) {
        //获取上传的文件名称
        String fileName = file.getOriginalFilename();
        //生成随机文件名，防止名称重复
        String uploadFileName = System.currentTimeMillis()+'_'+fileName;

        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);
        try {
            file.transferTo(targetFile);
        }catch (IOException e){
            System.out.println("上传文件异常:"+e.getMessage());
        }
        return uploadFileName;
    }
}
