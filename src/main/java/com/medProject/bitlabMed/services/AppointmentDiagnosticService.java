package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.DiagnosticDto.AppointmentDiagnosticDto;
import java.util.List;

public interface AppointmentDiagnosticService {

//    Map<LocalDate, List<LocalTime>> getWeekSchedule(Long doctorId, LocalDate startDate);

    List<AppointmentDiagnosticDto> getAllAppointmentDiagnosticList();
    AppointmentDiagnosticDto addAppointmentDiagnostic ( AppointmentDiagnosticDto appointmentDiagnosticDto);
    AppointmentDiagnosticDto getAppointmentDiagnosticById(Long id);
    AppointmentDiagnosticDto updateAppointmentDiagnostic(Long id);
    void deleteAppointmentDiagnosticById(Long id);
    List<AppointmentDiagnosticDto> getAppointmentDiagnosticsByUserId(Long userId);
}
