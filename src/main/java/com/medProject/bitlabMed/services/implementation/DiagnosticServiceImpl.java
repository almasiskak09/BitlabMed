package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.DiagnosticRepository;
import com.medProject.bitlabMed.services.DiagnosticService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosticServiceImpl {

    private final DiagnosticRepository diagnosticRepository;
}
