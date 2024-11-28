package com.medProject.bitlabMed.dtos.DiagnosticDto;
import com.medProject.bitlabMed.entities.Diagnostic.Diagnostic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDiagnosticDto {


    private Long id;
    private String patientFullName;
    private String patientPhone;
    private Long diagnosticId;
    private Diagnostic diagnostic;
    private LocalDate diagnosticAppointmentDate;
    private Long userId;
    private boolean isPresent;
    private boolean isHandled;

    public String getFormattedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM", new Locale("ru"));
        return getDiagnosticAppointmentDate().format(formatter);
    }

}
