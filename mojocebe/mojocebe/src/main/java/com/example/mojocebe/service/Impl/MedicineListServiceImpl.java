package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.MedicineListDto;
import com.example.mojocebe.entity.*;
import com.example.mojocebe.mapper.MedicineListMapper;
import com.example.mojocebe.service.MedicineListService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public List<MedicineList> selectByPId(Integer patient_id){
        List<MedicineList> selectByPId = this.medicineListMapper.selectByPId(patient_id);
        return selectByPId;
    }

    @Override
    public List<MedicineList> selectByDId(int doctor_id){
        List<MedicineList> selectByDId = this.medicineListMapper.selectByDId(doctor_id);
        return selectByDId;
    }

    @Override
    public void add(MedicineListDto medicineListDto){
        MedicineList medicineList = new MedicineList();
        BeanUtils.copyProperties(medicineListDto,medicineList);
        ;
        Medicine medicine = new Medicine();
        medicine.setMedicine_id(medicineListDto.getMedicine_id());
        medicineList.setMedicine(medicine);

        this.medicineListMapper.add(medicineList);

    }

    @Override
    public void deleteById(Integer id){
        this.medicineListMapper.deleteById(id);
    }
}
