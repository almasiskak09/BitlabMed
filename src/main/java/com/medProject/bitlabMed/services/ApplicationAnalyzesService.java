package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;

import java.util.List;

public interface ApplicationAnalyzesService {

    List<ApplicationAnalyzesDTO> getAllApplicationAnalyzes();
    public ApplicationAnalyzesDTO addApplicationAnalyzes (ApplicationAnalyzesDTO applicationAnalyzesDTO);
    ApplicationAnalyzesDTO getApplicationAnalyzes(Long id);
    ApplicationAnalyzesDTO updateApplicationAnalyzes(Long id);
    void deleteApplicationAnalyzesById(Long id);
    List<AnalyzesDTO> getAllAnalyzesByIds(List<Long> id);

}
