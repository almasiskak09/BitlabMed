package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationAnalyzesService applicationAnalyzesService;

    @PostMapping(value = "/addApplication")
    public String addApplication(@ModelAttribute ApplicationAnalyzesDTO applicationAnalyzesDTO, Model model, HttpSession httpSession) {

        if (applicationAnalyzesDTO.getApCreatedDate() == null) {
            applicationAnalyzesDTO.setApCreatedDate(LocalDate.now());
        }
        System.out.println(applicationAnalyzesDTO.getApUserPhone());
        System.out.println(applicationAnalyzesDTO.getApUserFullName());
        System.out.println(applicationAnalyzesDTO.getApTotalPrice());
        System.out.println(applicationAnalyzesDTO.getApCreatedDate());
        System.out.println(applicationAnalyzesDTO.getAnalyzesIds());
        System.out.println(applicationAnalyzesDTO.getUserIds());
        applicationAnalyzesService.addApplicationAnalyzes(applicationAnalyzesDTO);
        return "redirect:/cart";
    }

}
