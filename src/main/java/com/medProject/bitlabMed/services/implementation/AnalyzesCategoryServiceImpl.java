package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.AnalyzesCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyzesCategoryServiceImpl {

    private final AnalyzesCategoryRepository analyzesCategoryRepository;
}
