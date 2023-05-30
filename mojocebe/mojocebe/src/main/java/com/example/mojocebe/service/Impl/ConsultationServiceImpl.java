package com.example.mojocebe.service.Impl;

import com.example.mojocebe.Dto.ConsultationDto;
import com.example.mojocebe.entity.*;
import com.example.mojocebe.mapper.ConsultationMapper;
import com.example.mojocebe.service.ConsultationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private ConsultationMapper consultationMapper;
    @Override
    public List<Consultation> queryall() {
        List<Consultation> queryall = consultationMapper.queryall();
        return queryall;
    }

    public List<Consultation> selectBydoctorId(Integer docker_id, Integer status){
        List<Consultation> selectBydoctorId = consultationMapper.selectBydoctorId(docker_id, status);
        return selectBydoctorId;
    }

    public List<Consultation> selectByPatientName(String patient_name){
        List<Consultation> selectByPatientName = consultationMapper.selectByPatientName(patient_name);
        return selectByPatientName;
    }

    public List<Consultation> selectBydate(Date time,String docker_id, String status){
        List<Consultation> selectBydate = consultationMapper.selectBydate(time,docker_id,status);
        return selectBydate;
    }
    @Override
    public void add(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();
        BeanUtils.copyProperties(consultationDto,consultation);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(consultationDto.getDoctorId());
        consultation.setDoctor(doctor);

        Dept dept = new Dept();
        dept.setDept_id(consultationDto.getDeptId());
        consultation.setDept(dept);

        Medicine medicine = new Medicine();
        medicine.setMedicine_id(consultationDto.getMedicineId());
        consultation.setMedicine(medicine);

        Patient patient = new Patient();
        patient.setId(consultationDto.getPatientId());
        consultation.setPatient(patient);
        this.consultationMapper.add(consultation);

    }

    @Override
    public void delete(Integer id) {
        this.consultationMapper.deleteById(id);
    }

    @Override
    public void batchDelete(Integer[] ids) {
        this.consultationMapper.batchRemove(ids);
    }
}
