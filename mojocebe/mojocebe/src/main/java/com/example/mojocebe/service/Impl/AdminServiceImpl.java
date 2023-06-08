package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.AdminDto;
import com.example.mojocebe.entity.Admin;
import com.example.mojocebe.mapper.AdminMapper;
import com.example.mojocebe.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = this.adminMapper.getAllAdmins();
        return admins;
    }

    @Override
    public void createAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        adminMapper.createAdmin(admin);
    }

    @Override
    public void updateAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDto, admin);
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminMapper.deleteAdmin(id);
    }

}

