package com.medProject.bitlabMed.services.implementation;


import com.medProject.bitlabMed.repositories.AnalyzesRepository;
import com.medProject.bitlabMed.services.AnalyzesService;
import com.medProject.bitlabMed.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyzesServiceImpl implements AnalyzesService {

    @Autowired
    private final AnalyzesRepository analyzesRepository;


}
