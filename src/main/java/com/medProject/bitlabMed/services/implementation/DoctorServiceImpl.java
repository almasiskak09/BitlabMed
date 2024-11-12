package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.DoctorDTO;
import com.medProject.bitlabMed.entities.Doctor;
import com.medProject.bitlabMed.mappers.DoctorMapper;
import com.medProject.bitlabMed.repositories.DoctorRepository;
import com.medProject.bitlabMed.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public List<DoctorDTO> getAllDoctors(){
        List<Doctor>doctorList = doctorRepository.findAll();
        return doctorMapper.toDtoList(doctorList);
    }
    public DoctorDTO addDoctor (DoctorDTO doctorDto){
        Doctor doc = doctorMapper.toEntity(doctorDto);
        doctorRepository.save(doc);
        return doctorMapper.toDto(doc);
    }
    public DoctorDTO getDoctorById(Long id){
        return doctorMapper.toDto(doctorRepository.findById(id).orElseThrow(null));
    }
    public DoctorDTO updateDoctor(DoctorDTO doctorDto){
        Doctor doc = doctorMapper.toEntity(doctorDto);
        doctorRepository.save(doc);
        return doctorMapper.toDto(doc);
    }
    public void deleteCarById(Long id){
        doctorRepository.deleteById(id);
    }
}
