package com.example.mojocebe.service;

import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.MedicineList;

public interface MedicineListService {
    MedicineListDto getByPid(Integer patient_id);

    MedicineListDto getByDid(Integer doctor_id);

    void add(MedicineListDto medicineListDto);
}
