package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.utils.PageBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBookService {
    int deleteByPrimaryKey(Book book);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Book book);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    List<Book> list(Book book, PageBean pageBean);


}