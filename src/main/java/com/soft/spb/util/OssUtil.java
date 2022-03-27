package com.soft.spb.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

public class OssUtil {
    public String uploadfile(MultipartFile multipartFile) {
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI5t5ZbD71qx5ENKSkFHjK";
        // 阿里云账号 AccessKey 拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeySecret = "1KyrA2bNbW0bhuCV0r7pBcy7r3iSP6";
        // 填写Bucket名称，例如 examplebucket。
        String bucketName = "aliyunxiaowang";
        // 填写 Object 完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        OSS ossClient = null;
        try {
            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 2、获取文件上传的流
            InputStream inputStream = multipartFile.getInputStream();
            // 3: bucketName下面的路径地址
            String datePath = "UserImageServer";
            // 4:获取文件名
            String originname = multipartFile.getOriginalFilename();
            String filename = UUID.randomUUID().toString();
            String suffix = originname.substring(originname.lastIndexOf("."));
            String newName = filename + suffix;
            String fileUrl = datePath + "/" + newName;
            // 5： 文件上传到阿里云服务器
            ossClient.putObject(bucketName, fileUrl, inputStream);
            return "https://" + bucketName + "." + endpoint + "/" + fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        } finally {
            ossClient.shutdown();
        }
    }
}
