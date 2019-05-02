package com.zking.ssm.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ToString
public class ResponseResult<T> implements Serializable{

    private Integer status;//状态

    //状态信息
    private String  message;

    //数据 ResponseResult<Void>
    private T data;

    public ResponseResult(){}

    public ResponseResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseResult(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
