package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.DiagnosticDto.AppointmentDiagnosticDto;
import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.Diagnostic.AppointmentDiagnostic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface AppointmentDiagnosticService {

//    Map<LocalDate, List<LocalTime>> getWeekSchedule(Long doctorId, LocalDate startDate);

    List<AppointmentDiagnosticDto> getAllAppointmentDiagnosticList();
    AppointmentDiagnosticDto addAppointmentDiagnostic ( AppointmentDiagnosticDto appointmentDiagnosticDto);
    AppointmentDiagnosticDto getAppointmentDiagnosticById(Long id);
    AppointmentDiagnosticDto updateAppointmentDiagnostic(AppointmentDiagnosticDto appointmentDiagnosticDto);
    void deleteAppointmentDiagnosticById(Long id);
}
