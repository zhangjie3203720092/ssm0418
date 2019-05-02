package com.zking.ssm.vo;

import org.springframework.web.multipart.MultipartFile;

public class FileVo extends com.zking.ssm.model.File{
    private Integer bookId;
    private MultipartFile img;

    public FileVo() {

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
