package com.medProject.bitlabMed.dtos.UserDto;

import com.medProject.bitlabMed.dtos.ApplicationRequestDTO;
import com.medProject.bitlabMed.dtos.TreatmentPlanDTO;
import com.medProject.bitlabMed.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserHistoryDTO extends BaseEntity {

    private List<ApplicationRequestDTO>applicationRequestList;
    private List<TreatmentPlanDTO>treatmentPlanList;
}
