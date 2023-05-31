package com.example.mojocebe.mapper;

import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.MedicineList;

import java.util.List;

public interface MedicineListMapper {

    List<MedicineList> queryAll();

    List<MedicineList> selectByPId(Integer patient_id);

    List<MedicineList> selectByDId(int doctor_id);

    void add(MedicineList medicineList);

    void deleteById(Integer id);
}
