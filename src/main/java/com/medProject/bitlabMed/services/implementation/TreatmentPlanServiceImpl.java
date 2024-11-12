package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.TreatmentPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreatmentPlanServiceImpl {

    private final TreatmentPlanRepository treatmentPlanRepository;
}
