package com.example.mojocebe.service;

import com.example.mojocebe.entity.News;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NewsService {

    List<News> queryNews();
}
