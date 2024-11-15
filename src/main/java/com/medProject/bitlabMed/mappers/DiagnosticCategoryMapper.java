package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DiagnosticCategoryDTO;
import com.medProject.bitlabMed.entities.DiagnosticCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosticCategoryMapper {

    DiagnosticCategoryDTO toDto(DiagnosticCategory diagnosticCategory);
    DiagnosticCategory toEntity(DiagnosticCategoryDTO diagnosticCategoryDTO);
    List<DiagnosticCategoryDTO> toDtoList(List<DiagnosticCategory> diagnosticCategories);
    List<DiagnosticCategory> toEntityList(List<DiagnosticCategoryDTO> diagnosticCategoryDTOS);


}


