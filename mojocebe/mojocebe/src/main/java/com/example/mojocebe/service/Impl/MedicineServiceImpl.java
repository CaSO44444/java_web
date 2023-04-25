package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.MedicineDto;
import com.example.mojocebe.entity.Manager;
import com.example.mojocebe.entity.Medicine;
import com.example.mojocebe.entity.MedicineType;
import com.example.mojocebe.entity.Vendor;
import com.example.mojocebe.mapper.MedicineMapper;
import com.example.mojocebe.service.MedicineService;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineMapper medicineMapper;


    @Override
    public List<Medicine> queryall() {
        List<Medicine> queryall = this.medicineMapper.queryall();
        return queryall;
    }

    @Override
    public void delete(Integer id) {
        this.medicineMapper.deleteById(id);
    }

    @Override
    public void batchDelete(Integer[] ids) {
        this.medicineMapper.batchDelete(ids);
    }

    @Override
    public void add(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        BeanUtils.copyProperties(medicineDto,medicine);
        medicine.setStatus(0);

        MedicineType medicineType = new MedicineType();
        medicineType.setType_id(medicineDto.getMedicineTypeId());
        medicine.setMedicineType(medicineType);


        Manager manager = new Manager();
        manager.setManager_id(medicineDto.getManagerId());
        medicine.setManager(manager);

        Vendor vendor = new Vendor();
        vendor.setVendor_id(medicineDto.getVendorId());
        medicine.setVendor(vendor);
        System.out.println(medicine);
        this.medicineMapper.add(medicine);
    }

    @Override
    public Medicine getById(Integer id) {
        Medicine medicine = this.medicineMapper.getById(id);
        return medicine;
    }

    @Override
    public void edit(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        BeanUtils.copyProperties(medicineDto,medicine);
        medicine.setStatus(0);

        MedicineType medicineType = new MedicineType();
        medicineType.setType_id(medicineDto.getMedicineTypeId());
        medicine.setMedicineType(medicineType);


        Manager manager = new Manager();
        manager.setManager_id(medicineDto.getManagerId());
        medicine.setManager(manager);

        Vendor vendor = new Vendor();
        vendor.setVendor_id(medicineDto.getVendorId());
        medicine.setVendor(vendor);

        this.medicineMapper.edit(medicine);
    }
}
