package com.medProject.bitlabMed.dtos.UserDto;

import com.medProject.bitlabMed.entities.Analyzes.ApplicationAnalyzes;
import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.Doctor.AppointmentDoctor;
import com.medProject.bitlabMed.entities.User.Permission;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseEntity  {

    private String email;
    private String password;
    private String fullName;
    private String phone;
    private List<Permission> roles;
    private List<ApplicationAnalyzes> ApplicationAnalyzesList;
    private List <AppointmentDoctor> appointmentDoctorList;
//    private List<UserHistoryDTO>userHistoryList;
//    private List<TreatmentPlanDTO>treatmentPlanList;

}