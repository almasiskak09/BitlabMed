package com.medProject.bitlabMed.services;

import com.medProject.bitlabMed.dtos.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.DiagnosticDTO;

import java.util.List;

public interface DiagnosticService {

    List<DiagnosticDTO> getAllDiagnostics();
    DiagnosticDTO addDiagnostic (DiagnosticDTO diagnosticDTO);
    DiagnosticDTO getDiagnosticById(Long id);
    DiagnosticDTO updateDiagnostic(DiagnosticDTO diagnosticDTO);
    void deleteDiagnosticById(Long id);
}
