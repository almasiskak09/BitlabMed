package com.medProject.bitlabMed.entities.Doctor;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment_doctor")
public class AppointmentDoctor extends BaseEntity {

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_start_time")
    private LocalTime appointmentStartTime;

    @Column(name = "patient_full_name")
    private String patientFullName;

    @Column(name = "patient_phone")
    private String patientPhone;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = true)
    private User user;

    @Column(name = "is_booked")
    private boolean isBooked;

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        // Обнуляем секунды и наносекунды перед сохранением
        this.appointmentStartTime = appointmentStartTime.withSecond(0).withNano(0);
    }
}
