package com.medProject.bitlabMed.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
