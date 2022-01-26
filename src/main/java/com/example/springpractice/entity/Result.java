package com.example.springpractice.entity;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result success(T t){
        this.setCode(0);
        this.setMsg("success");
        this.setData(t);
        return this;
    }

    public Result fail(String msg){
        this.setCode(-1);
        this.setMsg(msg);
        return this;
    }


    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}