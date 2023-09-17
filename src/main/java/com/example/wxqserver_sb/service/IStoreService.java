package com.example.wxqserver_sb.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IStoreService {
    // file 源文件； fileName文件名称； filePath 上传后的文件路径
    Boolean save(MultipartFile file, String fileName, String filePath) throws IOException;
}
