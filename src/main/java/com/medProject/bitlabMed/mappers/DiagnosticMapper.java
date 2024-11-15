package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.DiagnosticDTO;
import com.medProject.bitlabMed.entities.Diagnostic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosticMapper {

    @Mapping(source = "diagnosticCategory.id",target = "diagnosticCategoryId")
    DiagnosticDTO toDto(Diagnostic diagnostic);
    Diagnostic toEntity(DiagnosticDTO diagnosticDTO);
    List<DiagnosticDTO> toDtoList(List<Diagnostic> diagnostics_list);
    List<Diagnostic> toEntityList(List<DiagnosticDTO> diagnosticDTOList);
}
