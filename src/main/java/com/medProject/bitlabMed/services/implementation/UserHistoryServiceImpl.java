package com.medProject.bitlabMed.services.implementation;

import com.medProject.bitlabMed.repositories.UserHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHistoryServiceImpl {

    private final UserHistoryRepository userHistoryRepository;
}
