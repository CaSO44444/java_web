package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.Title;
import com.example.mojocebe.mapper.TitleMapper;
import com.example.mojocebe.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    private TitleMapper titleMapper;
    @Override
    public List<Title> queryall() {
        List<Title> queryall = titleMapper.queryall();
        return queryall;
    }
}
