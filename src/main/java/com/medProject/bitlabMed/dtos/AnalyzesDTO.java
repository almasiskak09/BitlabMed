package com.medProject.bitlabMed.dtos;


import com.medProject.bitlabMed.utils.PriceFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzesDTO {

    private Long id;
    private String analyzesName;
    private int analyzesPrice;
    private String analyzesReadyDate;
    private Long analyzesCategoryId;

    public String getFormattedPrice(){
            return PriceFormatter.formatPrice(analyzesPrice);
    }
}
