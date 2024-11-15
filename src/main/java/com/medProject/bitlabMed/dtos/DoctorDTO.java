package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.utils.PriceFormatter;
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

    private String doctorName;
    private String doctorSpeciality;
    private String doctorYearsOfExperience;
    private int doctorPrice;
    private String doctorAddress;
    private String doctorProfilePicture;
    private String doctorRating;
    private String doctorWorkingHours;
    private String doctorDescription;
//    private List<ApplicationRequestDTO> application_request_list;

    public String getFormattedPrice(){
        return PriceFormatter.formatPrice(doctorPrice);
    }
}
