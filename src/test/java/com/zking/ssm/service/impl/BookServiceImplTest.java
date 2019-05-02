package com.zking.ssm.service.impl;

import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.StyledEditorKit;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest extends BaseTestCase {
    @Autowired
    private IBookService bookService;
    private Book book;
    @Override
    public void before() {
        super.before();
        book = new Book();
    }

    @Test
    public void deleteByPrimaryKey() {


    }

    @Test
    public void insert() {
        book.setBookName("米老头是傻皮");
        book.setPrice(50f);
        bookService.insert(book);
    }

    @Test
    public void selectByPrimaryKey() {
        book.setBookId(196);
        Book b = bookService.selectByPrimaryKey(this.book);
        System.out.println(b);

        System.out.println("===============");
        Book b1 = bookService.selectByPrimaryKey(this.book);
        System.out.println(b1);

    }

    @Test
    public void list() {
        book.setBookName("西");
        pageBean.setPage(1);
        pageBean.setRows(5);
        List<Book> bookList = bookService.list(book, pageBean);
        for (Book b : bookList) {
            System.out.println(b);
        }
        System.out.println(pageBean);
    }

    @Test
    public void updateByPrimaryKey() {
        book.setBookId(196);
        book.setBookName("米老头是傻皮250");
        book.setPrice(49f);
        bookService.updateByPrimaryKey(book);

    }

    @Test
    public void loadOfCache() {
        book.setBookId(196);
        Book b = bookService.selectByPrimaryKey(this.book);
        System.out.println(b);

        System.out.println("===============");
        Book b1 = bookService.selectByPrimaryKey(this.book);
        System.out.println(b1);

    }

    @Test
    public void listOfCache() {
        pageBean.setPage(3);
        pageBean.setRows(5);
        List<Book> bookList = bookService.list(book, pageBean);
        for (Book b : bookList) {
            System.out.println(b);
        }
        System.out.println("================");

        List<Book> bookList1 = bookService.list(book, pageBean);
        for (Book b : bookList1) {
            System.out.println(b);
        }

        System.out.println(pageBean);
    }


}