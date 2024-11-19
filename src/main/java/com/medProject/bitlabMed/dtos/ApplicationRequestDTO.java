package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;
import com.medProject.bitlabMed.dtos.UserDto.UserDTO;
import com.medProject.bitlabMed.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDTO extends BaseEntity {

    private ClinicDTO clinic;
    private DoctorDTO applicationDoctor;
    private List<AnalyzesCategoryDTO> applicationAnalysesCategory;
    private List<DiagnosticDTO> applicationDiagnosticList;
    private UserDTO user;
    private LocalDate applicationDate;
    private boolean applicationBooked; //сделать запись иди удалить
    private boolean applicationDone; //пришел ли клиент на запись или нет ?
}
