package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.entities.Analyzes.AnalyzesCategory;
import com.medProject.bitlabMed.mappers.AnalyzesCategoryMapper;
import com.medProject.bitlabMed.repositories.AnalyzesCategoryRepository;
import com.medProject.bitlabMed.services.AnalyzesCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzesCategoryServiceImpl implements AnalyzesCategoryService {

    private final AnalyzesCategoryRepository analyzesCategoryRepository;
    private final AnalyzesCategoryMapper analyzesCategoryMapper;

    public List<AnalyzesCategoryDTO> getAllAnalyzesCategory(){
        List<AnalyzesCategory>AC = analyzesCategoryRepository.findAll();
        return analyzesCategoryMapper.toDtoList(AC);
    }

    public AnalyzesCategoryDTO addAnalyzeCategory (AnalyzesCategoryDTO analyzesCategoryDTO){
        AnalyzesCategory analyzesCategory = analyzesCategoryMapper.toEntity(analyzesCategoryDTO);
        analyzesCategoryRepository.save(analyzesCategory);
        return analyzesCategoryMapper.toDTO(analyzesCategory);

    }
    public AnalyzesCategoryDTO getAnalyzeCategoryById(Long id){
         AnalyzesCategory analyzesCategory = analyzesCategoryRepository.findById(id).orElseThrow(null);
          return analyzesCategoryMapper.toDTO(analyzesCategory);
    }
    public AnalyzesCategoryDTO updateAnalyzeCategory(AnalyzesCategoryDTO analyzesCategoryDTO){
        AnalyzesCategory analyzesCategory = analyzesCategoryMapper.toEntity(analyzesCategoryDTO);
        analyzesCategoryRepository.save(analyzesCategory);
        return analyzesCategoryMapper.toDTO(analyzesCategory);
    }
    public void deleteAnalyzeCategoryById(Long id){
        analyzesCategoryRepository.deleteById(id);
    }

    public     List<AnalyzesCategoryDTO> searchAnalyzesCategoryByAnalyzeName(String analyze){
        List<AnalyzesCategoryDTO> analyzesCategoryDTOList = analyzesCategoryMapper.toDtoList(analyzesCategoryRepository.findAnalyzesCategoryByAnalyzeName(analyze.toLowerCase()));
        return analyzesCategoryDTOList;
    }
}