package com.example.springpractice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class FileController {

    @Value("${fileLocation}")
    private String fileLocation;

    @PostMapping("/upload")
    public void upload(MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(file.getOriginalFilename()); // 文件名
        System.out.println(file.getContentType()); // 文件类型
        System.out.println(file.getSize()); // 文件大小

        System.out.println(file.getInputStream()); // 获得文件输入流

        // 获得web应用中 files文件夹的绝对路径
        String realPath = ResourceUtils.getURL("classpath:").getPath() + fileLocation;
        System.out.println(realPath);
        File newFile = new File(realPath);
        // 如果文件夹不存在、则新建
        if (!newFile.exists()) newFile.mkdirs();

        // 上传
        file.transferTo(new File(newFile, file.getOriginalFilename()));
    }

    @GetMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        try {
            // 获得web应用中 files文件夹的绝对路径
            String realPath = ResourceUtils.getURL("classpath:").getPath() + fileLocation;
            System.out.println(realPath);
            File newFile = new File(realPath);
            // 如果文件夹不存在、则新建
            if (!newFile.exists()) newFile.mkdirs();
            FileInputStream inputStream = new FileInputStream(new File(realPath, fileName));

            response.setHeader("content-disposition", "attachment; fileName=" + fileName);
            ServletOutputStream outputStream = response.getOutputStream();
            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
