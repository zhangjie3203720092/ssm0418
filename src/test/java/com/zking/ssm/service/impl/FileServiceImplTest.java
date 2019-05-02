package com.zking.ssm.service.impl;

import com.zking.ssm.model.File;
import com.zking.ssm.service.IFileService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

public class FileServiceImplTest extends BaseTestCase {

    @Autowired
    private IFileService fileService;
    private com.zking.ssm.model.File file;
    @Override
    public void before() {
        super.before();
        file = new com.zking.ssm.model.File();
    }

    @Test
    public void add() {
        String fileId = UUID.randomUUID().toString().replaceAll("-","");
        String type = "image/img";
        String url = "F:\\test\\uploads";
        String fileName = "1.jpg";
        file.setFileId(fileId);
        file.setUrl(url);
        file.setContentType(type);
        file.setRealName(fileName);
        fileService.add(file);
    }

    @Test
    public void load() {
        file.setFileId("c74ca84470394fbfb38c7a420a9c9b74");
        File f = fileService.load(file);
        System.out.println(f);
    }
}