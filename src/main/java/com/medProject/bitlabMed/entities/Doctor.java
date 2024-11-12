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
public class Doctor extends BaseEntity{

    private String doctorName;
    private String doctorSpeciality;
    private String doctorYearsOfExperience;
    private int doctorPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ApplicationRequest> applicationRequestList;

}
