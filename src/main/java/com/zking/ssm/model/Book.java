package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Component
@ToString
public class Book implements Serializable{

    // 书本验证分组
    public static interface ValidateGroups {
        // 新增/修改
        public static interface AddEdit {
        }

        // 删除
        public static interface Del {

        }

    }

    @NotBlank(message = "ID不能为空", groups = {Book.ValidateGroups.Del.class })
    private Integer bookId;

    @NotBlank(message = "书名不能为空", groups = {Book.ValidateGroups.AddEdit.class})
    private String bookName;


    @NotNull(message = "价格不能为空",groups = {Book.ValidateGroups.AddEdit.class })
    @Min(value = 10 ,message = "价格必须大于10")
    private Float price;

    private Integer categoryId;

    public Book(Integer bookId, String bookName, Float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}