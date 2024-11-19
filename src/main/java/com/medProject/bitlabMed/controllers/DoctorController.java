package com.medProject.bitlabMed.controllers;

import com.medProject.bitlabMed.dtos.DoctorDto.AppointmentDoctorDto;
import com.medProject.bitlabMed.dtos.DoctorDto.DoctorDTO;
import com.medProject.bitlabMed.entities.User.User;
import com.medProject.bitlabMed.repositories.UserRepository;
import com.medProject.bitlabMed.services.AppointmentDoctorService;
import com.medProject.bitlabMed.services.DoctorService;
import com.medProject.bitlabMed.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DoctorController {


    private final DoctorService doctorService;
    private final AppointmentDoctorService appointmentDoctorService;
    private final UserRepository userRepository;

    @GetMapping(value = "/doctors")
    public String doctorsPage(Model model){
        List<DoctorDTO> doctorList = doctorService.getAllDoctors();
        model.addAttribute("doctorsList",doctorList);
        return "doctors";
    }

    @GetMapping("/week-schedule")
    @ResponseBody
    public Map<LocalDate, List<LocalTime>> getWeekSchedule(
            @RequestParam Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        return appointmentDoctorService.getWeekSchedule(doctorId, startDate);
    }

    @PostMapping("/addAppointmentDoctor")
    public String addAppointmentDoctor (@ModelAttribute AppointmentDoctorDto appointmentDoctorDto) {

        // Получение текущего пользователя через SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() &&
                !(authentication instanceof AnonymousAuthenticationToken)) {
            // Пользователь залогинен
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByEmail(userDetails.getUsername()); // Поиск пользователя в базе
            if (user != null) {
                // Установка ID пользователя
                appointmentDoctorDto.setUserId(user.getId());
            }
        }

        appointmentDoctorService.addAppointmentDoctor(appointmentDoctorDto);
      return "/doctors";

    }


}
