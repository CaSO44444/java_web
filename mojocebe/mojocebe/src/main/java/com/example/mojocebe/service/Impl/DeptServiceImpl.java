package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.Dept;
import com.example.mojocebe.mapper.DeptMapper;
import com.example.mojocebe.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryall(){
        List<Dept> queryalldept = deptMapper.queryalldept();

        return queryalldept;
    }
}
