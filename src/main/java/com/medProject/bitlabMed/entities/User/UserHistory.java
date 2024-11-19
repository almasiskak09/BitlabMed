package com.medProject.bitlabMed.entities.User;

import com.medProject.bitlabMed.entities.ApplicationRequest;
import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.TreatmentPlan;
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
public class UserHistory extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ApplicationRequest>applicationRequestList;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TreatmentPlan>treatmentPlanList;
}
