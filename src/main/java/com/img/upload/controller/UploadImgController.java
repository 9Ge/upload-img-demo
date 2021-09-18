package com.img.upload.controller;

import com.img.upload.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Date: 2021/9/18 10:32<br/>
 * @Author: yangcheng
 * @Version: 1.0
 */
@RestController
public class UploadImgController {
    @Autowired
    private UploadImgService uploadImgService;

    /**
     * @Function: 用户图片上传
     * @author:  Yangxf
     * @Date:   2019/4/17 15:42
     */
    @PostMapping("/postfile")
    public Object fileUpload(@RequestParam(value = "userImg", required = true) MultipartFile file) {
        return uploadImgService.fileUpload(file);
    }
}
