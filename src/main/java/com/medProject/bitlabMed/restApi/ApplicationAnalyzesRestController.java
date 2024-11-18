package com.medProject.bitlabMed.restApi;

import com.medProject.bitlabMed.dtos.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/application-analyzes")
public class ApplicationAnalyzesRestController {

    private final ApplicationAnalyzesService applicationAnalyzesService;

    @GetMapping(value = "/getAllApplicationAnalyzes")
    public List<ApplicationAnalyzesDTO> getAllApplicationAnalyzes(){
        return applicationAnalyzesService.getAllApplicationAnalyzes();
    }
}
