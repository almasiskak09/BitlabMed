package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.DiagnosticDto.DiagnosticDTO;
import com.medProject.bitlabMed.entities.Diagnostic.Diagnostic;
import com.medProject.bitlabMed.mappers.DiagnosticMapper;
import com.medProject.bitlabMed.repositories.DiagnosticRepository;
import com.medProject.bitlabMed.services.DiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosticServiceImpl implements DiagnosticService {

    private final DiagnosticRepository diagnosticRepository;
    private final DiagnosticMapper diagnosticMapper;

    public List<DiagnosticDTO> getAllDiagnostics(){
        List<Diagnostic>diagnosticList = diagnosticRepository.findAll();
        return diagnosticMapper.toDtoList(diagnosticList);
    }

    public DiagnosticDTO addDiagnostic (DiagnosticDTO diagnosticDTO){
        Diagnostic diagnostic = diagnosticMapper.toEntity(diagnosticDTO);
        diagnosticRepository.save(diagnostic);
        return diagnosticMapper.toDto(diagnostic);
    }
    public DiagnosticDTO getDiagnosticById(Long id){
        return diagnosticMapper.toDto(diagnosticRepository.findById(id).orElseThrow(null));
    }
    public DiagnosticDTO updateDiagnostic(DiagnosticDTO diagnosticDTO){
        Diagnostic diagnostic = diagnosticMapper.toEntity(diagnosticDTO);
        diagnosticRepository.save(diagnostic);
        return diagnosticMapper.toDto(diagnostic);
    }
    public void deleteDiagnosticById(Long id){
        diagnosticRepository.deleteById(id);
    }
}
