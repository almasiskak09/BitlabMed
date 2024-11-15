package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.DiagnosticCategoryDTO;
import com.medProject.bitlabMed.entities.DiagnosticCategory;
import com.medProject.bitlabMed.mappers.DiagnosticCategoryMapper;
import com.medProject.bitlabMed.repositories.DiagnosticCategoryRepository;
import com.medProject.bitlabMed.services.DiagnosticCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosticCategoryServiceImpl implements DiagnosticCategoryService {

    private final DiagnosticCategoryRepository diagnosticCategoryRepository;
    private final DiagnosticCategoryMapper diagnosticCategoryMapper;

    public List<DiagnosticCategoryDTO> getAllDiagnosticsCategory(){
        List<DiagnosticCategory> diagnosticCategoryList = diagnosticCategoryRepository.findAll();
        return diagnosticCategoryMapper.toDtoList(diagnosticCategoryList);
    }
    public DiagnosticCategoryDTO addDiagnosticCategory (DiagnosticCategoryDTO diagnosticCategoryDTO){
        DiagnosticCategory diagnosticCategory = diagnosticCategoryMapper.toEntity(diagnosticCategoryDTO);
        diagnosticCategoryRepository.save(diagnosticCategory);
        return diagnosticCategoryMapper.toDto(diagnosticCategory);
    }
    public DiagnosticCategoryDTO getDiagnosticCategoryById(Long id){
        DiagnosticCategory diagnosticCategory = diagnosticCategoryRepository.findById(id).orElse(null);
        return diagnosticCategoryMapper.toDto(diagnosticCategory);
    }
    public DiagnosticCategoryDTO updateDiagnosticCategory(DiagnosticCategoryDTO diagnosticCategoryDTO){
        DiagnosticCategory diagnosticCategory = diagnosticCategoryMapper.toEntity(diagnosticCategoryDTO);
        diagnosticCategoryRepository.save(diagnosticCategory);
        return diagnosticCategoryMapper.toDto(diagnosticCategory);
    }
    public void deleteDiagnosticCategoryById(Long id){
        diagnosticCategoryRepository.deleteById(id);
    }
}
