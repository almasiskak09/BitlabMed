package com.medProject.bitlabMed.mappers;

import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.entities.Analyzes.Analyzes;
import com.medProject.bitlabMed.entities.Analyzes.ApplicationAnalyzes;
import com.medProject.bitlabMed.entities.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ApplicationAnalyzesMapper {

    @Mapping(target = "apAnalyzesList", source = "analyzesIds", qualifiedByName = "idsToAnalyzes")
    @Mapping(target = "user", source = "userId", qualifiedByName = "idToUser")
    ApplicationAnalyzes toEntity(ApplicationAnalyzesDTO dto);

    @Mapping(target = "analyzesIds", source = "apAnalyzesList", qualifiedByName = "analyzesToIds")
    @Mapping(target = "userId", source = "user.id")
    ApplicationAnalyzesDTO toDto(ApplicationAnalyzes entity);

    @Named("idsToAnalyzes")
    default List<Analyzes> idsToAnalyzes(List<Long> ids) {
        // Реализация преобразования id -> объекты Analyzes
        return ids != null ? ids.stream()
                .map(id -> {
                    Analyzes analyzes = new Analyzes();
                    analyzes.setId(id);
                    return analyzes;
                })
                .toList() : null;
    }

    @Named("analyzesToIds")
    default List<Long> analyzesToIds(List<Analyzes> analyzesList) {
        // Реализация преобразования объектов Analyzes -> id
        return analyzesList != null ? analyzesList.stream()
                .map(Analyzes::getId)
                .toList() : null;
    }

    @Named("idToUser")
    default User idToUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }

    List<ApplicationAnalyzesDTO> toDtoList(List<ApplicationAnalyzes> applicationAnalyzesList);
}
