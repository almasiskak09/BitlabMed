package com.medProject.bitlabMed.dtos.DoctorDto;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.utils.PriceFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO extends BaseEntity {

    private String doctorName;
    private String doctorSpeciality;
    private String doctorYearsOfExperience;
    private int doctorPrice;
    private String doctorAddress;
    private String doctorProfilePicture;
    private String doctorRating;
    private String doctorPhone;
    private String doctorWorkingHours;
    private String doctorDescription;

    public String getFormattedPrice(){
        return PriceFormatter.formatPrice(doctorPrice);
    }
}
