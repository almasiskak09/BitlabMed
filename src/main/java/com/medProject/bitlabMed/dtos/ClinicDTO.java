package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDTO extends BaseEntity {

    private String clinicName;
    private String clinicAddress;
    private List<UserDTO>clinicUsersList;
    private List<DoctorDTO> doctorList;
    private List<AnalyzesCategoryDTO>analyzesCategoryList;
    private List<DiagnosticDTO>diagnosticList;
}
