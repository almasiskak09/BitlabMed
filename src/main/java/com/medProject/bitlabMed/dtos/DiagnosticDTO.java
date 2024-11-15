package com.medProject.bitlabMed.dtos;

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
public class DiagnosticDTO extends BaseEntity {

    private String diagnosticName;
    private String diagnosticCompletedDate;
    private int diagnosticPrice;

    private Long diagnosticCategoryId;

    public String getFormattedPrice(){
        return PriceFormatter.formatPrice(diagnosticPrice);
    }


}
