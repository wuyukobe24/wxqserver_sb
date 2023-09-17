package com.example.wxqserver_sb.controllers;

import com.example.wxqserver_sb.service.IStoreService;
import com.example.wxqserver_sb.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/")
public class CommonController {

    @Autowired
    private IStoreService storeService;

    @Value("${upload.accessPath}")
    private String accessPath;

    @Value("${upload.localPath}")
    private String localPath;

    @PostMapping(value = "/upload")
    public Result upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = mulRequest.getFile("file");
        String fileName = file.getOriginalFilename();
        log.info("Upload file name = {}",fileName);

        storeService.save(file, fileName, localPath);
        return Result.success(accessPath+fileName);
    }
}
