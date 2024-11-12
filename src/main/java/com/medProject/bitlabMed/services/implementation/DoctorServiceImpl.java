package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl {

    private final DoctorRepository doctorRepository;
}
