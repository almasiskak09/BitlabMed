package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl {

    private final ClinicRepository clinicRepository;
}
