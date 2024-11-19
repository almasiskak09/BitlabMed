package com.medProject.bitlabMed.dtos.AnalyzesDto;

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
public class ApplicationAnalyzesDTO {

    private Long id;
    private String apUserFullName;
    private String apUserPhone;
    private int apTotalPrice;
    private LocalDate apCreatedDate;
    private List<Long> analyzesIds;
    private Long userId;

}
