package com.zking.ssm.service.impl;

import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsCategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class NewsCategoryServiceImplTest extends BaseTestCase {

    @Autowired
    private INewsCategoryService newsCategoryService;

    @Override
    public void before() {
        super.before();
    }

    @Test
    public void newsOfCategory() {
        News news = new News();
        news.setNewsId(2);
        News n = newsCategoryService.newsOfCategory(news);
        System.out.println(n);
    }
}