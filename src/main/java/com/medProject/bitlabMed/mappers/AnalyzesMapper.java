package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.AnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" )
public interface AnalyzesMapper {

    @Mapping(source = "analyzesCategory.id", target = "analyzesCategoryId")
    AnalyzesDTO toDto(Analyzes analyzes);
    Analyzes toEntity(AnalyzesDTO analyzesDTO);
    List<AnalyzesDTO> toDtoList(List<Analyzes> analyzesList);
    List<Analyzes>toEntityList(List<AnalyzesDTO>analyzesDtoList);

}
