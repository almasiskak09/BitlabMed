package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDTO;
import com.medProject.bitlabMed.entities.AnalyzesCategory;

import java.util.List;

public interface AnalyzesCategoryService {

    List<AnalyzesCategoryDTO> getAllAnalyzesCategory();
    AnalyzesCategoryDTO addAnalyzeCategory (AnalyzesCategoryDTO analyzesCategoryDTO);
    AnalyzesCategoryDTO getAnalyzeCategoryById(Long id);
    AnalyzesCategoryDTO updateAnalyzeCategory(AnalyzesCategoryDTO analyzesCategoryDTO);
    void deleteAnalyzeCategoryById(Long id);


}
