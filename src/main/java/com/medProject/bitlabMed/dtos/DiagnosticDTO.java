package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticDTO extends BaseEntity {

    private String diagnosticName;
    private LocalDate diagnosticCompletedDate;
    private int diagnosticPrice;
    private boolean diagnosticStatus;

}
