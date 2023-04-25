package com.example.mojocebe.controller;

import com.example.mojocebe.entity.Title;
import com.example.mojocebe.service.TitleService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TitleController {
    @Autowired
    private TitleService titleService;

    @GetMapping("/title/query")
    public Result query(){
        List<Title> queryall = titleService.queryall();
        return new Result().ok(queryall);
    }
}
