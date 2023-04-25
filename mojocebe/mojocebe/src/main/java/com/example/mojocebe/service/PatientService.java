package com.example.mojocebe.service;

import com.example.mojocebe.Dto.PatientDto;
import com.example.mojocebe.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> queryall();
    void add(PatientDto patientDto);

    void edit(PatientDto patientDto);

    Patient find(Integer id);

    void delete(Integer id);
    void BatchRemove(Integer[] integers);
}
