package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DiagnosticDto.DiagnosticCategoryDTO;
import com.medProject.bitlabMed.entities.Diagnostic.DiagnosticCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosticCategoryMapper {

    DiagnosticCategoryDTO toDto(DiagnosticCategory diagnosticCategory);
    DiagnosticCategory toEntity(DiagnosticCategoryDTO diagnosticCategoryDTO);
    List<DiagnosticCategoryDTO> toDtoList(List<DiagnosticCategory> diagnosticCategories);
    List<DiagnosticCategory> toEntityList(List<DiagnosticCategoryDTO> diagnosticCategoryDTOS);


}


