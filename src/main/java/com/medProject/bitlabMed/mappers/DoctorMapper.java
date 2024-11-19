package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorDTO toDto(Doctor doctor);
    Doctor toEntity(DoctorDTO doctorDto);
    List<DoctorDTO>toDtoList(List<Doctor> doctorList);
    List<Doctor>toEntityList(List<DoctorDTO>doctorDTOList);
}
