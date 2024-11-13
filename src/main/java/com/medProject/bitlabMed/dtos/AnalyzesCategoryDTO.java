package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.Analyzes;
import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzesCategoryDTO extends BaseEntity {

    private String analyzes_category_name;
    private List<Analyzes> analyzes_list;
}
