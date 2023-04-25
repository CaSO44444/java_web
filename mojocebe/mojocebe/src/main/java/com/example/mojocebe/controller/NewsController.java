package com.example.mojocebe.controller;

import com.example.mojocebe.entity.News;
import com.example.mojocebe.service.NewsService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsService newsService;


    @GetMapping("/news/query")
    public Result queryNews(){
        List<News> query = this.newsService.queryNews();
        return new Result().ok(query);

    }
}
