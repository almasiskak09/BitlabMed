package com.medProject.bitlabMed.dtos.DoctorDto;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.Doctor.Doctor;
import com.medProject.bitlabMed.entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDoctorDto extends BaseEntity {

    private Long id;
    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;
    private String patientPhone;
    private String patientFullName;
    private Long doctorId;
    private Long userId;
    private boolean isBooked;



}
