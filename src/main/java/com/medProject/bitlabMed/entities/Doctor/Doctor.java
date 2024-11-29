package com.medProject.bitlabMed.entities.Doctor;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.User.User;
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
public class Doctor extends BaseEntity {

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "doctor_speciality")
    private String doctorSpeciality;

    @Column(name = "doctor_years_of_experience")
    private String doctorYearsOfExperience;

    @Column(name = "doctor_price")
    private int doctorPrice;

    @Column(name = "doctor_address")
    private String doctorAddress;

    @Column(name = "doctor_profile_picture")
    private String doctorProfilePicture;

    @Column(name = "doctor_rating")
    private String doctorRating;

    @Column(name = "doctor_working_hours")
    private String doctorWorkingHours;

    @Column(name = "doctor_phone")
    private String doctorPhone;

    @Column(name = "doctor_description")
    private String doctorDescription;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentDoctor> appointmentList;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<ApplicationRequest> application_request_list;

}
