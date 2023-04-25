package com.example.mojocebe.mapper;

import com.example.mojocebe.entity.Vendor;
import io.swagger.models.auth.In;

import java.util.List;

public interface VendorMapper {
    List<Vendor> queryall();
    void add(Vendor vendor);

    Vendor getById(Integer id);

    void update(Vendor vendor);

    void deleteById(Integer id);

    void batchDelete(Integer[] ids);
}
