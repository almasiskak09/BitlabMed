package com.medProject.bitlabMed.entities.Analyzes;

import com.medProject.bitlabMed.entities.BaseEntity;
import com.medProject.bitlabMed.entities.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationAnalyzes extends BaseEntity {

    @Column(name = "application_analyzes_user_full_name")
    private String apUserFullName;
    @Column(name = "application_analyzes_user_phone")
    private String apUserPhone;
    @Column(name = "application_analyzes_total_price")
    private int apTotalPrice;
    @Column(name = "application_analyzes_created_date", nullable = false)
    private LocalDate apCreatedDate;


    @ManyToMany
    @JoinTable(name = "application_analyzes_analyzes_table_relationship",
    joinColumns = @JoinColumn(name = "application_analyzes_id"),
    inverseJoinColumns = @JoinColumn(name = "analyzes_id"))
    private List<Analyzes> apAnalyzesList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "is_handled")
    private boolean isHandled;

}
