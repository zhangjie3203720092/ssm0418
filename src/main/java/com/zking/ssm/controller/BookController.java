package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.ResponseResult;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sys/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public void init(Model model){
        Book bk = new Book();
        model.addAttribute("book",bk);
        model.addAttribute("categoryIds",new Integer[]{1,2,3,4});
    }


    @RequestMapping("/toAdd")
    public String toAdd(){
        return "sys/addBook";
    }
    @RequestMapping("/toList")
    public String toList(){
        return "sys/listBook";
    }

    @RequestMapping("/add")
    public String add(@Validated(value = {Book.ValidateGroups.AddEdit.class}) Book book, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){//可能出现的错误

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField());
                System.out.println(fieldError.getDefaultMessage());
            }
            return "sys/addBook";
        }

        boolean b = model.containsAttribute("bk");
        System.out.println(b);
        bookService.insert(book);
        return "redirect:/sys/book/listBook";
    }

    @RequestMapping("/add2")
    @ResponseBody
    public Map<String,Object> add2(@Validated(value = {Book.ValidateGroups.AddEdit.class}) Book book, BindingResult bindingResult,Model model){
        Map<String,Object>jsonData=new HashMap<String,Object>();
        jsonData.put("code",0);
        jsonData.put("msg","新增成功!");

        if(bindingResult.hasErrors()){//可能出现的错误
            Map<String,Object>errors=new HashMap<String,Object>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
//                System.out.println(fieldError.getField());
//                System.out.println(fieldError.getDefaultMessage());
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                errors.put(field,message);
            }
            jsonData.put("code",-1);
            jsonData.put("msg","添加失败!");
            jsonData.put("error",errors);
            return jsonData;
        }
        boolean b = model.containsAttribute("bk");
        System.out.println(b);
        bookService.insert(book);
        return jsonData;
    }

    @RequestMapping("/add3")
    @ResponseBody
    public ResponseResult<Map<String,Object>> add3(@Validated(value = {Book.ValidateGroups.AddEdit.class}) Book book, BindingResult bindingResult, Model model){
        ResponseResult<Map<String,Object>> responseResult=new ResponseResult<Map<String,Object>>(1,"添加成功",null);

        if(bindingResult.hasErrors()){//可能出现的错误
            Map<String,Object>errors=new HashMap<String,Object>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
//                System.out.println(fieldError.getField());
//                System.out.println(fieldError.getDefaultMessage());
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                errors.put(field,message);
            }
            responseResult.setStatus(0);
            responseResult.setMessage("添加失败");
            responseResult.setData(errors);
            return responseResult;

        }
        boolean b = model.containsAttribute("bk");
        System.out.println(b);
        bookService.insert(book);
        return responseResult;
    }



    @RequestMapping("/edit")
    public ModelAndView edit(Book book,ModelAndView modelAndView){
        Book book1 = bookService.selectByPrimaryKey(book);
        modelAndView.addObject("book1",book1);
        modelAndView.setViewName("sys/editBook");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Book book){
        book.setBookId(book.getBookId());
        book.setBookName(book.getBookName());
        book.setPrice(book.getPrice());
        bookService.updateByPrimaryKey(book);
        return "redirect:/sys/book/listBook";
    }


    @RequestMapping("/del")
    public String del(Book book,Model model){
        boolean b = model.containsAttribute("bk");
        bookService.deleteByPrimaryKey(book);
        return "redirect:/sys/book/listBook";
    }

    @RequestMapping("/listBook")
    public ModelAndView listBook(Book book, ModelAndView modelAndView, HttpServletRequest req,PageBean pageBean){
        //分页初始化
        pageBean.setRequest(req);
        System.out.println(pageBean);
        List<Book> bookList = bookService.list(book, pageBean);
        modelAndView.addObject("pageBean",pageBean);
        modelAndView.addObject("bookList",bookList);
        modelAndView.setViewName("sys/listBook");
        return modelAndView;
    }

}
