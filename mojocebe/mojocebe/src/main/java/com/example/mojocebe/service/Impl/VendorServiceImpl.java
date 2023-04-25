package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.VendorDto;
import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.entity.Manager;
import com.example.mojocebe.entity.Vendor;
import com.example.mojocebe.mapper.VendorMapper;
import com.example.mojocebe.service.VendorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendorServiceImpl implements VendorService{
    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public List<Vendor> queryall() {
        List<Vendor> queryall = vendorMapper.queryall();
        return queryall;
    }

    @Override
    public void add(VendorDto vendorDto) {
        Vendor vendor = new Vendor();
        BeanUtils.copyProperties(vendorDto,vendor);
        vendor.setStatus(0);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(vendorDto.getDoctorId());
        vendor.setDoctor(doctor);

        Manager manager = new Manager();
        manager.setManager_id(vendorDto.getManagerId());
        vendor.setManager(manager);
        System.out.println(vendor);
        this.vendorMapper.add(vendor);
    }

    @Override
    public Vendor getById(Integer id) {
        Vendor vendor = this.vendorMapper.getById(id);
        return vendor;
    }

    @Override
    public void update(VendorDto vendorDto) {
        Vendor vendor = new Vendor();
        BeanUtils.copyProperties(vendorDto,vendor);
        vendor.setStatus(0);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(vendorDto.getDoctorId());
        vendor.setDoctor(doctor);

        Manager manager = new Manager();
        manager.setManager_id(vendorDto.getManagerId());
        vendor.setManager(manager);
        this.vendorMapper.update(vendor);
    }

    @Override
    public void delete(Integer id) {
        this.vendorMapper.deleteById(id);
    }

    @Override
    public void batchDelete(Integer[] ids) {
        this.vendorMapper.batchDelete(ids);
    }
}
