package com.medProject.bitlabMed.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzesCategory extends BaseEntity{

    private String analysisCategoryName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Analyzes> analyzesList;
}
