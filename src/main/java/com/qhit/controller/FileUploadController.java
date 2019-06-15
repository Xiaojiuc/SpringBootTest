package com.qhit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
@RestController //表示该类下的方法的返回值会自动做 json 格式的转换
public class FileUploadController {
    @RequestMapping("/fileUpload")
    //http://127.0.0.1:8080/fileUpload
//        参数
    /*
    * file
    * */
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String file = request.getParameter("file");
        System.out.println(multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File("e:/" + multipartFile.getOriginalFilename()));
       return "thymeleaftest";
    }
}
