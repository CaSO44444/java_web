package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.PatientDto;
import com.example.mojocebe.entity.Doctor;
import com.example.mojocebe.entity.Patient;
import com.example.mojocebe.mapper.PatientMapper;
import com.example.mojocebe.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatienServiceImpl implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public List<Patient> queryall() {
        List<Patient> queryall = patientMapper.queryall();
        return queryall;
    }

    @Override
    public void add(PatientDto patientDto) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto,patient);
        patient.setStatus(0);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(patientDto.getDoctor_id());
        patient.setDoctor(doctor);
        System.out.println(patient);
        patientMapper.add(patient);
    }

    @Override
    public void edit(PatientDto patientDto) {
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto,patient);
        patient.setStatus(0);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(patientDto.getDoctor_id());
        patient.setDoctor(doctor);
        patientMapper.edit(patient);

    }

    @Override
    public Patient find(Integer id) {
        Patient patient = patientMapper.find(id);
        return patient;
    }

    @Override
    public void delete(Integer id) {
        patientMapper.delete(id);
    }

    @Override
    public void BatchRemove(Integer[] integers) {
        patientMapper.BatchRemove(integers);
    }
}
