package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.AnalyzesDto.AnalyzesDTO;
import com.medProject.bitlabMed.dtos.AnalyzesDto.ApplicationAnalyzesDTO;
import com.medProject.bitlabMed.dtos.DiagnosticDto.AppointmentDiagnosticDto;
import com.medProject.bitlabMed.dtos.DiagnosticDto.DiagnosticDTO;
import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.entities.User.User;
import com.medProject.bitlabMed.mappers.AnalyzesMapper;
import com.medProject.bitlabMed.services.ApplicationAnalyzesService;
import com.medProject.bitlabMed.services.AppointmentDiagnosticService;
import com.medProject.bitlabMed.services.AppointmentDoctorService;
import com.medProject.bitlabMed.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AppointmentDoctorService appointmentDoctorService;
    private final ApplicationAnalyzesService applicationAnalyzesService;
    private final AppointmentDiagnosticService appointmentDiagnosticService;

    @GetMapping(value = "/sign-in")
    @PreAuthorize("isAnonymous()")
    public String loginPage(Model model) {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    @PreAuthorize("isAnonymous()")
    public String signUp(Model model) {
        return "sign-up";
    }

    @PostMapping("/registration")
    @PreAuthorize("isAnonymous()")
    public String registration(@RequestParam(name = "user_email") String email,
                               @RequestParam(name = "user_password") String password,
                               @RequestParam(name = "user_repeat_password") String repeatPassword,
                               @RequestParam(name = "user_full_name") String fullName,
                               @RequestParam(name = "user_phone") String phone) {
        Boolean result = userService.signUp(email, password, repeatPassword, fullName, phone);
        //result = false/true/null;

        if (result != null) {
            if (result) {
                return "redirect:/sign-up?success";
            }
            return "redirect:/sign-up?passwordError";
        }
        return "redirect:/sign-up?emailError";
    }

    @GetMapping("/change-password")
    @PreAuthorize("isAuthenticated()")
    public String changePassword(Model model) {
        return "change-password";
    }

    @PostMapping("/save-password")
    @PreAuthorize("isAuthenticated()")
    public String savePassword(@RequestParam(name = "user_old_password") String oldPassword,
                               @RequestParam(name = "user_new_password") String newPassword,
                               @RequestParam(name = "user_repeat_new_password") String repeatPassword) {
        Boolean result = userService.updatePassword(oldPassword, newPassword, repeatPassword);

        if (result != null) {
            if (result) {
                return "redirect:/change-password?success";
            }
            return "redirect:/change-password?newPasswordError";
        }
        return "redirect:/change-password?oldPasswordError";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        List<AppointmentDoctorDto> appointmentDoctorDtoList = appointmentDoctorService.getAllAppointmentDoctorListByUserId(user.getId());
        model.addAttribute("appointmentDoctorDtoList",appointmentDoctorDtoList);

        List<AppointmentDiagnosticDto>appointmentDiagnosticDtoList = appointmentDiagnosticService.getAppointmentDiagnosticsByUserId(user.getId());
        model.addAttribute("appointmentDiagnosticDtoList",appointmentDiagnosticDtoList);


        List<ApplicationAnalyzesDTO>applicationAnalyzesDTOS = applicationAnalyzesService.getAllApplicationAnalyzesByUserId(user.getId());
        model.addAttribute("applicationAnalyzesDTOS2",applicationAnalyzesDTOS);

        Map<Long,List<AnalyzesDTO>> analyzesMap2 = new HashMap<>();
        for(ApplicationAnalyzesDTO app : applicationAnalyzesDTOS){
            List<AnalyzesDTO> analyzesDTOList = applicationAnalyzesService.getAllAnalyzesByIds(app.getAnalyzesIds());
            analyzesMap2.put(app.getId(),analyzesDTOList);
        }
        model.addAttribute("analyzesMap2",analyzesMap2);


        model.addAttribute("user", user);
        return "/profile";
    }

    @GetMapping(value = "/profile-doctor")
    public String profileDoctor(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        model.addAttribute("user", user);
        return "/profile-doctor";
    }

    @GetMapping(value = "/profile-manager")
    public String profileManager(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("user", user);

//        Доктор
        List<AppointmentDoctorDto> appointmentDoctorDtoList = appointmentDoctorService.getAllAppointmentDoctorsList();
        model.addAttribute("appointmentDoctorsList", appointmentDoctorDtoList);

//        Анализы
        List<ApplicationAnalyzesDTO> applicationAnalyzesDTOS = applicationAnalyzesService.getAllApplicationAnalyzes();
        model.addAttribute("applicationAnalyzesDTOS", applicationAnalyzesDTOS);


        Map<Long,List<AnalyzesDTO>> analyzesMap = new HashMap<>();
        for(ApplicationAnalyzesDTO app : applicationAnalyzesDTOS){
            List<AnalyzesDTO> analyzesDTOList = applicationAnalyzesService.getAllAnalyzesByIds(app.getAnalyzesIds());
            analyzesMap.put(app.getId(),analyzesDTOList);
        }
        model.addAttribute("analyzesMap",analyzesMap);

//        Диагностика
       List<AppointmentDiagnosticDto> appointmentDiagnosticDto = appointmentDiagnosticService.getAllAppointmentDiagnosticList();
       model.addAttribute("appointmentDiagnosticDto", appointmentDiagnosticDto);


        return "/profile-manager";
    }




}
