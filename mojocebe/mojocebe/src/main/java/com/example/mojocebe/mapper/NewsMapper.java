package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NewsMapper {
    List<News> queryNews();
}
