package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO extends BaseEntity {

    private String doctor_name;
    private String doctor_speciality;
    private String doctor_years_of_experience;
    private int doctor_price;
    private String doctor_address;
    private String doctor_profile_picture;
    private String doctor_rating;
    private String doctor_working_hours;
    private String doctor_description;
//    private List<ApplicationRequestDTO> application_request_list;

}
