package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DiagnosticDto.AppointmentDiagnosticDto;
import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.Diagnostic.AppointmentDiagnostic;
import com.medProject.bitlabMed.entities.Diagnostic.Diagnostic;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import com.medProject.bitlabMed.entities.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentDiagnosticMapper {


    @Mapping(source = "diagnosticId", target = "diagnostic" ,qualifiedByName = "idToDiagnostic")
    @Mapping(source = "userId", target = "user", qualifiedByName = "idToUser")
    AppointmentDiagnostic toEntity(AppointmentDiagnosticDto appointmentDiagnosticDto);

    @Mapping(source = "diagnostic.id", target = "diagnosticId")
    @Mapping(source = "user.id", target = "userId")
    AppointmentDiagnosticDto toDto(AppointmentDiagnostic appointmentDiagnostic);

    @Named("idToUser")
    default User idToUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }

    @Named("idToDiagnostic")
    default Diagnostic idToDiagnostic(Long diagnosticId) {
        if (diagnosticId == null) {
            return null;
        }
        Diagnostic diagnostic = new Diagnostic();
        diagnostic.setId(diagnosticId);
        return diagnostic;
    }

    List<AppointmentDiagnosticDto> toDtoList(List<AppointmentDiagnostic> appointmentDiagnosticsList);

}

