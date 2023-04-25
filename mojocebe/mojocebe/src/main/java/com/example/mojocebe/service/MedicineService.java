package com.example.mojocebe.service;

import com.example.mojocebe.Dto.MedicineDto;
import com.example.mojocebe.entity.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> queryall();
    void delete(Integer id);

    void batchDelete(Integer[] ids);
    void add(MedicineDto medicineDto);

    Medicine getById(Integer id);

    void edit(MedicineDto medicineDto);
}
