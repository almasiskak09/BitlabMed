package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.ApplicationAnalyzes;
import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.Permission;
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

//    private List<UserHistoryDTO>userHistoryList;
//    private List<TreatmentPlanDTO>treatmentPlanList;

}