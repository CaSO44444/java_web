package com.example.mojocebe.service;

import com.example.mojocebe.Dto.VendorDto;
import com.example.mojocebe.entity.Vendor;
import io.swagger.models.auth.In;

import java.util.List;

public interface
VendorService {
    List<Vendor> queryall();

    void add(VendorDto vendorDto);

    Vendor getById(Integer id);

    void  update(VendorDto vendorDto);

    void delete(Integer id);

    void batchDelete(Integer[] ids);
}
