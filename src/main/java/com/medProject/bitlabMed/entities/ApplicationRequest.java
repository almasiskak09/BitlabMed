package com.medProject.bitlabMed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest extends BaseEntity{

    @OneToOne(fetch = FetchType.LAZY)
    private Clinic clinic;

    @OneToOne(fetch = FetchType.LAZY)
    private Doctor applicationDoctor;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AnalyzesCategory> applicationAnalysesCategory;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Diagnostic> applicationDiagnosticList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate applicationDate;
    private boolean applicationBooked; //сделать запись иди удалить
    private boolean applicationDone; //пришел ли клиент на запись или нет ?
}
