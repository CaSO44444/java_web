package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.Medicine;
import com.example.mojocebe.entity.MedicineList;
import com.example.mojocebe.entity.Patient;
import com.example.mojocebe.mapper.MedicineListMapper;
import com.example.mojocebe.service.MedicineListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineListServiceImpl implements MedicineListService {
    private final MedicineListMapper medicineListMapper;

    @Autowired
    public MedicineListServiceImpl(MedicineListMapper medicineListMapper) {
        this.medicineListMapper = medicineListMapper;
    }

    @Override
    public void add(MedicineListDto medicineListDto) {
        medicineListMapper.add(medicineListDto);
    }
    @Override
    public MedicineListDto getByPid(Integer patient_id) {
        return medicineListMapper.getByPid(patient_id);
    }
    @Override
    public MedicineListDto getByDid(Integer doctor_id){
        return medicineListMapper.getByDid(doctor_id);
    }
}
