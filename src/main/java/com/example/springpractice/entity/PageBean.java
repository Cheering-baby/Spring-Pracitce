package com.example.springpractice.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private long total; // 表中一共有多少数据
    private int totalPage; // 一共多少页
    private int  pageSize = 10; // 默认分页
    private int pageNumber; // 当前页
    private List<T> data;
}
