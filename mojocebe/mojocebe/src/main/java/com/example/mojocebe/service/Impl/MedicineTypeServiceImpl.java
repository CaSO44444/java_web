package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.MedicineType;
import com.example.mojocebe.mapper.MedicineTypeMapper;
import com.example.mojocebe.service.MedicineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineTypeServiceImpl implements MedicineTypeService {
    @Autowired
    private MedicineTypeMapper medicineTypeMapper;


    @Override
    public List<MedicineType> query() {
        List<MedicineType> query = this.medicineTypeMapper.query();
        return query;
    }
}
