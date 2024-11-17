package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.*;
import com.medProject.bitlabMed.entities.Analyzes;
import com.medProject.bitlabMed.entities.AnalyzesCategory;
import com.medProject.bitlabMed.services.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DoctorService doctorService;
    private final AnalyzesService analyzesService;
    private final AnalyzesCategoryService analyzesCategoryService;
    private final DiagnosticService diagnosticService;
    private final DiagnosticCategoryService diagnosticCategoryService;


    @GetMapping(value = "/home")
    public String home(Model model){
        return "home";
    }
    @GetMapping(value = "/doctors")
    public String doctorsPage(Model model){
        List<DoctorDTO>doctorList = doctorService.getAllDoctors();
        model.addAttribute("doctorsList",doctorList);


        return "doctors";
    }
    @GetMapping(value = "/analyses")
    public String analysesPage(Model model, HttpSession httpSession){
        List<AnalyzesDTO>analyzesDTOList = analyzesService.getAllAnalyzes();
        List<AnalyzesCategoryDTO> analyzesCategoryDTOList = analyzesCategoryService.getAllAnalyzesCategory();

        model.addAttribute("analyzesList",analyzesDTOList);
        model.addAttribute("analyzesCategoryList",analyzesCategoryDTOList);

        List<Long> addedAnalyzes = (List<Long>) httpSession.getAttribute("addedAnalyzes");
        if (addedAnalyzes == null) {
            addedAnalyzes = new ArrayList<>();
            httpSession.setAttribute("addedAnalyzes", addedAnalyzes);
        }
        model.addAttribute("addedAnalyzes", addedAnalyzes);

        return "analyses";

    }

    @GetMapping(value = "/diagnostic")
    public String diagnosticPage(Model model){
        List<DiagnosticDTO>diagnosticDTOList = diagnosticService.getAllDiagnostics();
        List<DiagnosticCategoryDTO>diagnosticCategoryDTOList = diagnosticCategoryService.getAllDiagnosticsCategory();

        model.addAttribute("diagnosticList",diagnosticDTOList);
        model.addAttribute("diagnosticCategoryList",diagnosticCategoryDTOList);

        return "diagnostic";
    }


}
