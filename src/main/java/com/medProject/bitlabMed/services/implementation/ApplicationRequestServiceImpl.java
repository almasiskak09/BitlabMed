package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.ApplicationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationRequestServiceImpl {

    private final ApplicationRequestRepository applicationRequestRepository;
}
