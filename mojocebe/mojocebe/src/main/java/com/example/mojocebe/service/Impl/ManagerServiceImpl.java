package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.Manager;
import com.example.mojocebe.mapper.ManagerMapper;
import com.example.mojocebe.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;


    @Override
    public List<Manager> query() {
        List<Manager> query = managerMapper.query();
        return query;
    }
}
