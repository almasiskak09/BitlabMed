package com.medProject.bitlabMed.entities;

import jakarta.persistence.Entity;
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

    private String diagnosticName;
    private LocalDate diagnosticCompletedDate;
    private int diagnosticPrice;
    private boolean diagnosticStatus;

}
