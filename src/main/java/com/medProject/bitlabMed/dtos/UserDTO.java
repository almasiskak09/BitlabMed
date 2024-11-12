package com.medProject.bitlabMed.dtos;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO extends BaseEntity  {

    private String email;
    private String password;
    private String full_name;
    private String phone;
//    private List<Permission> roles;
//    private List<UserHistoryDTO>userHistoryList;
//    private List<TreatmentPlanDTO>treatmentPlanList;

}