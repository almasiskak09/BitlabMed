package com.medProject.bitlabMed.services.implementation;


import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes.ApplicationAnalyzes;
import com.medProject.bitlabMed.mappers.AnalyzesMapper;
import com.medProject.bitlabMed.mappers.ApplicationAnalyzesMapper;
import com.medProject.bitlabMed.repositories.AnalyzesRepository;
import com.medProject.bitlabMed.repositories.ApplicationAnalyzesRepository;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApplicationAnalyzeServiceImpl implements ApplicationAnalyzesService {

    private final ApplicationAnalyzesRepository applicationAnalyzesRepository;
    private final ApplicationAnalyzesMapper applicationAnalyzesMapper;
    private final AnalyzesRepository analyzesRepository;
    private final AnalyzesMapper analyzesMapper;

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
    public ApplicationAnalyzesDTO updateApplicationAnalyzes(Long id){
       ApplicationAnalyzesDTO applicationAnalyzesDTO = applicationAnalyzesMapper.toDto(applicationAnalyzesRepository.findById(id).orElse(null));
       applicationAnalyzesDTO.setHandled(true);
       ApplicationAnalyzes applicationAnalyzes = applicationAnalyzesMapper.toEntity(applicationAnalyzesDTO);
       applicationAnalyzesRepository.save(applicationAnalyzes);
       return applicationAnalyzesMapper.toDto(applicationAnalyzes);
    }
    public void deleteApplicationAnalyzesById(Long id){
       applicationAnalyzesRepository.deleteById(id);
    }

    public List<AnalyzesDTO> getAllAnalyzesByIds(List<Long> analyzesIds){
       List<AnalyzesDTO> analyzesDTOList = analyzesMapper.toDtoList(analyzesRepository.findAllById(analyzesIds));
       return analyzesDTOList;
    }

    public List<ApplicationAnalyzesDTO> getAllApplicationAnalyzesByUserId(Long userId){
       List<ApplicationAnalyzesDTO> applicationAnalyzesDTOS = applicationAnalyzesMapper.toDtoList(applicationAnalyzesRepository.findAllByUserId(userId));
       return applicationAnalyzesDTOS;
    }


}

