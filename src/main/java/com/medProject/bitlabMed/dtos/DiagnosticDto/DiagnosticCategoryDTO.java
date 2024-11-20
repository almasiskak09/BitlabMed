
package com.medProject.bitlabMed.dtos.DiagnosticDto;


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
public class DiagnosticCategoryDTO extends BaseEntity {

    private String diagnosticCategoryName;

    private List<DiagnosticDTO> diagnosticList;
}
