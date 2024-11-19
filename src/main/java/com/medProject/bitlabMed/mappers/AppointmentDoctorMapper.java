package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import com.medProject.bitlabMed.entities.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AppointmentDoctorMapper {


    @Mapping(source = "doctorId", target = "doctor" ,qualifiedByName = "idToDoctor")
    @Mapping(source = "userId", target = "user", qualifiedByName = "idToUser")
    AppointmentDoctor toEntity(AppointmentDoctorDto appointmentDoctorDto);

    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "user.id", target = "userId")
    AppointmentDoctorDto toDto(AppointmentDoctor appointmentDoctor);

    @Named("idToUser")
    default User idToUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }

    @Named("idToDoctor")
    default Doctor idToDoctor(Long doctorId) {
        if (doctorId == null) {
            return null;
        }
        Doctor doctor = new Doctor();
        doctor.setId(doctorId);
        return doctor;
    }

    List<AppointmentDoctorDto> toDtoList(List<AppointmentDoctor> appointmentDoctors);

}