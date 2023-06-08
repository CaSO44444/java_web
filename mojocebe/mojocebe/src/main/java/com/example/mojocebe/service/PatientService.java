package com.example.mojocebe.service;

import com.example.mojocebe.Dto.PatientDto;
import com.example.mojocebe.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> queryall();

    List<Patient> queryById(Integer patient_id);
    void add(PatientDto patientDto);

    void edit(PatientDto patientDto);
    void editbyid(Integer patientID, Integer doctorID);
    Patient find(Integer id);

    void delete(Integer id);
    void BatchRemove(Integer[] integers);
    void registerAdd(String name, String tel, String id_card);
}
