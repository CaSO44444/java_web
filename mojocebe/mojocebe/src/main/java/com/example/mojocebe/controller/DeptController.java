package com.example.mojocebe.controller;


import com.example.mojocebe.entity.Dept;
import com.example.mojocebe.service.DeptService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping ("/dept/query")
    public Result querydept(){
        List<Dept> queryall = deptService.queryall();

        return new Result().ok(queryall);
    }
}
