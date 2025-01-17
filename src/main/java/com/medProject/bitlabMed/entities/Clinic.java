package com.medProject.bitlabMed.entities;

import com.medProject.bitlabMed.entities.Analyzes.AnalyzesCategory;
import com.medProject.bitlabMed.entities.Diagnostic.Diagnostic;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import com.medProject.bitlabMed.entities.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
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
public class Clinic extends BaseEntity {

    private String clinicName;
    private String clinicAddress;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User>clinicUsersList;

    @OneToMany
    private List<Doctor> doctorList;

    @OneToMany
    private List<AnalyzesCategory>analyzesCategoryList;

    @OneToMany
    private List<Diagnostic>diagnosticList;
}
