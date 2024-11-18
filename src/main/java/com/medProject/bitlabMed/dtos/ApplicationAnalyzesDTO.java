package com.medProject.bitlabMed.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medProject.bitlabMed.entities.Analyzes;
import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationAnalyzesDTO {

    private Long id;
    private String apUserFullName;
    private String apUserPhone;
    private int apTotalPrice;
    private LocalDate apCreatedDate;
    private List<Long> analyzesIds;
    private Long userId;

}
