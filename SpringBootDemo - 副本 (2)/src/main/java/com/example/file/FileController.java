package com.example.file;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 */
@Controller
@RequestMapping("file")
public class FileController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");


    @RequestMapping("file")
    public String file() {
        return "file";
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String time = sdf.format(System.currentTimeMillis());
            File dest = new File("/Users/yutianran/Desktop", time + "_" + file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), dest);
        }
        return "上传成功";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download() throws IOException {
        String filename = "down.jpg";
        File file = new File("/Users/yutianran/Pictures", filename);
        //封装http头部信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", filename);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
