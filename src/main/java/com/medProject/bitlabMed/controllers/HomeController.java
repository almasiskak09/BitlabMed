package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesCategoryDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.DiagnosticDto.DiagnosticCategoryDTO;
import com.medProject.bitlabMed.dtos.DiagnosticDto.DiagnosticDTO;
import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;
import com.medProject.bitlabMed.repositories.AppointmentDoctorRepository;
import com.medProject.bitlabMed.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DoctorService doctorService;
    private final AnalyzesService analyzesService;
    private final AnalyzesCategoryService analyzesCategoryService;
    private final DiagnosticService diagnosticService;
    private final DiagnosticCategoryService diagnosticCategoryService;
    private final AppointmentDoctorService appointmentDoctorService;
    private final ApplicationAnalyzesService applicationAnalyzesService;
    private final AppointmentDiagnosticService appointmentDiagnosticService;


    @GetMapping(value = "/home")
    public String home(Model model){
        return "home";
    }

    //    отображение страницы с анализами (HTML)
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

    //    отображение страницы с диагностиками (HTML)
    @GetMapping(value = "/diagnostic")
    public String diagnosticPage(Model model){
        List<DiagnosticDTO>diagnosticDTOList = diagnosticService.getAllDiagnostics();
        List<DiagnosticCategoryDTO>diagnosticCategoryDTOList = diagnosticCategoryService.getAllDiagnosticsCategory();

        model.addAttribute("diagnosticList",diagnosticDTOList);
        model.addAttribute("diagnosticCategoryList",diagnosticCategoryDTOList);

        return "diagnostic";
    }


    //    отображение страницы с докторами (HTML)
    @GetMapping(value = "/doctors")
    public String doctorsPage(Model model,@RequestParam(required = false) String search) {
        List<DoctorDTO> doctorList;

        if(search != null && !search.isEmpty()){
            doctorList = doctorService.getDoctorsBySpeciality(search);
        }else{
            doctorList = doctorService.getAllDoctors();
        }
        model.addAttribute("doctorsList", doctorList);
        return "doctors";
    }


    //    отображение страницы после заявки к доктору (HTML)
    @GetMapping(value = {"/app-doctor/{id}", "/app-doctor"})
    public String appointmentDoctorPage(Model model,
                                        @PathVariable(required = false) Long id,
                                        @RequestParam(value = "success", required = false) String success) {
        if (id != null) {
            AppointmentDoctorDto appointment = appointmentDoctorService.getAppointmentDoctorById(id);
            DoctorDTO doctor = doctorService.getDoctorById(appointment.getDoctorId());

            model.addAttribute("appointment", appointment);
            model.addAttribute("doctor", doctor);
        }

        model.addAttribute("success", success);

        return "app-doctor";
    }

    //    отображение страницы с корзиной (HTML)
    @GetMapping("/cart")
    public String getCart(HttpSession httpSession, Model model) {
        List<AnalyzesDTO> cart = (List<AnalyzesDTO>) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            httpSession.setAttribute("cart", cart);
        }

        int totalPrice = 0;
        for (AnalyzesDTO cart1 : cart) {
            totalPrice += cart1.getAnalyzesPrice();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);

        return "cart";
    }

    @PostMapping(value = "/deleteAppointmentDoctor")
    public String deleteAppointment(@RequestParam Long id, HttpServletRequest request) {
        appointmentDoctorService.deleteAppointmentDoctorById(id);

        String referer = request.getHeader("referer");
        return "redirect:"+referer;
    }

    @PostMapping(value = "/updateAppointmentDoctor")
    public String updateAppointment(@RequestParam Long id) {
        AppointmentDoctorDto appointmentDoctorDto = appointmentDoctorService.getAppointmentDoctorById(id);
        appointmentDoctorDto.setHandled(true);
        appointmentDoctorService.updateAppointmentDoctor(appointmentDoctorDto);
        return "redirect:/profile-manager";
    }
    @PostMapping(value = "/updateAppointmentDoctorIsPresent")
    public String updateAppointmentIsPresent(@RequestParam Long id,HttpServletRequest request) {
        AppointmentDoctorDto appointmentDoctorDto = appointmentDoctorService.getAppointmentDoctorById(id);
        appointmentDoctorDto.setPresent(true);
        appointmentDoctorService.updateAppointmentDoctor(appointmentDoctorDto);

        String referer = request.getHeader("referer");
        return "redirect:"+referer;
    }


    @PostMapping(value = "/deleteAppointmentAnalyze")
    public String deleteAppointmentAnalyze(@RequestParam Long id) {
        applicationAnalyzesService.deleteApplicationAnalyzesById(id);
        return "redirect:/profile-manager";
    }
    @PostMapping(value = "/updateAppointmentAnalyze")
    public String updateAppointmentAnalyze(@RequestParam Long id) {
        applicationAnalyzesService.updateApplicationAnalyzes(id);
        return "redirect:/profile-manager";
    }

    @PostMapping(value = "/deleteAppointmentDiagnostic")
    public String deleteAppointmentDiagnostic(@RequestParam Long id) {
        appointmentDiagnosticService.deleteAppointmentDiagnosticById(id);
        return "redirect:/profile-manager";
    }

    @PostMapping(value = "/updateAppointmentDiagnostic")
    public String updateAppointmentDiagnostic(@RequestParam Long id) {
        appointmentDiagnosticService.updateAppointmentDiagnostic(id);
        return "redirect:/profile-manager";
    }

}
