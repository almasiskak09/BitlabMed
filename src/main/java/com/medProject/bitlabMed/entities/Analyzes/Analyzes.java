package com.medProject.bitlabMed.entities.Analyzes;

import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.*;
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
public class Analyzes extends BaseEntity {

    @Column(name = "analyzes_name")
    private String analyzesName;

    @Column(name = "analyzes_price")
    private int analyzesPrice;

    @Column(name = "analyzes_ready_date")
    private String analyzesReadyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analyzes_category_id")
    private AnalyzesCategory analyzesCategory;

    @ManyToMany(mappedBy = "apAnalyzesList")
    private List<ApplicationAnalyzes> ApplicationAnalyzesList;

}
