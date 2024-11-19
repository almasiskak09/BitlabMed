package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.entities.Analyzes.AnalyzesCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnalyzesCategoryMapper {

    AnalyzesCategoryDTO toDTO(AnalyzesCategory analyzesCategory);
    AnalyzesCategory toEntity(AnalyzesCategoryDTO analyzesCategoryDTO);
    List<AnalyzesCategoryDTO> toDtoList(List<AnalyzesCategory> analyzesCategories);
    List<AnalyzesCategory> toEntityList(List<AnalyzesCategoryDTO> analyzesCategoriesDTO);
}
