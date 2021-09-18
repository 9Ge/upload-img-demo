package com.img.upload.service;

import com.img.upload.util.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date: 2021/9/18 10:33<br/>
 * @Author: yangcheng
 * @Version: 1.0
 */
@Service
public class UploadImgService {

    @Autowired
    private PreReadUploadConfig preReadUploadConfig;

    /**
     * @Function: 用户头像上传
     * @author:  YangXf
     * @Date:   2019/4/17 15:41
     * @param:  file 图片
     * @param:  userId 用户ID
     * @return: map
     */
    public String fileUpload(MultipartFile file) {
        Map<String, Object> map = new HashMap<>();

        String fileName = file.getOriginalFilename();
        fileName = FileTool.renameToUUID(fileName);
        try {
            FileTool.uploadFiles(file.getBytes(), preReadUploadConfig.getUploadPath(), fileName);
        } catch (Exception e) {
        }
        String url = "/static/" + fileName;
      return url;
    }
}
