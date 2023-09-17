package com.example.wxqserver_sb.service.Impl;

import com.example.wxqserver_sb.service.IStoreService;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class StoreServiceImpl implements IStoreService {
    @Override
    public Boolean save(MultipartFile file, String fileName, String filePath) {
        String path = filePath + fileName;
        File targetFile = new File(path);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }

        try {
            FileCopyUtils.copy(file.getBytes(), targetFile);
            return true;
        } catch (IOException e) {

        }
        return false;
    }
}
