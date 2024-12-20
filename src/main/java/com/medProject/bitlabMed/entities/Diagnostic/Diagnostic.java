package com.medProject.bitlabMed.entities.Diagnostic;

import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diagnostic extends BaseEntity {

    @Column(name = "diagnostic_name")
    private String diagnosticName;

    @Column(name = "diagnostic_completed_date")
    private String diagnosticCompletedDate;

    @Column(name = "diagnostic_price")
    private int diagnosticPrice;

    @ManyToOne
    @JoinColumn(name = "diagnostic_category_id")
    private DiagnosticCategory diagnosticCategory;

}
