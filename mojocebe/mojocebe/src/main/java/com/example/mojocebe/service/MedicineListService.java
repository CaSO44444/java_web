package com.example.mojocebe.service;

import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.MedicineList;

import java.util.List;

public interface MedicineListService {
    List<MedicineList> queryAll();

    List<MedicineList> selectByPId(Integer patient_id);

    List<MedicineList> selectByDId(int doctor_id);

    void add(MedicineListDto medicineListDto);

    void deleteById(Integer id);
}
