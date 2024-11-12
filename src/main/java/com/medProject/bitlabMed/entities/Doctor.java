package com.medProject.bitlabMed.entities;

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
@Table(name = "doctors")
public class Doctor extends BaseEntity{

    @Column(name = "doctor_name")
    private String doctor_name;

    @Column(name = "doctor_speciality")
    private String doctor_speciality;

    @Column(name = "doctor_years_of_experience")
    private String doctor_years_of_experience;

    @Column(name = "doctor_price")
    private int doctor_price;

    @Column(name = "doctor_address")
    private String doctor_address;

    @Column(name = "doctor_profile_picture")
    private String doctor_profile_picture;

    @Column(name = "doctor_rating")
    private String doctor_rating;

    @Column(name = "doctor_working_hours")
    private String doctor_working_hours;

    @Column(name = "doctor_description")
    private String doctor_description;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<ApplicationRequest> application_request_list;

}
