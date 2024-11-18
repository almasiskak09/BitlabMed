package com.medProject.bitlabMed.services.implementation;


import com.medProject.bitlabMed.dtos.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.ApplicationAnalyzes;
import com.medProject.bitlabMed.mappers.ApplicationAnalyzesMapper;
import com.medProject.bitlabMed.repositories.ApplicationAnalyzesRepository;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationAnalyzeServiceImpl implements ApplicationAnalyzesService {

    private final ApplicationAnalyzesRepository applicationAnalyzesRepository;
    private final ApplicationAnalyzesMapper applicationAnalyzesMapper;

   public List<ApplicationAnalyzesDTO> getAllApplicationAnalyzes(){
        List<ApplicationAnalyzes>applicationAnalyzes = applicationAnalyzesRepository.findAll();
        return applicationAnalyzesMapper.toDtoList(applicationAnalyzes);
    }
    public ApplicationAnalyzesDTO addApplicationAnalyzes (ApplicationAnalyzesDTO applicationAnalyzesDTO){
       ApplicationAnalyzes applicationAnalyzes = applicationAnalyzesMapper.toEntity(applicationAnalyzesDTO);
       applicationAnalyzesRepository.save(applicationAnalyzes);
       return applicationAnalyzesMapper.toDto(applicationAnalyzes);
    }
    public ApplicationAnalyzesDTO getApplicationAnalyzes(Long id){
       ApplicationAnalyzes applicationAnalyzes = applicationAnalyzesRepository.findById(id).orElse(null);
       return applicationAnalyzesMapper.toDto(applicationAnalyzes);
    }
    public ApplicationAnalyzesDTO updateApplicationAnalyzes(ApplicationAnalyzesDTO applicationAnalyzesDTO){
       ApplicationAnalyzes applicationAnalyzes = applicationAnalyzesMapper.toEntity(applicationAnalyzesDTO);
       applicationAnalyzesRepository.save(applicationAnalyzes);
       return applicationAnalyzesMapper.toDto(applicationAnalyzes);
    }
    public void deleteApplicationAnalyzesById(Long id){
       applicationAnalyzesRepository.deleteById(id);
    }


}

