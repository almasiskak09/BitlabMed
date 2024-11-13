package com.medProject.bitlabMed.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analyzes extends BaseEntity {

    private String analyzes_name;
    private int analyzes_price;
    private String analyzes_ready_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analyzes_category_id")
    @JsonIgnore
    private AnalyzesCategory analyzesCategory;
}
