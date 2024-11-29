package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;

import java.util.List;

public interface DoctorService {

    List<DoctorDTO> getAllDoctors();
    DoctorDTO addDoctor (DoctorDTO doctorDto);
    DoctorDTO getDoctorById(Long id);
    DoctorDTO updateDoctor(DoctorDTO doctorDto);
    void deleteCarById(Long id);
    List<DoctorDTO>  getDoctorsBySpeciality(String speciality);
}
