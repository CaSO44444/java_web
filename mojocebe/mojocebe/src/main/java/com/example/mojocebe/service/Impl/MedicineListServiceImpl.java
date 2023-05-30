package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.MedicineList;
import com.example.mojocebe.mapper.MedicineListMapper;
import com.example.mojocebe.service.MedicineListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineListServiceImpl implements MedicineListService {
    @Autowired
    private MedicineListMapper medicineListMapper;

    @Override
    public List<MedicineList> queryAll(){
        List<MedicineList> queryAll = this.medicineListMapper.queryAll();
        return queryAll;
    }
}
