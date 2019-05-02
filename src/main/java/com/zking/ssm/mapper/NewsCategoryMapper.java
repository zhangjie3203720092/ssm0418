package com.zking.ssm.mapper;

import com.zking.ssm.model.News;
import com.zking.ssm.model.NewsCategory;

public interface NewsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);

    News newsOfCategory(News news);
}