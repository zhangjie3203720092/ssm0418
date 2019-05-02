package com.zking.ssm.controller;

import com.zking.ssm.service.IFileService;
import com.zking.ssm.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/sys/file")
public class FileController {
    @Autowired
    private IFileService fileService;
    @ModelAttribute
    public void init(Model model){
        model.addAttribute("fileVo",new FileVo());
    }

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "sys/upload";
    }

    //文件上传
    @RequestMapping("/upload")
    public String upload(MultipartFile img, HttpSession session) throws Exception{
//        System.out.println(img);
//        System.out.println(img.getContentType());
//        System.out.println(img.getOriginalFilename());
        //保存文件上传记录
        com.zking.ssm.model.File file =new com.zking.ssm.model.File();
        String fileId = UUID.randomUUID().toString().replaceAll("-","");
        String type = img.getContentType();
        String fileName = img.getOriginalFilename();
        String url = "F:\\test\\uploads\\"+fileId;
        file.setFileId(fileId);
        file.setUrl(url);
        file.setContentType(type);
        file.setRealName(fileName);
        fileService.add(file);
        //把文件保存到文件服务器
        File targetFile  = new File(url);
        img.transferTo(targetFile);

        String msg = "文件上传成功";
        session.setAttribute("msg",msg);

        return "redirect:/sys/file/toUpload";
    }

    //文件下载
    @RequestMapping("/download")
    public String download() throws Exception{
        return null;
    }

}
