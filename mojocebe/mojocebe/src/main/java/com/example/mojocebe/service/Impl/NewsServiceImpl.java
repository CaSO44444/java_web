package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.News;
import com.example.mojocebe.mapper.NewsMapper;
import com.example.mojocebe.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> queryNews(){
        List<News> queryNews = this.newsMapper.queryNews();
        return queryNews;
    }
}
