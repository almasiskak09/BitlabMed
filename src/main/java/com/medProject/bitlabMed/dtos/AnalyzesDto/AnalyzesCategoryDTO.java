package com.medProject.bitlabMed.dtos.AnalyzesDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzesCategoryDTO {

    private Long id;
    private String analyzesCategoryName;
    private List<AnalyzesDTO> analyzesList;
}
