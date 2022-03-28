package com.soft.spb.controller;

import com.soft.spb.util.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {
    
    @PostMapping("upload")
    List<String> test(@RequestParam("file") MultipartFile[] sourceFiles) {
        return AliOssUtil.upload(sourceFiles);
    }

}
