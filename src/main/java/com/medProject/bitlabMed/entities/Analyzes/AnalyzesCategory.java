package com.medProject.bitlabMed.entities.Analyzes;

import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.Column;
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
public class AnalyzesCategory extends BaseEntity {

    @Column(name = "analyzes_category_name")
    private String analyzesCategoryName;

    @OneToMany(mappedBy = "analyzesCategory", fetch = FetchType.LAZY)
    private List<Analyzes> analyzesList;
}
