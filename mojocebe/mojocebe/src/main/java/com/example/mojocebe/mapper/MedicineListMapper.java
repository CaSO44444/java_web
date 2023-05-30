package com.example.mojocebe.mapper;

import com.example.mojocebe.Dto.MedicineDto;
import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.MedicineList;

public interface MedicineListMapper {
    MedicineListDto getByPid(Integer patient_id);

    MedicineListDto getByDid(Integer doctor_id);

    void add(MedicineListDto medicineListDto);
}
