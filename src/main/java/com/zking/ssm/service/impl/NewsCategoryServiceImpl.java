package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.NewsCategoryMapper;
import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsCategoryServiceImpl implements INewsCategoryService {
    @Autowired
    private NewsCategoryMapper newsCategoryMapper;
    @Override
    public News newsOfCategory(News news) {
        return newsCategoryMapper.newsOfCategory(news);
    }
}
