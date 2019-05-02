package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller

public class HelloController {



    public String hello(HttpServletRequest request){
        System.out.println("萨瓦迪卡");
        System.out.println("hello,陈大雁");
        return "a";
    }


    public String add(Book book,@RequestParam("status") String str){
        System.out.println(book);
        System.out.println(str);
        return null;
    }

}
