package com.medProject.bitlabMed.entities.Diagnostic;

import com.medProject.bitlabMed.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
public class DiagnosticCategory extends BaseEntity {

    @Column(name = "diagnostic_category_name")
    private String diagnosticCategoryName;

    @OneToMany(mappedBy = "diagnosticCategory",fetch = FetchType.LAZY)
    private List<Diagnostic> diagnosticList;
}
