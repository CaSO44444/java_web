package com.example.mojocebe.mapper;

import com.example.mojocebe.Dto.MedicineDto;
import com.example.mojocebe.entity.Medicine;
import io.swagger.models.auth.In;

import java.util.List;

public interface MedicineMapper {
    List<Medicine> queryall();

    void deleteById(Integer id);

    void batchDelete(Integer[] ids);

    void add(Medicine medicine);

    Medicine getById(Integer id);

    void edit(Medicine medicine);
}
