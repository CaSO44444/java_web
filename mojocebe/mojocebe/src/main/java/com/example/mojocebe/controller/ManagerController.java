package com.example.mojocebe.controller;

import com.example.mojocebe.entity.Manager;
import com.example.mojocebe.service.ManagerService;
import com.example.mojocebe.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/manager/query")
    public Result query(){
        List<Manager> query = managerService.query();
        return new Result().ok(query);
    }
}
