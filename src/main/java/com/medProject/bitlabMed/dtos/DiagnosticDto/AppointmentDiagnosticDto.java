package com.medProject.bitlabMed.dtos.DiagnosticDto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDiagnosticDto {


    private Long id;
    private LocalDate diagnosticAppointmentDate;
    private LocalTime diagnosticAppointmentStartTime;
    private String patientFullName;
    private String patientPhone;
    private Long diagnosticId;
    private Long userId;
    private boolean isPresent;


    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        // Обнуляем секунды и наносекунды перед сохранением
        this.diagnosticAppointmentStartTime = appointmentStartTime.withSecond(0).withNano(0);
    }

}
