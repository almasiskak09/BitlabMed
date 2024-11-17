package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.dtos.ApplicationAnalyzesDTO;

import java.util.List;

public interface ApplicationAnalyzesService {

    List<ApplicationAnalyzesDTO> getAllApplicationAnalyzes();
    ApplicationAnalyzesDTO addApplicationAnalyzes (ApplicationAnalyzesDTO applicationAnalyzesDTO);
    ApplicationAnalyzesDTO getApplicationAnalyzes(Long id);
    ApplicationAnalyzesDTO updateApplicationAnalyzes(ApplicationAnalyzesDTO applicationAnalyzesDTO);
    void deleteApplicationAnalyzesById(Long id);
}
