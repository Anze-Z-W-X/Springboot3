package com.bjpowernode.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadFileController {
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("upfile")MultipartFile multipartFile){
        System.out.println("开始处理上传文件");
        Map<String ,Object> info = new HashMap<>();
        try{
            if(!multipartFile.isEmpty()){
                info.put("上传文件的参数名称",multipartFile.getName());
                info.put("内容类型:",multipartFile.getContentType());

                var ext = "unknown";
                var filename = multipartFile.getOriginalFilename();//原始文件名称，如a.gif
                if(filename.indexOf(".")>0) {
                    ext = filename.substring(filename.indexOf(".") + 1);
                }
                var newFileName = UUID.randomUUID().toString()+"."+ext;
                var path = "D://tt//upload//"+newFileName;//存储服务器的文件

                //把文件存进path去
                multipartFile.transferTo(new File(path));

                info.put("文件名称",newFileName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("info="+info);
        return "redirect:/index.html";
    }
}
