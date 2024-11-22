package com.medProject.bitlabMed.dtos.DiagnosticDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDiagnosticDto {


    private Long id;
    private String patientFullName;
    private String patientPhone;
    private Long diagnosticId;
    private Long userId;
    private boolean isPresent;



}
