package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;



    @Override
    public int deleteByPrimaryKey(Book book) {
        return bookMapper.deleteByPrimaryKey(book.getBookId());
    }

    @Override
    public int insert(Book record) {

        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Book selectByPrimaryKey(Book book) {

        return bookMapper.selectByPrimaryKey(book.getBookId());
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return 0;
    }

    @Override
    public List<Book> list(Book book, PageBean pageBean) {
        return bookMapper.list(book);
    }

    @Override
    public int updateByPrimaryKey(Book record) {

        return bookMapper.updateByPrimaryKey(record);
    }
}
