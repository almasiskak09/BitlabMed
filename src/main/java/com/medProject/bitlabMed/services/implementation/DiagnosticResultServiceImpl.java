package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.DiagnosticResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiagnosticResultServiceImpl {

    private final DiagnosticResultRepository diagnosticResultRepository;
}
