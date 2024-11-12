package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DoctorDTO;
import com.medProject.bitlabMed.entities.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorDTO toDto(Doctor doctor);
    Doctor toEntity(DoctorDTO doctorDto);
    List<DoctorDTO>toDtoList(List<Doctor> doctorList);
    List<Doctor>toEntityList(List<DoctorDTO>doctorDTOList);
}
