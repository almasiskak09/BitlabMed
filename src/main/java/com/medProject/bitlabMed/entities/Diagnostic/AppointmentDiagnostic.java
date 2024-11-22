package com.medProject.bitlabMed.entities.Diagnostic;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment_diagnostic")
public class AppointmentDiagnostic extends BaseEntity {


    @Column(name = "patient_full_name")
    private String patientFullName;

    @Column(name = "patient_phone")
    private String patientPhone;

    @ManyToOne
    @JoinColumn(name = "diagnostic_id")
    private Diagnostic diagnostic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "is_present")
    private boolean isPresent;



}
