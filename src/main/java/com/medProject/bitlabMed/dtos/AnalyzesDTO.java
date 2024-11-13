package com.medProject.bitlabMed.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medProject.bitlabMed.entities.AnalyzesCategory;
import com.medProject.bitlabMed.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzesDTO extends BaseEntity {

    private String analyzes_name;
    private int analyzes_price;
    private String analyzes_ready_date;
    @JsonIgnore
    private AnalyzesCategory analyzesCategory;


}
