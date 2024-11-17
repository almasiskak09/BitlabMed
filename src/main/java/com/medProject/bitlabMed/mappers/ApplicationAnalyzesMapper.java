package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.ApplicationAnalyzes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationAnalyzesMapper {

    ApplicationAnalyzesDTO toDto(ApplicationAnalyzes applicationAnalyzes);
    ApplicationAnalyzes toEntity(ApplicationAnalyzesDTO applicationAnalyzesDTO);
    List<ApplicationAnalyzesDTO> toDtoList(List<ApplicationAnalyzes> applicationAnalyzes);
    List<ApplicationAnalyzes> toEntityList(List<ApplicationAnalyzesDTO> applicationAnalyzesDTO);
}
