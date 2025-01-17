package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes.Analyzes;

import java.util.List;

public interface AnalyzesService {

    List<AnalyzesDTO> getAllAnalyzes();
    AnalyzesDTO addAnalyze (AnalyzesDTO analyzesDTO);
    AnalyzesDTO getAnalyzeById(Long id);
    AnalyzesDTO updateAnalyze(AnalyzesDTO analyzesDTO);
    void deleteAnalyzeById(Long id);
    List<AnalyzesDTO> findByAnalyzesCategory_Id(Long categoryId);
    List<Analyzes>findAllById(List<Long> ids);
}
