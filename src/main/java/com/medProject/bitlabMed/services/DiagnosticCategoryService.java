package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.DiagnosticDto.DiagnosticCategoryDTO;

import java.util.List;

public interface DiagnosticCategoryService {

    List<DiagnosticCategoryDTO> getAllDiagnosticsCategory();
    DiagnosticCategoryDTO addDiagnosticCategory (DiagnosticCategoryDTO diagnosticCategoryDTO);
    DiagnosticCategoryDTO getDiagnosticCategoryById(Long id);
    DiagnosticCategoryDTO updateDiagnosticCategory(DiagnosticCategoryDTO diagnosticCategoryDTO);
    void deleteDiagnosticCategoryById(Long id);
    List<DiagnosticCategoryDTO> findDiagnosticCategoryByDiagnosticName(String name);
}
